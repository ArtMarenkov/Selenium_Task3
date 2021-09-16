package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps extends BaseSteps {
    private MainPage mainPage;

    public MainSteps() {
        mainPage = new MainPage(testService.getInitDriver());
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        mainPage.selectMainMenu(menuItem);
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectSubMenu(String menuItem) {
        mainPage.selectSubMenu(menuItem);
    }
}
