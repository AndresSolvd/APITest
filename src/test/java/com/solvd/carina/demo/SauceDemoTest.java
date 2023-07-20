package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.pages.saucedemo.CartPage;
import com.solvd.carina.demo.gui.pages.saucedemo.LoginPage;
import com.solvd.carina.demo.gui.pages.saucedemo.ProductsPage;
import com.solvd.carina.demo.gui.pages.saucedemo.components.CatalogProductItem;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTest extends AbstractSauceDemoTest {

    @Test
    @MethodOwner(owner = "Andres")
    public void LoginTest() {
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
}