package com.iljasstan;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTest {
    @Test
    @Disabled("Man muss")
    void skipTest0() {
        assertTrue(true);
    }
    @Test
    @Disabled("Man muss")
    void skipTest1() {
        assertTrue(true);
    }
    @Test
    @Disabled("Man muss")
    void skipTest2() {
        assertTrue(true);
    }
}
