package helpers;

import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.matcher.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class AssertionHelper {

    @Step
    public static void verifyTextElementDisplayedAndEqualsText(Text element, String expectedContent){
        Assert.assertTrue(element.displayed());
        Assert.assertEquals(element.getText(), expectedContent);
    }

    @Step
    public static void verifyInputDisplayedAndEnabled(Input element){
        Assert.assertTrue(element.displayed());
        Assert.assertTrue(element.enabled());
    }

    @Step
    public static void verifyTextAreaDisplayedAndEnabled(TextArea element){
        Assert.assertTrue(element.displayed());
        Assert.assertTrue(element.enabled());
    }

    @Step
    public static void verifyLinkDisplayedAndEnabled(Link element){
        Assert.assertTrue(element.displayed());
        Assert.assertTrue(element.enabled());
    }

    @Step
    public static void verifyLinkDisplayedAndContainsText(Link element, String expectedContent){
        verifyLinkDisplayedAndEnabled(element);
        Assert.assertEquals(element.getText(), expectedContent);
    }

    @Step
    public static void verifyButtonDisplayedAndEnabled(Button element){
        Assert.assertTrue(element.displayed());
        Assert.assertTrue(element.enabled());
    }

    @Step
    public static void verifyButtonDisplayedAndEnabledAndContainsText(Button element, String expectedContent){
        verifyButtonDisplayedAndEnabled(element);
        Assert.assertEquals(element.getText(), expectedContent);
    }

    @Step
    public static void verifyCheckBoxDisplayedAndEnabled(CheckBox element){
        Assert.assertTrue(element.displayed());
        Assert.assertTrue(element.enabled());
    }

    @Step
    public static void verifyStateOfCheckBox(CheckBox checkBox, boolean isChecked){
        Assert.assertTrue(checkBox.isChecked() == isChecked);
    }
}
