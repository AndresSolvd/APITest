package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.saucedemomobile.android.CartScreen;
import com.solvd.carina.demo.mobile.saucedemomobile.android.ProductDetailsScreen;
import com.solvd.carina.demo.mobile.saucedemomobile.common.CartScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.LoginScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductDetailsScreenBase;
import com.solvd.carina.demo.mobile.saucedemomobile.common.ProductsScreenBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoMobileTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Andres")
    public void loginTest() {
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");

        LoginScreenBase loginScreenBase = initPage(LoginScreenBase.class);
        Assert.assertTrue(loginScreenBase.isOpened(), "Login screen is not opened");
        loginScreenBase.typeUsername(username);
        loginScreenBase.typePassword(password);
        ProductsScreenBase productsScreenPage = loginScreenBase.clickLoginButton();
        Assert.assertTrue(productsScreenPage.isOpened(), "Products screen is not opened");
    }
    @Test
    @MethodOwner(owner = "Andres")
    public void productAddedToTheCartTest() {
        String productTitle = R.TESTDATA.get("product_name");
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");

        LoginScreenBase loginScreenBase = initPage(LoginScreenBase.class);
        Assert.assertTrue(loginScreenBase.isOpened(), "Login screen is not opened");
        loginScreenBase.typeUsername(username);
        loginScreenBase.typePassword(password);
        ProductsScreenBase productsScreenPage = loginScreenBase.clickLoginButton();
        Assert.assertTrue(productsScreenPage.isOpened(), "Products screen is not opened");

        ProductDetailsScreenBase productDetailsScreenBase = productsScreenPage.clickProductTitle(productTitle);
        Assert.assertTrue(productDetailsScreenBase.isOpened(), "Product details screen is not opened");

        productDetailsScreenBase.clickAddToCardButton();
        CartScreenBase cartScreenBase = productDetailsScreenBase.clickCartButton();
        Assert.assertTrue(cartScreenBase.isOpened(), "Cart screen is not opened");
        Assert.assertTrue(cartScreenBase.isProductDisplayed(productTitle), "Added product is not in the cart");
    }

//    @Test
//    @MethodOwner(owner = "Andres")
//    public void aboutButtonInHamburgerMenuTest() throws InterruptedException {
//        ProductsPage productsPage = authUtils.loginStandardUser();
//        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
//        productsPage.clickHamburgerMenu();
//        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
//        AboutPage aboutPage = leftSideMenu.clickAboutButton();
//        Assert.assertTrue(aboutPage.isPageOpened(), "AboutPage page is not opened");
//    }
//
//    @Test
//    @MethodOwner(owner = "Andres")
//    public void logOutButtonInHamburgerMenuTest() {
//        ProductsPage productsPage = authUtils.loginStandardUser();
//        productsPage.clickHamburgerMenu();
//        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
//        LoginPage loginPage = leftSideMenu.clickLogOutButton();
//        Assert.assertTrue(loginPage.isPageOpened(), "LoginPage page is not opened");
//    }
//
//    @Test
//    @MethodOwner(owner = "Andres")
//    public void checkoutButtonInCartPage() {
//        ProductsPage productsPage = authUtils.loginStandardUser();
//        productsPage.assertPageOpened();
//        CartPage cartPage = productsPage.clickCartButton();
//        Assert.assertTrue(cartPage.isPageOpened(), "CartPage page is not opened");
//        CheckOutYourInformationPage checkOutYourInformationPage = cartPage.clickCheckOutButton();
//        Assert.assertTrue(checkOutYourInformationPage.isPageOpened(), "CheckOutYourInformationPage page is not opened");
//    }
}
