package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginVWO {

    @Test
    public void testSelenium() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        Thread.sleep(3000);

        WebElement element_email = driver.findElement(By.id("login-username"));
        element_email.sendKeys("abc@gmail.com");
        WebElement element_password = driver.findElement(By.id("login-password"));
        element_password.sendKeys("admin@123");
        WebElement sign_in = driver.findElement(By.id("js-login-btn"));
        sign_in.click();

        Thread.sleep(3000);

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

        driver.quit();
    }

    @Test
    public void testFreeTrial() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement link_free_trial = driver.findElement(By.partialLinkText("free trial"));
        link_free_trial.click();

        Thread.sleep(3000);

        driver.quit();


    }
}
