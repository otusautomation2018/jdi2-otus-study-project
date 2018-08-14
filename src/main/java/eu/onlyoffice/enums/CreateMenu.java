package eu.onlyoffice.enums;

public enum CreateMenu {
    PROJECT("Проект"),
    MILESTONE("Веха"),
    TASK("Задача"),
    DISCUSSION("Обсуждение"),
    TIMER("Запустить/Остановить таймер"),
    TEMPLATE_OF_PROJECT("Шаблон проекта");

    public String value;
    CreateMenu(String value) { this.value = value; }
}
