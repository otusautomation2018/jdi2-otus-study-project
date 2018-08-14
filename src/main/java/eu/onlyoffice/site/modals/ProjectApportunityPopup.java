package eu.onlyoffice.site.modals;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class ProjectApportunityPopup extends Section {

    @FindBy(css = "span.close")
    public Button closeBtn;

    @FindBy(css = ".create-button")
    public Button createProjectBtn;
}
