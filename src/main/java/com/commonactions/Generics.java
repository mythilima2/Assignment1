package com.commonactions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Generics {
   public static WebDriver driver;
    public Generics(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnElement(WebElement element){
        try {
            element.click();
        }catch (NoSuchElementException nse){
            nse.printStackTrace() ;
        }catch (ElementClickInterceptedException eci){
            eci.printStackTrace();
        }catch (ElementNotInteractableException ene){
            ene.printStackTrace();
        }
    }
    //this is for click action
    public static void clickingOnWebElement(WebElement element)
    {
        WebDriverWait webwait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement elements =null;
       elements = webwait.<WebElement>until(ExpectedConditions.elementToBeClickable(element));
        elements.click();
    }   //this is for sendkeys action
    public static void sendKeysOnWebElement(WebElement element, String text)
    {
        element.sendKeys(text);
    }
    //this is for selecting value from dropdownlist
    public static void selectFromDropDown(WebElement element, String text)
    {
        Select select =new Select(element);
        select.selectByVisibleText(text);
    }
    //this is for accepting or dismissing alerts
    public void acceptAlerts(WebDriver driver)
    {        driver.switchTo().alert().accept();
    }
}
