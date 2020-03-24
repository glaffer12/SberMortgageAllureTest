package ru.appline.autotest.steps;


import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import ru.appline.autotest.pages.MainPage;

public class MainPageSteps extends BaseSteps {

    @Step("Выбрано меню Ипотека")
    public MainPageSteps moveCursorToMortgageButton() {
        new MainPage().moveCursorToMortgageButton();
        return this;
    }

    @Step("Выбран пункт меню Ипотека на готовое жилье")
    public MainPageSteps clickOnMortgageCompleteHouse() {
        new MainPage().clickOnMortgageCompleteHouse();
        return this;
    }

}
