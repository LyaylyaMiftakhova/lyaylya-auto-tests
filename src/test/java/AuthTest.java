import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AuthTest {

    @Test
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
    }
}
