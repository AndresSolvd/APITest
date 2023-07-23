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
        loginPage.assertPageOpened();
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        ProductsPage productsPage = loginPage.clickLoginButton();
        productsPage.assertPageOpened();
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void productAddedToTheCartTest() {
        String productTitle = R.TESTDATA.get("product_name");

        ProductsPage productsPage = authUtils.loginStandardUser();
        productsPage.assertPageOpened();
        List<CatalogProductItem> productItems = productsPage.getProductItems();

        for (CatalogProductItem productItem : productItems) {
            if (productTitle.equals(productItem.getProductTitle())) {
                productItem.clickAddToCartButton();
            }
        }

        CartPage cartPage = productsPage.clickCartButton();
        cartPage.assertPageOpened();
        Assert.assertTrue(cartPage.isProductDisplayed(productTitle), "Product title is not displayed in the cart");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void aboutButtonInHamburgerMenuTest() throws InterruptedException {
        ProductsPage productsPage = authUtils.loginStandardUser();
        productsPage.assertPageOpened();
        productsPage.clickHamburgerMenu();
        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
        AboutPage aboutPage = leftSideMenu.clickAboutButtonInLeftSideMenu();
        aboutPage.assertPageOpened();
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void logOutButtonInHamburgerMenuTest() {
        ProductsPage productsPage = authUtils.loginStandardUser();
        productsPage.clickHamburgerMenu();
        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
        LoginPage loginPage = leftSideMenu.clickLogOutButtonInLeftSideMenu();
        loginPage.assertPageOpened();
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void checkoutButtonInCartPage() {
        ProductsPage productsPage = authUtils.loginStandardUser();
        productsPage.assertPageOpened();
        CartPage cartPage = productsPage.clickCartButton();
        cartPage.assertPageOpened();
        CheckOutYourInformationPage checkOutYourInformationPage = cartPage.clickCheckOutButton();
        checkOutYourInformationPage.assertPageOpened();
    }
}