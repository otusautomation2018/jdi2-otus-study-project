package eu.onlyoffice.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.CommonForTheSiteData;
import eu.onlyoffice.data.TitlesOfPages;
import eu.onlyoffice.data.URLsOfPages;
import eu.onlyoffice.entities.Project;
import eu.onlyoffice.site.modals.AnswerForPrivateProjectPopup;
import eu.onlyoffice.site.sections.FormOfSelectManagerOfProject;
import eu.onlyoffice.site.sections.Header;
import eu.onlyoffice.site.sections.PageMenuSection;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

@JPage(url = URLsOfPages.NEW_PROJECTS_PAGE, title = TitlesOfPages.NEW_PROJECTS_PAGE_TITLE)
public class NewProjectPage extends WebPage {

    public final String TITLE = "Создать новый проект";
    public final String PROJECT_HEADER_LABEL = "Название";
    public final String PROJECT_DESCRIPTION_LABEL = "Описание";
    public final String MANAGER_OF_PROJECT_LABEL = "Менеджер проекта";
    public final String MANAGER_OF_PROJECT_LINK_TEXT = "Добавить менеджера проекта";
    public final String TAGS_LABEL = "Теги";
    public final String PRIVACY_CHECKBOX_LABEL = "Сохранить этот проект как приватный";
    public final String TITLE_OF_PRIVACY_CHECKBOX_SWITCHER = "Что такое приватный проект?";
    public final String SUBMIT_BUTTON_TEXT = "Сохранить";
    public final String CANCEL_BUTTON_TEXT = "Отмена";

    @FindBy(css = ".studio-top-panel.mainPageLayout")
    public Header header;

    @FindBy(css = ".page-menu")
    public PageMenuSection pageMenu;

    @FindBy(xpath = "//*[contains(@class, 'onechosen')]")
    public FormOfSelectManagerOfProject formOfSelectManagerOfProject;

    @FindBy(css = "#AnswerForPrivateProject")
    public AnswerForPrivateProjectPopup answerForPrivateProjectPopup;

    @FindBy(css = ".pageTitle")
    public Text headerOfPage;

    @FindBy(css = "#projectTitleContainer .headerPanelSmall")
    public Text projectHeaderLabel;

    @FindBy(css = "#projectTitle")
    public Input projectHeaderInput;

    @FindBy(css = "#projectDescriptionContainer .headerPanelSmall")
    public Text projectDescriptionLabel;

    @FindBy(css = "#projectDescription")
    public TextArea projectDescriptionTextArea;

    @FindBy(css = "#projectManagerContainer .headerPanelSmall")
    public Text managerOfProjectLabel;

    @FindBy(css = "#projectManagerSelector")
    public Link managerOfProjectLink;

    @FindBy(css = "#projectTagsContainer .headerPanelSmall")
    public Text tagsLabel;

    @FindBy(css = "#projectTags")
    public Input tagsInput;

    @FindBy(css = "#projectPrivacyCkeckbox")
    public CheckBox privacyCheckbox;

    @FindBy(xpath = "//*[@for='projectPrivacyCkeckbox']")
    public Text privacyCheckboxLabel;

    @FindBy(css = ".checkboxPrivateProj .HelpCenterSwitcher")
    public Link privacyHelpLink;

    @FindBy(css = "#projectActionButton")
    public Button submitBtn;

    @FindBy(css = "#cancelEditProject")
    public Button cancelBtn;

    @Step
    public List<Element> getElementsOnThePage(){
        ArrayList<Element> list = new ArrayList<>();
        list.add(projectHeaderLabel);
        list.add(projectHeaderInput);
        list.add(managerOfProjectLabel);
        list.add(managerOfProjectLink);
        list.add(submitBtn);
        list.add(cancelBtn);
        list.add(headerOfPage);
        list.add(projectDescriptionLabel);
        list.add(projectDescriptionTextArea);
        list.add(tagsLabel);
        list.add(tagsInput);
        list.add(privacyCheckboxLabel);
        list.add(privacyCheckbox);
        list.add(privacyHelpLink);
        return list;
    }

    @Step
    public void waitPageWillBeLoaded(){
        for (Element element : getElementsOnThePage()){
            element.wait(WebElement::isDisplayed, CommonForTheSiteData.TIMEOUT_OF_ELEMENT_LOADED);
        }
    }

    @Step
    public void openFormOfSelectManagerOfProject(){
        managerOfProjectLink.click();
        formOfSelectManagerOfProject.searchInput.wait(WebElement::isDisplayed, CommonForTheSiteData.TIMEOUT_OF_ELEMENT_LOADED);
    }

    @Step
    public void checkOrUncheckPrivacyCheckboxIfNeeded(boolean isNeeded){
        boolean stateOfCheckbox = privacyCheckbox.isChecked();
        if (isNeeded && !stateOfCheckbox){
            privacyCheckbox.check();
        } else if (!isNeeded && stateOfCheckbox){
            privacyCheckbox.uncheck();
        }
    }

    @Step
    public void fillAndSubmitAllFields(Project project){
        projectHeaderInput.input(project.title);
        projectDescriptionTextArea.input(project.description);
        openFormOfSelectManagerOfProject();
        formOfSelectManagerOfProject.chooseFirstManagerInList();
        for (String tag: project.tags){
            tagsInput.input(tag + ",");
        }
        checkOrUncheckPrivacyCheckboxIfNeeded(project.isPrivate);
        submitBtn.click();
    }
}
