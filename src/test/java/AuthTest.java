import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AuthTest {

    @BeforeEach
    public void setup(){
        open("https://github.com/");
        TestPages.mainPage.mainSingInButton()
                .click();
    }

    @Test
    @DisplayName("Авторизация и переход в профиль")
    public void shouldAuthorizeTest() {
        open("https://github.com/");
        $("[href='/login']").click();
        $("[id='login_field']").sendKeys("LyaylyaMiftakhova");
        $("[id='password']").sendKeys("12345");
        $(".js-sign-in-button").click();
        $(".Header").shouldBe(Condition.visible);
        $("[aria-label='View profile and more']").click();
        $(byText("Your profile")).click();
        $(byText("training-repository")).shouldBe(Condition.visible);
        TestPages.mainPage.loginInput()
                .sendKeys("LyaylyaMiftakhova");
        TestPages.mainPage.passwordInput()
                        .sendKeys("11111");
        TestPages.mainPage.singInButton()
                        .click();
        TestPages.mainPage.header()
                        .shouldBe(Condition.visible);
        TestPages.mainPage.dropdownButton()
                        .click();
        $(byText("Your profile"))
                        .click();
        $(byText("training-repository"))
                        .shouldBe(Condition.visible);
    }
}