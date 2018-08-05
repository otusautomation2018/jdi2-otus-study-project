package eu.onlyoffice.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import eu.onlyoffice.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(id = "login")
    public TextField email;

    @FindBy(id="pwd")
    public TextField password;

    @FindBy(id = "loginButton")
    public Button enter;
}
