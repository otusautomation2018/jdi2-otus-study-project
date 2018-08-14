package eu.onlyoffice.steps;

import eu.onlyoffice.data.CommonForTheSiteData;
import eu.onlyoffice.entities.User;
import ru.yandex.qatools.allure.annotations.Step;

import static eu.onlyoffice.site.OnlyOfficeSite.homePage;
import static eu.onlyoffice.site.OnlyOfficeSite.loginPage;

public class LoginSteps {

    @Step
    public static void login(User user){
        if(!homePage.header.profileBlock.displayed()){
            loginPage.shouldBeOpened();
            loginPage.loginForm.loginAs(user);
            homePage.checkOpened();
        }
    }

    @Step
    public static void loginWithValidCredentials(){
        login(User.createFromFile(CommonForTheSiteData.PATH_TO_USER_DATA_FILE));
    }

    /* ToDo Find locator for list of dropdown and change method after it. */
    @Step
    public static void loggedOut(){
        if(homePage.header.profileBlock.displayed()){
            homePage.header.staffDropdown.expand();
            homePage.header.clickByLogoutLink();
        }
    }
}
