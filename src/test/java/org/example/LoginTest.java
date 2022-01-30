package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass

    public static void setup() {

        WebDriver driver = new ChromeDriver();
        //driver path
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        //maximize window
        driver.manage().window().maximize();
        //implicitly wait неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("loginpage"));
        WebElement priniat = driver.findElement(By.xpath("//*[@class='sc-pNWxx sc-jrsJCI dryRrI kcLcLu']"));
        priniat.click();
    }

    @Test
    public void loginTest() {
        //input login
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //click button enter
        loginPage.clickLoginBtn();
        //enter passwd
        loginPage.inputPasswd(ConfProperties.getProperty("passwd"));
        //click button enter
        loginPage.clickLoginBtn();
        //get visual login
        String user = profilePage.getUserName();
        //compare login with login from file settings
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }

    @AfterClass
    public static void tearDown () {
        profilePage.entryMenu();
        profilePage.userLogout();
//        driver.quit();
    }

}