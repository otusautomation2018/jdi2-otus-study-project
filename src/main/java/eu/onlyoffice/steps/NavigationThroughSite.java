package eu.onlyoffice.steps;

import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.CommonForTheSiteData;
import eu.onlyoffice.entities.Project;
import eu.onlyoffice.enums.CreateMenu;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static eu.onlyoffice.steps.LoginSteps.loginWithValidCredentials;
import static eu.onlyoffice.site.OnlyOfficeSite.*;

@JPage
public class NavigationThroughSite {

    @Step
    public static void goToProjectsPage(){
        if (!projectsPage.pageMenu.displayed()){
            homePage.projects.click();
            projectsPage.pageMenu.wait(WebElement::isDisplayed, CommonForTheSiteData.TIMEOUT_OF_PAGE_LOADED);
            /*ToDo Fix the wait. */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Step
    public static void comeToProjectsPage(){
        loginWithValidCredentials();
        goToProjectsPage();
    }

    @Step
    public static void goToNewProjectPage(){
        if (!newProjectPage.isOpened()){
            projectsPage.pageMenu.createMenuDropdown.select(CreateMenu.PROJECT);
            newProjectPage.waitPageWillBeLoaded();
        }
    }

    @Step
    public static void comeToNewProjectPage(){
        comeToProjectsPage();
        goToNewProjectPage();
    }

    @Step
    public static void createNewProject(Project project){
        newProjectPage.fillAndSubmitAllFields(project);
        projectPage.titleOfProject.wait(WebElement::isDisplayed, CommonForTheSiteData.TIMEOUT_OF_ELEMENT_LOADED);
    }

    @Step
    public static void createNewProjectWithValidData(){
        Project project = Project.createFromFile(CommonForTheSiteData.PATH_TO_PROJECT_DATA_FILE);
        createNewProject(project);
    }

    @Step
    public static void loginAndCreateNewProject(){
        comeToNewProjectPage();
        createNewProjectWithValidData();
    }

    @Step
    public static void createNewProjectIfNeeded(){
        if (getQuantityOfProjects() < 1){
            createNewProjectWithValidData();
        }
    }


    /* ToDo Implement. */
    @Step
    public static List<Project> getMyProjects(){
        return null;
    }

    /* ToDo Implement. */
    @Step
    public static int getQuantityOfProjects(){
       return 0;
    }

    /* ToDo Implement. */
    @Step
    public static void removeAllProjects(){
    }

    @Step
    public static void removeAllProjectsIfNeeded(){
        if(getQuantityOfProjects() > 0){
            removeAllProjects();
        }
    }
}
