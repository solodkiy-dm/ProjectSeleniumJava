package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class LoginPage {

    //constructor for initialization fields of classes
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy
            (xpath = "//*[@name='login']")
    private WebElement loginField;

    @FindBy
            (xpath = "//button[@class='Button2 Button2_size_l " +
                    "Button2_view_action Button2_width_max Button2_type_submit']")
    private WebElement loginBtn;

    @FindBy
            (xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwdField;

    public void inputLogin(String login) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd){
      passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

}
