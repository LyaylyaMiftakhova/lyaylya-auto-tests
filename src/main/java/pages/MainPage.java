package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement mainSingInButton() {
        return $("[href='/login']").as("кнопка логина");
    }

    public SelenideElement loginInput() {
        return $("#login_field").as("поле ввода логина");
    }

    public SelenideElement passwordInput() {
        return $("#password").as("поле ввода пароля");
    }

    public SelenideElement singInButton() {
        return $(".js-sign-in-button").as("кнопка 'Sing in'");
    }

    public SelenideElement header() {
        return $(".Header").as("шапка сайта");
    }

    public SelenideElement dropdownButton() {
        return $("[aria-label='View profile and more']").as("кнопка выпадающего списка");
    }
}
