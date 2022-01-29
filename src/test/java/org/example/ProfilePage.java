package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    //constructor
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy
            (xpath = "//*[@class='user-pic user-pic_has-plus_ user-account__pic']")
    private WebElement userMenu;

    @FindBy
            (xpath = "//*[@class='menu__item menu__item_type_link " +
                    "legouser__menu-item legouser__menu-item_action_exit']")
    private  WebElement logoutBtn;

    //get user name from user menu
//    public String getUserName() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        Duration.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
//                ("//*[@class='menu__item menu__item_type_link " +
//                        "legouser__menu-item legouser__menu-item_action_exit']")));

//        String userName = userMenu.getText();
//        return userName;
//    }
    //click button of user menu
    public void entryMenu() {
        userMenu.click();
    }
    //click logout button
    public void userLogout() {
        logoutBtn.click();
    }

}
