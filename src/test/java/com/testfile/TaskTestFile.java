package com.testfile;

import com.basefile.Urllaunching;
import com.pagefile.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TaskTestFile extends Urllaunching {
    public LoginPage loginPage;
    public HomePage homepage;
    public BagsPage bagsPage;
    public Addresspage addresspage;
    public CancelPage cancelPage;
    //this is for sending the credentials and login
    @Test(priority = 1)
    public void setLoginpage() throws InterruptedException, FileNotFoundException {
        loginPage = new LoginPage(driver);
        loginPage.sendingData();
    }
    /*this code is for selecting bags from gear
    and is for verifying cart is empty*/
    @Test(priority = 2)
        public void setHomePage() throws InterruptedException {
            homepage = new HomePage(driver);
            homepage.selectBag();
            homepage.verifingCart();
        }
        //this is for verifying maximumprice product and add to cart
        //this is for proceding the productf to cart
    @Test(priority = 3)
     public void setBagpage() throws InterruptedException {
            bagsPage = new BagsPage(driver);
            bagsPage.setMaxproductAmount();
            bagsPage.addToWishlist();
            bagsPage.setAddtocart();
        }
        //this is for filling address
    @Test(priority = 4)
        public void setAddresspage() throws InterruptedException, FileNotFoundException {
            addresspage = new Addresspage(driver);
            addresspage.addingAddress();
            addresspage.fillAddress();
        }
        //this is for ordering
    @Test(priority = 5)
        public void setCancelpage() throws InterruptedException {
        cancelPage=new CancelPage(driver);
        cancelPage.placingOrder();
    }
}
