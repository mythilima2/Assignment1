package com.basefile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Urllaunching {
    public WebDriver driver;

    @BeforeSuite
    public void launching() {

        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
       // driver.get("https://magento.softwaretestingboard.com/customer/account/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @BeforeClass
    // this is for lambda test
    public void lambdaapplication() throws MalformedURLException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browser", "chrome");
        desiredCapabilities.merge(chromeOptions);
        driver = new RemoteWebDriver(new URL("https://mythilibekkam:uhk459qtCvXm7yMVHqNULZ9BM8KZ7Kvxm0lccXBBtsjwh3jPty@hub.lambdatest.com/wd/hub"), chromeOptions);
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void killsession() {
        driver.quit();
    }
    }
