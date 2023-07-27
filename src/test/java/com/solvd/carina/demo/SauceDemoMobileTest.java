package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.saucedemo.CartPage;
import com.solvd.carina.demo.gui.saucedemo.CheckOutYourInformationPage;
import com.solvd.carina.demo.gui.saucedemo.ProductsPage;
import com.solvd.carina.demo.gui.saucedemo.components.CatalogProductItem;
import com.solvd.carina.demo.gui.saucedemo.components.LeftSideMenu;
import com.solvd.carina.demo.mobile.saucedemomobile.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoMobileTest extends AbstractSauceDemoScreenTest {

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
        String productTitle = R.TESTDATA.get("second_product_name");

        // Log In
        ProductsScreenBase productsScreenBase = authUtilsscreen.loginStandardUser();
        Assert.assertTrue(productsScreenBase.isOpened(), "Products screen is not opened");

        // Go to Product screen
        ProductDetailsScreenBase productDetailsScreenBase = productsScreenBase.clickProductTitle(productTitle);
        Assert.assertTrue(productDetailsScreenBase.isOpened(), "Product details screen is not opened");

        // Add the product to the cart
        productDetailsScreenBase.clickAddToCardButton();

        // Go to Cart screen and verify product has been added
        CartScreenBase cartScreenBase = productDetailsScreenBase.clickCartButton();
        Assert.assertTrue(cartScreenBase.isOpened(), "Cart screen is not opened");
        Assert.assertTrue(cartScreenBase.isProductDisplayed(productTitle), "Added product is not in the cart");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void logOutButtonInHamburgerMenuTest() {
        // Log In
        ProductsScreenBase productsScreenBase = authUtilsscreen.loginStandardUser();
        Assert.assertTrue(productsScreenBase.isOpened(), "Products screen is not opened");

        // Go to LeftSide Menu
        LeftSideMenuScreenBase leftSideMenuScreenBase = productsScreenBase.clickHamburgerMenuToGetLeftSideMenu();
        Assert.assertTrue(leftSideMenuScreenBase.isOpened(), "left Side Menu is not opened");

        // Click Log Out
        LoginScreenBase loginScreenBase = leftSideMenuScreenBase.clickLogOutButton();
        Assert.assertTrue(loginScreenBase.isPageOpened(), "Login Screen is not opened");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void checkoutButtonInCartPage() {
        String productTitle = R.TESTDATA.get("second_product_name");
        String firstName = R.TESTDATA.get("first_name");
        String lastName = R.TESTDATA.get("last_name");
        String zip = R.TESTDATA.get("zip");

        // Log In
        ProductsScreenBase productsScreenBase = authUtilsscreen.loginStandardUser();
        Assert.assertTrue(productsScreenBase.isOpened(), "Products screen is not opened");

        // Go to Product screen
        ProductDetailsScreenBase productDetailsScreenBase = productsScreenBase.clickProductTitle(productTitle);
        Assert.assertTrue(productDetailsScreenBase.isOpened(), "Product details screen is not opened");

        // Add the product to the cart
        productDetailsScreenBase.clickAddToCardButton();

        // Go to Cart screen and verify product has been added
        CartScreenBase cartScreenBase = productDetailsScreenBase.clickCartButton();
        Assert.assertTrue(cartScreenBase.isOpened(), "Cart screen is not opened");
        Assert.assertTrue(cartScreenBase.isProductDisplayed(productTitle), "Product is not in the cart");

        // CLick Check Out Button
        CheckOutYourInformationScreenBase checkOutYourInformationScreenBase = cartScreenBase.clickCheckOutButton();
        Assert.assertTrue(checkOutYourInformationScreenBase.isOpened(), "The information Page is not opened");

        // Input information required data
        checkOutYourInformationScreenBase.typeFirstName(firstName);
        checkOutYourInformationScreenBase.typeLastName(lastName);
        checkOutYourInformationScreenBase.typeZipcode(zip);

        // Go to Overview Screen
        OverviewScreenBase overviewScreenBase = checkOutYourInformationScreenBase.clickContinue();
        Assert.assertTrue(overviewScreenBase.isOpened(),"Over View screen is not opened");

        // Click Finish
        ThankYouScreenBase thankYouScreenBase = overviewScreenBase.clickFinish();
        Assert.assertTrue(thankYouScreenBase.isOpened(), " Thank You screen is not opened");

        // Back to Product Screen
        ProductsScreenBase productScreenBase = thankYouScreenBase.clickBackHomeButton();
        Assert.assertTrue(productScreenBase.isOpened(), "Product Page is not opened");
    }
}
