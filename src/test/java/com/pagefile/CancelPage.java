package com.pagefile;

import com.commonactions.Generics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.commonactions.Generics.clickingOnWebElement;

public class CancelPage {
    private WebDriver driver;

    Generics generics;

    public CancelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        generics = new Generics(driver);
    }
    @FindBy(xpath = "//button[@class='button action continue primary']")
    WebElement next;
    @FindBy(xpath = "//button[@type='submit']/span[text()='Place Order']")
    WebElement placeorder;
    @FindBy(xpath="//div[@ class='checkout-success']/p/a")    //a[@class='order-number']
    WebElement ordernum;
   @FindBy(xpath = "//div[@class='checkout-success']/p/a")
    WebElement checkout;
    @FindBy(xpath = "//span[@class='base']")
  WebElement ordernumconfirm;
    public void placingOrder() throws InterruptedException {
        Thread.sleep(5000);
        clickingOnWebElement(next);
        Thread.sleep(10000);
        clickingOnWebElement(placeorder);
        Thread.sleep(7000);
        //Assert.assertTrue(checkout.isDisplayed());
        System.out.println("Your order number : " + checkout.getText());
        checkout.click();
        Thread.sleep(5000);
        //Assert.assertTrue(ordernum.isDisplayed(),ordernumconfirm.getText());
       // System.out.println(ordernum.getText());
        generics.clickOnElement(ordernum);  ;
    }
}
