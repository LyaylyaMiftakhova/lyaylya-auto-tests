import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
