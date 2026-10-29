package com.testmu.demo;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Minimal test: open a browser on the LambdaTest grid and check the page title.
 * LT_USERNAME / LT_ACCESS_KEY are injected by HyperExecute on the VM.
 */
public class LaunchBrowserTest {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        String user = System.getenv("LT_USERNAME");
        String key = System.getenv("LT_ACCESS_KEY");

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("build", "sourcePayload-demo");
        ltOptions.put("name", "LaunchBrowserTest");
        ltOptions.put("w3c", true);

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("latest");
        options.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(
                new URL("https://" + user + ":" + key + "@hub.lambdatest.com/wd/hub"), options);
    }

    @Test
    public void openPageAndCheckTitle() {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"),
                "Unexpected title: " + driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
