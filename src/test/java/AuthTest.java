import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("LyaylyaMiftakhova")
@Feature("Авторизация")
public class AuthTest {

    @BeforeEach
    public void setup(){
        open("https://github.com/");
        TestPages.mainPage.mainSingInButton()
                .click();
    }

    @Test
    @DisplayName("Успешная авторизация и переход в профиль")
    public void shouldAuthorizeTest() {
        step("Авторизоваться с корректными данными", () -> {
            TestPages.mainPage.loginInput()
                .sendKeys("LyaylyaMiftakhova");
            TestPages.mainPage.passwordInput()
                        .sendKeys("5Gset1Qn");
            TestPages.mainPage.singInButton()
                        .click();
            TestPages.mainPage.header()
                        .shouldBe(Condition.visible);
        });
        step("Кликнуть по кнопке выпадающего списка", () -> {
                TestPages.mainPage.dropdownButton()
                    .click();
        });
        step("Перейти в 'Your profile' и проверить, что отображается название репозитория 'training-repository'", () -> {
                $(byText("Your profile"))
                    .click();
            $(byText("training-repository"))
                        .shouldBe(Condition.visible);
        });
        }
}