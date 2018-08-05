package eu.onlyoffice;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import eu.onlyoffice.site.OnlyOfficeSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebBrowsers;

public class TestsInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(OnlyOfficeSite.class);
        logger.info("Run Tests");
    }
    @AfterSuite(alwaysRun = true)
    public static void tearDown()  {
        killAllRunWebBrowsers();
    }
}
