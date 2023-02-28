package com.pagefile;

import com.commonactions.Generics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Generics generics = new Generics(driver);
    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement geardropdown;

    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bags;
    @FindBy(xpath="//a[@class='action showcart']")
    WebElement cart;
    @FindBy(xpath="//div[contains(@class,\"block block-minicart\")]")
    WebElement empty;

//this code is for selecting bags from gear
    public void selectBag() throws InterruptedException {
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(geardropdown).perform();
        Thread.sleep(1000);
        actions.moveToElement(bags).click().perform();
    }
    //this is for verifying cart is empty
        public void verifingCart(){
       Generics.clickingOnWebElement(cart);
            Assert.assertTrue(empty.isDisplayed());
            System.out.println("empty list");
        }
    }
