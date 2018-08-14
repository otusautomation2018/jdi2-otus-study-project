package eu.onlyoffice.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.TitlesOfPages;
import eu.onlyoffice.data.URLsOfPages;
import eu.onlyoffice.site.sections.PageMenuSection;
import eu.onlyoffice.site.modals.ProjectApportunityPopup;

@JPage(url = URLsOfPages.PROJECTS_PAGE, title = TitlesOfPages.PROJECTS_PAGE_TITLE)
public class ProjectsPage extends WebPage {

    @FindBy(id = "content")
    public ProjectApportunityPopup projectOpportunityPopup;

    @FindBy(className = "addFirstElement")
    public Link addFirstProjectLink;

    @FindBy(css = ".page-menu")
    public PageMenuSection pageMenu;
}
