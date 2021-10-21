package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() throws MalformedURLException {

        //Brwsers: chrome, firefox, etc
        //HUB_HOST: localhost, IP address, hostname

        //Default values

        String host= "localhost";
        //DesiredCapabilities: To work with crowdtesting
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        //asking by the browser
        if(System.getProperty("BROWSER")!= null &&
            System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }

        if(System.getProperty("HUB_HOST")!=null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";

        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}
