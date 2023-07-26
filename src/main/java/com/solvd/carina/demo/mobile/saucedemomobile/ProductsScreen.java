package com.solvd.carina.demo.mobile.saucedemomobile;

import com.solvd.carina.demo.mobile.saucedemomobile.components.CatalogProductItem;
import com.solvd.carina.demo.mobile.saucedemomobile.components.LeftSideMenu;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ProductsScreen extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text()='Products'][@class='title']")
    private ExtendedWebElement pageTitleLabel;

    @FindBy(css = ".shopping_cart_link")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<CatalogProductItem> products;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement hamburgerButtonToDisplayLeftSideMenu;

    @FindBy(xpath = "//div[@class='bm-menu']")
    private LeftSideMenu leftSideMenu;

    protected ProductsScreen(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitleLabel);
    }

    public void clickHamburgerMenu() {
        hamburgerButtonToDisplayLeftSideMenu.click();
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public List<CatalogProductItem> getProductItems() {
        return products;
    }

    public CartScreen clickCartButton() {
        cartButton.click();
        return new CartScreen(driver);
    }
}