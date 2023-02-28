package com.pagefile;

import com.commonactions.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readingdata.JsonDataReading;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.commonactions.Generics.clickingOnWebElement;

public class Addresspage {
    private WebDriver driver;
    Generics generics;
    JsonDataReading jsonDataReading=new JsonDataReading();

    public Addresspage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        generics = new Generics(driver);}
        @FindBy(xpath = "//span[text()='New Address']")
        WebElement addingnewaddress;
    @FindBy(xpath ="//input[@ name='company']")
    WebElement  companyname;
    @FindBy (xpath ="//input[@ name='street[0]']")
    WebElement addressline1;
    @FindBy(xpath = "//input[@ name='street[1]']")
    WebElement addressline2;
    @FindBy(xpath = "//input[@ name='street[2]']")
    WebElement addressline3;
    @FindBy(xpath = "//input[@ name='city']")
    WebElement citytextfield;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postcodetextfield;
    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phonenumbertextfield;
    @FindBy(xpath="//span[text()='Ship here']")
    WebElement shipherebutton;

    public void addingAddress() throws InterruptedException{
            Thread.sleep(10000);
            Generics.clickingOnWebElement(addingnewaddress);}
    //this is for filling address
    public void fillAddress() throws FileNotFoundException, InterruptedException {
            Generics.sendKeysOnWebElement(companyname,jsonDataReading.read("company"));
            Generics.sendKeysOnWebElement(addressline1, jsonDataReading.read("address1"));
            Generics.sendKeysOnWebElement(addressline2, jsonDataReading.read("address2"));
            Generics.sendKeysOnWebElement(addressline3, jsonDataReading.read("address3"));
            Generics.sendKeysOnWebElement(citytextfield,jsonDataReading.read("city"));
           WebElement statedropdown=  driver.findElement(By.name("region_id"));
           statedropdown.sendKeys("Texas");
            Generics.sendKeysOnWebElement(postcodetextfield,jsonDataReading.read("postcode"));
        Generics.sendKeysOnWebElement(phonenumbertextfield,jsonDataReading.read("phone"));
        clickingOnWebElement(shipherebutton);
}}


