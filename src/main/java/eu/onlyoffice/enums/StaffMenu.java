package eu.onlyoffice.enums;

public enum  StaffMenu {
    PROFILE("Профиль"),
    ABOUT_PROGRAMM("О программе "),
    LOGGED_OUT("Выйти");

    public String value;
    StaffMenu(String value) { this.value = value; }
}
