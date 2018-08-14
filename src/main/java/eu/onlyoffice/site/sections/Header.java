package eu.onlyoffice.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import eu.onlyoffice.enums.StaffMenu;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class Header extends Section {

    @FindBy(css = ".staff-profile-box")
    public Link profileBlock;

    @JDropdown(
            root = @FindBy(xpath = "//*[contains(@class, 'staff-profile-box')]"),
            value = @FindBy(xpath = "//*[contains(@class, 'usr-prof')]"),
            list = @FindBy(xpath = "//*[contains(@class, 'staff-profile-box')]/ancestor::body//*[contains(@id, 'studio_myStaffPopupPanel')]/ul/li/*[contains(@class, 'dropdown-item')]"),
            expand = @FindBy(xpath = "//*[contains(@class, 'userLink')]"))
    public Dropdown<StaffMenu> staffDropdown;

    @FindBy(xpath = "//*[contains(@class, 'staff-profile-box')]/ancestor::body//*[contains(@id, 'studio_myStaffPopupPanel')]/ul/li/*[contains(@class, 'dropdown-item')]")
    public List<Link> linksOfStaffDropdown;

    @Step
    public void clickByLogoutLink(){
        for (Link link: linksOfStaffDropdown){
            if (link.getText().equals(StaffMenu.LOGGED_OUT)){
                link.click();
            }
        }
    }
}
