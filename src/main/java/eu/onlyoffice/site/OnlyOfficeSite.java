package eu.onlyoffice.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import eu.onlyoffice.data.URLsOfPages;
import eu.onlyoffice.site.pages.HomePage;
import eu.onlyoffice.site.pages.LoginPage;
import eu.onlyoffice.site.pages.NewProjectPage;
import eu.onlyoffice.site.pages.ProjectsPage;

@JSite(URLsOfPages.URL_OF_SITE)
public class OnlyOfficeSite extends WebSite {

    public static LoginPage loginPage;

    public static HomePage homePage;

    public static ProjectsPage projectsPage;

    public static NewProjectPage newProjectPage;
}
