package eu.onlyoffice.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;
import eu.onlyoffice.data.CommonForTheSiteData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FormOfSelectManagerOfProject extends Form {

    public final String NO_MANAGER_TEXT = "Нет такого пользователя";
    public final String GROUPS_SELECTOR_LABEL = "Выбрать все";
    public final String TEXT_OF_EMPY_GROUP_SELECTOR = "На портале еще не было создано ни одной группы." +
            " Перейдите в модуль Люди, чтобы распределить пользователей по группам.";
    public final String NO_MANAGERS_IN_GROUP_TEXT = "В этой группе нет пользователей";
    public final String NO_MANAGERS_IN_LIST_TEXT = "В этом списке нет пользователей";

    @FindBy(css = ".onechosen .advanced-selector-search-field")
    public Input searchInput;

    @FindBy(css = ".onechosen .advanced-selector-reset-btn")
    public Button resetSearchBtn;

    @FindBy(xpath = "(//ul[@class='advanced-selector-list'])[1]/li")
    public List<Link> managers;

    @FindBy(xpath = "(//*[@class='advanced-selector-no-results'])[1]")
    public Text noManagerText;

    @FindBy(xpath = "(//*[@class='advanced-selector-block-list'])[2]//label")
    public Text labelOfGroupsSelector;

    @FindBy(xpath = "(//*[@class='advanced-selector-block-list'])[2]//*[@class='advanced-selector-no-groups']")
    public Text textOfEmptyGroupsSelector;


    @FindBy(xpath = "(//*[contains(@class, 'onechosen')]//ul[@class='advanced-selector-list'])[2]/li")
    public List<Link> groups;

    @FindBy(xpath = "(//*[contains(@class, 'onechosen')]//*[@class='advanced-selector-no-items'])[1]")
    public Text noManagersInGroupText;

    @FindBy(xpath = "(//*[contains(@class, 'onechosen')]//*[@class='advanced-selector-empty-list'])[1]")
    public Text noManagersInListText;

    @Step
    public void closeForm(){
        searchInput.sendKeys(Keys.ESCAPE);
    }

    @Step
    public void findManager(String manager){
        searchInput.input(manager);
        managers.get(CommonForTheSiteData.FIRST_ENTITY_IN_SEARCH_LIST)
                .wait(el-> el.getText().equals(manager), CommonForTheSiteData.TIMEOUT_OF_SEARCH_LIST_LOADED);
    }

    @Step
    public void chooseManager(String manager){
            /* ToDo managers.get(n).getText() returns number of element in list, but not Value of element.
            Need fix locator. */
        for (Link managerInList : managers){
            if (managerInList.getText().equals(manager)){
                managerInList.click();
            }
        }
    }

    @Step
    public void chooseFirstManagerInList(){
        managers.get(CommonForTheSiteData.FIRST_ENTITY_IN_SEARCH_LIST).click();
    }

    @Step
    public void findAndChooseManager(String manager){
        findManager(manager);
        chooseFirstManagerInList();
    }
}
