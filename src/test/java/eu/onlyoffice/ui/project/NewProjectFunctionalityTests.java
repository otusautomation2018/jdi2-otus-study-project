package eu.onlyoffice.ui.project;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.matcher.testng.Assert;
import eu.onlyoffice.TestsInit;
import eu.onlyoffice.data.CommonForTheSiteData;
import eu.onlyoffice.generators.RandomStringGenerator;
import eu.onlyoffice.site.modals.AnswerForPrivateProjectPopup;
import eu.onlyoffice.site.sections.FormOfSelectManagerOfProject;
import helpers.AssertionHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static eu.onlyoffice.steps.LoginSteps.loggedOut;
import static eu.onlyoffice.steps.NavigationThroughSite.comeToNewProjectPage;
import static eu.onlyoffice.site.OnlyOfficeSite.newProjectPage;

public class NewProjectFunctionalityTests extends TestsInit {

    @BeforeMethod
    public void comeToNewProjectPageIfNeeded(){
        comeToNewProjectPage();
    }

    @Test
    public void checkMandatoryElementsOfNewProjectsPageTest(){
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(
                newProjectPage.projectHeaderLabel, newProjectPage.PROJECT_HEADER_LABEL);
        AssertionHelper.verifyInputDisplayedAndEnabled(newProjectPage.projectHeaderInput);
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(
                newProjectPage.managerOfProjectLabel, newProjectPage.MANAGER_OF_PROJECT_LABEL);
        AssertionHelper.verifyLinkDisplayedAndContainsText(
                newProjectPage.managerOfProjectLink, newProjectPage.MANAGER_OF_PROJECT_LINK_TEXT);
        AssertionHelper.verifyButtonDisplayedAndEnabledAndContainsText(newProjectPage.submitBtn,
                newProjectPage.SUBMIT_BUTTON_TEXT);
        AssertionHelper.verifyButtonDisplayedAndEnabledAndContainsText(newProjectPage.cancelBtn,
                newProjectPage.CANCEL_BUTTON_TEXT);
    }

    @Test
    public void checkOptionalElementsOfNewProjectsPageTest(){
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(newProjectPage.headerOfPage, newProjectPage.TITLE);
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(
                newProjectPage.projectDescriptionLabel, newProjectPage.PROJECT_DESCRIPTION_LABEL);
        AssertionHelper.verifyTextAreaDisplayedAndEnabled(newProjectPage.projectDescriptionTextArea);
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(
                newProjectPage.tagsLabel, newProjectPage.TAGS_LABEL);
        AssertionHelper.verifyInputDisplayedAndEnabled(newProjectPage.tagsInput);
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(
                newProjectPage.privacyCheckboxLabel, newProjectPage.PRIVACY_CHECKBOX_LABEL);
        AssertionHelper.verifyCheckBoxDisplayedAndEnabled(newProjectPage.privacyCheckbox);
        AssertionHelper.verifyStateOfCheckBox(newProjectPage.privacyCheckbox, true);
        Assert.assertTrue(newProjectPage.privacyHelpLink.displayed());
        newProjectPage.privacyHelpLink.click();
        AnswerForPrivateProjectPopup answerForPrivateProjectPopup = newProjectPage.answerForPrivateProjectPopup;
        answerForPrivateProjectPopup.wait(WebElement::isDisplayed, CommonForTheSiteData.TIMEOUT_OF_ELEMENT_LOADED);
        Assert.assertTrue(answerForPrivateProjectPopup.displayed());
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(answerForPrivateProjectPopup.body,
                answerForPrivateProjectPopup.TEXT_OF_BODY);
        AssertionHelper.verifyLinkDisplayedAndContainsText(answerForPrivateProjectPopup.readMoreLink,
                answerForPrivateProjectPopup.TEXT_OF_READ_MORE_LINK);
        /* ToDO Check title of newProjectPage.privacyHelpLink */
    }

    @Test
    public void checkElementsOfManagerOfProjectFormOfNewProjectsPageTest(){
        newProjectPage.openFormOfSelectManagerOfProject();
        FormOfSelectManagerOfProject formOfSelectManagerOfProject = newProjectPage.formOfSelectManagerOfProject;
        AssertionHelper.verifyInputDisplayedAndEnabled(formOfSelectManagerOfProject.searchInput);
        for (Link manager : formOfSelectManagerOfProject.managers){
            Assert.assertTrue(manager.enabled());
        }
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(formOfSelectManagerOfProject.labelOfGroupsSelector,
                formOfSelectManagerOfProject.GROUPS_SELECTOR_LABEL);
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(formOfSelectManagerOfProject.textOfEmptyGroupsSelector,
                formOfSelectManagerOfProject.TEXT_OF_EMPY_GROUP_SELECTOR);
        formOfSelectManagerOfProject.searchInput.input(RandomStringGenerator.generateRandomString());
        AssertionHelper.verifyButtonDisplayedAndEnabled(formOfSelectManagerOfProject.resetSearchBtn);
        AssertionHelper.verifyTextElementDisplayedAndEqualsText(formOfSelectManagerOfProject.noManagerText,
                formOfSelectManagerOfProject.NO_MANAGER_TEXT);
        formOfSelectManagerOfProject.closeForm();
    }

    @AfterTest
    public void exit(){
        loggedOut();
    }
}
