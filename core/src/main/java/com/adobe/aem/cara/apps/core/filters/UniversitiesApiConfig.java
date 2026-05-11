package com.adobe.aem.cara.apps.core.filters;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Universities API Config", description = "Configuration for Hipolabs Universities API")
public @interface UniversitiesApiConfig {

    @AttributeDefinition(name = "API URL", description = "Base URL of the Universities API")
    String apiUrl() default "http://universities.hipolabs.com/search?country=";
}


