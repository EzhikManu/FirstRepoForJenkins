package com.iljasstan.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesPage {
    @Test
    @Tag("properties")
    void propertiesTest() {
        String value = System.getProperty("browser", "chrome");
        System.out.println(value);
    }
}
