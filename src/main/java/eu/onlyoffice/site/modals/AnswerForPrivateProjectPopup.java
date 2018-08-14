package eu.onlyoffice.site.modals;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.FindBy;

public class AnswerForPrivateProjectPopup extends Section {
    public final String TEXT_OF_BODY = "Приватный проект - это способ ограничить доступ к проекту," +
            " чтобы проект был доступен только участникам команды. Сохранение проекта в качестве приватного также" +
            " позволит вам настроить права доступа для каждого участника команды в рамках этого проекта.\nПодробнее...";
    public final String TEXT_OF_READ_MORE_LINK = "Подробнее...";

    @FindBy(css = "#AnswerForPrivateProject p")
    public Text body;

    @FindBy(css = "#AnswerForPrivateProject a")
    public Link readMoreLink;
}
