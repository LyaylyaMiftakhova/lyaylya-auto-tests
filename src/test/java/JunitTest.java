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
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
        TestPages.junitPage.dropdownBranches()
                .click();
        TestPages.junitPage.fixturesBranches()
                .click();
        TestPages.junitPage.nameFixturesBranches()
                .shouldHave(text("fixtures"));
    }

    @DisplayName("Позитивные проверки поиска")
    @MethodSource("positiveChecks")
    @ParameterizedTest(name = "{displayName} {0}")
    public void positiveSearchChecksTest(String type, String searchData, String releaseName){
        TestPages.junitPage.releasesLink()
                .click();
        TestPages.junitPage.nameReleasesSwitch()
                .shouldHave(text("Releases"));

        TestPages.junitPage.searchInput()
                .sendKeys(searchData + Keys.ENTER);
        TestPages.junitPage.selectorCart()
                .shouldHave(text(releaseName));
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


