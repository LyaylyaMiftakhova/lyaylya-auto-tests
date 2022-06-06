import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("LyaylyaMiftakhova")
@Feature("JUnit")
public class JunitTest {

    @BeforeEach
    public void before() {
        open("https://github.com/junit-team/junit4");
        TestPages.junitPage.repositoryName()
                .shouldHave(text("junit-team / junit4"));
    }

    @Test
    @DisplayName("Переключение на ветку fixtures")
    public void shouldSwitchToBranchTest(){
        step("Кликнуть по кнопке выпадающего списка", () ->
                TestPages.junitPage.dropdownBranches()
                        .click());
        step("Перейти в ветку 'fixtures'", () ->
                TestPages.junitPage.fixturesBranches()
                        .click());
        step("Проверить, что в наименовании ветки присутствует текст 'fixtures'", () -> {
        TestPages.junitPage.nameFixturesBranches()
                .shouldHave(text("fixtures"));
        });
    }

    @Story("Поиск")
    @DisplayName("Позитивные проверки поиска")
    @MethodSource("positiveChecks")
    @ParameterizedTest(name = "{displayName} {0}")
    public void positiveSearchChecksTest(String type, String searchData, String releaseName){
        step("Перейти в релизы репозитория 'junit4'", () -> {
            TestPages.junitPage.releasesLink()
                .click();
        });
        step("Проверить, что в переключателе присуствует 'Releases'", () -> {
            TestPages.junitPage.nameReleasesSwitch()
                .shouldHave(text("Releases"));
        });

        step("В поле поиска ввести данные для поиска и нажать ENTER", () -> {
            TestPages.junitPage.searchInput()
                .sendKeys(searchData + Keys.ENTER);
        });
        step("Проверить, что отображается искомая версия релиза", () -> {
            TestPages.junitPage.selectorCart()
                .shouldHave(text(releaseName));
        });
    }

    static Stream<Arguments> positiveChecks() {
        return Stream.of(
                arguments(
                        "по названию",
                        "JUnit 4.13 Beta 3",
                        "JUnit 4.13 Beta 3"
                ),
                arguments(
                        "по номеру версии",
                        "4.13.2",
                        "JUnit 4.13.2"
                )
        );
    }
}


