package com.pagefile;

import com.commonactions.Generics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPage {
    private WebDriver driver;

    public BagsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Generics generics = new Generics(driver);
    }
    @FindBy(xpath="//span[text()='Add to Wish List']")
    WebElement addtowishlist;
    @FindBy(xpath="//span[text()='Impulse Duffle']/../../following-sibling::div/following-sibling::div/div/button[@type='button']")
    WebElement addtocart;
    @FindBy(xpath="//div[@class='minicart-wrapper']")
    WebElement  selectcart;
    @FindBy(xpath="//button[@class='action primary checkout']")
    WebElement proceding;

//this is for verifying maximumprice product and add to cart
    public void setMaxproductAmount() throws InterruptedException {
        List<WebElement> listofallprices = new ArrayList<WebElement>();
        listofallprices = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        List<Double> allproductsamount = new ArrayList<>();
        for (WebElement webElement : listofallprices) {
            allproductsamount.add(Double.parseDouble(webElement.getText().replace("$", "")));
        }
        System.out.println(Collections.max(allproductsamount));
        Double maxproductamount = Collections.max(allproductsamount);
        System.out.println("max amount" + maxproductamount);
        WebElement highestpriceproduct = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'" + maxproductamount + "')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a"));
        System.out.println(highestpriceproduct.getText());
        highestpriceproduct.click();}
        public void  addToWishlist() throws InterruptedException {
        Generics.clickingOnWebElement(addtowishlist);
        Thread.sleep(5000);
            Generics.clickingOnWebElement(addtocart);
            Assert.assertTrue(driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']")).isDisplayed());
    }
    //this is for proceding the productf to cart
    public  void  setAddtocart() throws InterruptedException {
        Thread.sleep(5000);
      Generics.clickingOnWebElement(selectcart);
      Thread.sleep(5000);
      Generics.clickingOnWebElement(proceding);
      Thread.sleep(5000);
    }
}
