package AllyTests.base;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public void setup() {
        // Set up WebDriver and Selenide configuration
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
    }

    @AfterClass
    public void teardown() {
        // Close the browser after the test
        com.codeborne.selenide.Selenide.closeWebDriver();
    }
}
