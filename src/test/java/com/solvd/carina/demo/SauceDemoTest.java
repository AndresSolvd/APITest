package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.saucedemo.*;
import com.solvd.carina.demo.gui.saucedemo.components.CatalogProductItem;
import com.solvd.carina.demo.gui.saucedemo.components.LeftSideMenu;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTest extends AbstractSauceDemoTest {

    @Test
    @MethodOwner(owner = "Andres")
    public void loginTest() {
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        ProductsPage productsPage = loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isPageOpened(), "product page is not opened");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void productAddedToTheCartTest() {
        String productTitle = "Sauce Labs Onesie";

        ProductsPage productsPage = authUtils.loginStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        List<CatalogProductItem> productItems = productsPage.getProductItems();

        for (CatalogProductItem productItem : productItems) {
            if (productTitle.equals(productItem.getProductTitle())) {
                productItem.clickAddToCartButton();
            }
        }

        CartPage cartPage = productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(cartPage.isProductDisplayed(productTitle), "Product title is not displayed in the cart");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void aboutButtonInHamburgerMenuTest() throws InterruptedException {
        ProductsPage productsPage = authUtils.loginStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        productsPage.clickHamburgerMenu();
        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
        AboutPage aboutPage = leftSideMenu.clickAboutButtonInLeftSideMenu();
        Assert.assertTrue(aboutPage.isPageOpened(), "About Page is not opened");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void logOutButtonInHamburgerMenuTest() {
        ProductsPage productsPage = authUtils.loginStandardUser();
        productsPage.clickHamburgerMenu();
        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
        LoginPage loginPage = leftSideMenu.clickLogOutButtonInLeftSideMenu();
        Assert.assertTrue(loginPage.isPageOpened(), "LogIn page is not opened after clicking LogOut");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void checkoutButtonInCartPage() {
        ProductsPage productsPage = authUtils.loginStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened");
        CartPage cartPage = productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "CartPage is not opened");
        CheckOutYourInformationPage checkOutYourInformationPage = cartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutYourInformationPage.isPageOpened(),
                "The CheckOut page(Information) is not opened");
    }
}