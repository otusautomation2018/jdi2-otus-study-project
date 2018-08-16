package eu.onlyoffice.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.TitlesOfPages;
import eu.onlyoffice.data.URLsOfPages;

@JPage(title = TitlesOfPages.NEW_PROJECTS_PAGE_TITLE)
public class ProjectPage extends WebPage {

    @FindBy(css = "#essenceTitle")
    public Text titleOfProject;
}
