package com.adobe.aem.cara.apps.core.models;

import com.adobe.aem.cara.apps.core.filters.UniversitiesService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = {Resource.class,SlingHttpServletRequest.class})
public class UniversitiesModel{

    private static final Logger logger = LoggerFactory.getLogger(UniversitiesModel.class);
    @OSGiService
    private UniversitiesService universitiesService;

    @ValueMapValue
    private String country;

   public String getName(){
        return "Top "+country;
    }

    public String[] getUniversityNames() {
        logger.info("the vlaue of input is" +country);
        if (country == null || country.isEmpty()) {
            country = "India"; // default fallback
        }
        return universitiesService.getUniversities(country);
    }
}
