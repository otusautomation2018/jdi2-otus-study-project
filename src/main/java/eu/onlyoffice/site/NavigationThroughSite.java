package eu.onlyoffice.site;

import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import eu.onlyoffice.data.CommonForTheSiteData;
import eu.onlyoffice.entities.User;
import ru.yandex.qatools.allure.annotations.Step;

import static eu.onlyoffice.site.OnlyOfficeSite.homePage;
import static eu.onlyoffice.site.OnlyOfficeSite.loginPage;

@JPage
public class NavigationThroughSite {

    @Step
    public static void login(User user){
        loginPage.open();
        loginPage.loginForm.loginAs(user);
        homePage.checkOpened();
    }

    @Step
    public static void loginWithValidCredentials(){
        login(User.createFromFile(CommonForTheSiteData.PATH_TO_USER_DATA_FILE));
    }
}
