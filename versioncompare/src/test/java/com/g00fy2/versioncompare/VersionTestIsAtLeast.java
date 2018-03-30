package com.g00fy2.versioncompare;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) public class VersionTestIsAtLeast {

  @Parameters public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { "1.2.3", "1.2" },
        { "2.0.0", "2" },
        { "2.4.0-beta3", "2.4" },
        { "2.4-beta3", "2.4" },
        { "2.4-rc", "2.4-beta3" },
        { "2.4.0.2", "2.4.0.1" },
        { "hasdh10uadf", "hasdh10uadf" },
        { "?ü+", "?ü+" },
        { "kasfd5", "posfd4" },
        { "1.0.3838484884444", "1.0.3838484884444" },
        { null, null }
    });
  }

  private final String atLeastVersionA;
  private final String atLeastVersionB;

  public VersionTestIsAtLeast(String versionA, String versionB) {
    atLeastVersionA = versionA;
    atLeastVersionB = versionB;
  }

  @Test public void isAtLeastIsCorrect() {
    assertEquals("Version parts in " + atLeastVersionA + " should be equal or higher as the ones in " + atLeastVersionB,
        true, new Version(atLeastVersionA).isAtLeast(atLeastVersionB));
  }
}