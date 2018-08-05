package eu.onlyoffice.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.TitlesOfPages;
import eu.onlyoffice.data.URLsOfPages;

@JPage(url = URLsOfPages.HOME_PAGE, title = TitlesOfPages.HOME_PAGE_TITLE)
public class HomePage extends WebPage {
}
