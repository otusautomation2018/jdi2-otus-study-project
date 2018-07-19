package org.mytests.tests.example;

import org.mytests.uiobjects.example.entities.User;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.site.JDIExampleSite.homePage;
import static org.mytests.uiobjects.example.site.JDIExampleSite.login;

public class SimpleTest extends TestsInit {

    @Test
    public void loginTest() {
        homePage.open();
        login(new User());
        homePage.checkOpened();
    }
}
