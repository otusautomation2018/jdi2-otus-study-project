package eu.onlyoffice.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.TitlesOfPages;
import eu.onlyoffice.data.URLsOfPages;
import eu.onlyoffice.site.sections.Header;

@JPage(url = URLsOfPages.HOME_PAGE, title = TitlesOfPages.HOME_PAGE_TITLE)
public class HomePage extends WebPage {

    /* products list */
    @FindBy(xpath = "//*[contains(@class, 'default-list-products')]/*[1]")
    public Link projects;

    @FindBy(css = ".studio-top-panel.mainPageLayout")
    public Header header;

}
