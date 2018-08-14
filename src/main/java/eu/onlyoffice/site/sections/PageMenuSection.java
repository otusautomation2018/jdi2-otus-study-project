package eu.onlyoffice.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import eu.onlyoffice.enums.CreateMenu;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;

public class PageMenuSection extends Section {

    @JDropdown(
            root = @FindBy(css = ".menu-actions"),
            value = @FindBy(css = "#menuCreateNewButton .main-button-text"),
            list = @FindBy(xpath = "//preceding::div[@id='createNewButton']//a"), //ToDo needed correct locator
            expand = @FindBy(css = "#menuCreateNewButton .white-combobox"))
    public Dropdown<CreateMenu> createMenuDropdown;

}
