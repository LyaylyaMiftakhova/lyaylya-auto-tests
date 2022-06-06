package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class JunitPage {

    public SelenideElement repositoryName() {
        return $(".d-flex.flex-wrap.flex-items-center.wb-break-word.f3.text-normal").as("название репозитория");
    }

    public SelenideElement dropdownBranches() {
        return $(".btn.css-truncate").as("Выпадающий список веток");
    }

    public SelenideElement fixturesBranches() {
        return $("[href='https://github.com/junit-team/junit4/tree/fixtures']").as("Ветка 'fixtures'");
    }

    public SelenideElement nameFixturesBranches() {
        return $(".btn.css-truncate").as("Наименование ветки в выпадающем списке");
    }

    public SelenideElement releasesLink() {
        return $("[href='/junit-team/junit4/releases'].Link--primary").as("Ссылка на репозиторий");
    }

    public SelenideElement nameReleasesSwitch() {
        return $("[href='/junit-team/junit4/releases']").as("Наименование релиза в переключателе");
    }

    public SelenideElement searchInput() {
        return $(".subnav-search-input").as("Поле поиска");
    }

    public SelenideElement selectorCart() {
        return $("[data-test-selector='release-card']").as("Карта селектора");
    }
}
