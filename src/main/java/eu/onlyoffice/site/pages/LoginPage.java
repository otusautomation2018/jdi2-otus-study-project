package eu.onlyoffice.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.TitlesOfPages;
import eu.onlyoffice.data.URLsOfPages;
import eu.onlyoffice.site.sections.LoginForm;

@JPage(url = URLsOfPages.LOGIN_PAGE, title = TitlesOfPages.LOGIN_PAGE_TITLE)
public class LoginPage extends WebPage {

    public LoginForm loginForm;

}
