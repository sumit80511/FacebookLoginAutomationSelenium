package com.thetestingacademy;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestVWOLogin {

    ChromeOptions options;
            WebDriver driver;

    @BeforeSuite

    public void setUp()
    {
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);

    }

    @Test(priority = 1, groups = {"negative", "sanity", "reg"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("TC#1-Verify that with invalid username and valid password, Login is not successful !!")
    public void TestInvalidLogin() throws InterruptedException {
        driver.get("https://www.facebook.com/login/");
        driver.findElement(By.id("email")).sendKeys("var@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Sksingh@0");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(2000);

        //Assertion- checking Actual result=Expected result
       //String errorstring= driver.findElement(By.id("js-notification-box-msg")).getText();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/recover/initiate/?lara_product=www_first_password_failure");
    }

    @Test(enabled = true, priority = 2, groups = {"positive", "sanity", "stage"})
    @Description("TC#2-Verify that with valid username and valid password, Login is successful !!")
    public void TestvalidLogin() throws InterruptedException {
        driver.get("https://www.facebook.com/login/");
        driver.findElement(By.id("email")).sendKeys("sumit80511@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Sksingh@007");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(2000);

        //Assertion- checking Actual result=Expected result
        Assert.assertEquals(driver.getCurrentUrl(),("https://www.facebook.com/"));


    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();

    }
}
