package com.adobe.aem.cara.apps.core.filters;

import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component(service = UniversitiesService.class, immediate = true)
@Designate(ocd = UniversitiesApiConfig.class)
public class UniversitiesService {

    private String apiUrl;

    @Activate
    @Modified
    protected void activate(UniversitiesApiConfig config) {
        this.apiUrl = config.apiUrl();
    }

    public String[] getUniversities(String country) {
        try {
            String fullUrl = apiUrl  + country;
            URL url = new URL(fullUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                JSONArray jsonArray = new JSONArray(response.toString());
                String[] names = new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    names[i] = obj.getString("name");
                }
                return names;
            }
        } catch (Exception e) {
            return new String[]{"Error fetching universities"};
        }
    }
}
