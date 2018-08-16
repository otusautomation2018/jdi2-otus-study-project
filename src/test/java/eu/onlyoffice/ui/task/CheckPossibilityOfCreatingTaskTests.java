package eu.onlyoffice.ui.task;

import eu.onlyoffice.TestsInit;
import org.testng.annotations.Test;

import static eu.onlyoffice.steps.NavigationThroughSite.loginAndCreateNewProject;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class CheckPossibilityOfCreatingTaskTests extends TestsInit {

    @Test
    public void checkPossibilityOfCreatingTaskTest(){
        loginAndCreateNewProject();
    }
}
