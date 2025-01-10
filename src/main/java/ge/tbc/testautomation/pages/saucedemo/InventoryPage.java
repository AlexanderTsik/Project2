package ge.tbc.testautomation.pages.saucedemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {
    public final ElementsCollection inventoryImages = $$(".inventory_item_img img"); // Inventory product images
    public SelenideElement menuButton = $("#react-burger-menu-btn"),  // Menu button
            logoutLink = $("#logout_sidebar_link");   // Logout link
}
