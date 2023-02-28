package com.pagefile;

import com.commonactions.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Generics generics = new Generics(driver);
    }

    @FindBy(xpath = "//div[@class='panel header']/ul//a[normalize-space()='Sign In']")
    WebElement SignIn;
    @FindBy(xpath = "//div[@class='control']/input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//div[@class='field password required']/label/following-sibling::div/input[@title='Password']")
    WebElement password;
    @FindBy(xpath = "//fieldset/div[@class='actions-toolbar']/div/button[@id='send2']")
    WebElement SignInButton;
    //this is for sending the credentials
    //and login

    public void sendingData() throws InterruptedException {
        Generics.clickingOnWebElement(SignIn);
        Thread.sleep(5000);
        Generics.sendKeysOnWebElement(email, "mythilibekkam@gmail.com");
        Generics.sendKeysOnWebElement(password, "mythilima@2");
        Generics.clickingOnWebElement(SignInButton);
    }
}