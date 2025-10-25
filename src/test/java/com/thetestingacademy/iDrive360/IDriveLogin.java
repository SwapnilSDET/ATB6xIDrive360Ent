package com.thetestingacademy.iDrive360;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class IDriveLogin {

    @Test
    public void validLogin() throws Exception {

        ChromeOptions co = new ChromeOptions();
        co.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(3000);

        driver.manage().window().maximize();

        WebElement tfEmail = driver.findElement(By.id("username"));
        tfEmail.sendKeys("augtest_040823@idrive.com");

        WebElement tfPassword = driver.findElement(By.id("password"));
        tfPassword.sendKeys("123456");

        WebElement btnSignIn = driver.findElement(By.id("frm-btn"));
        btnSignIn.click();

        Thread.sleep(20000);

        WebElement message = driver.findElement(By.xpath("//span[contains(text(),'Your free trial has expired')]"));
        assertEquals(message.getText(), "Your free trial has expired");
        assertEquals(driver.getCurrentUrl(), "https://www.idrive360.com/enterprise/account?upgradenow=true");

        Thread.sleep(3000);

        driver.quit();
    }

}
