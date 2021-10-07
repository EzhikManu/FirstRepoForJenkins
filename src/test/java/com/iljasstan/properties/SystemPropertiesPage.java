package com.iljasstan.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesPage {
    @Test
    @Tag("properties")
    void propertiesTest() {
        String value = System.setProperty("browser", "opera");
        System.out.println(System.getProperty("browser", "chrome"));
    }
}
