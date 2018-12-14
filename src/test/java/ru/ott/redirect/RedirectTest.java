package ru.ott.redirect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class RedirectTest {
    @Test
    public void redirect() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ghhhh/IdeaProjects/ott/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("onetwotrip.com");
        String url = driver.getCurrentUrl();
        System.out.println();
        assertTrue(url.contains("www.onetwotrip.com"));
    }
}