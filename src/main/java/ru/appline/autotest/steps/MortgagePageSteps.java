package ru.appline.autotest.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.appline.autotest.pages.MainPage;
import ru.appline.autotest.pages.MortgagePage;

public class MortgagePageSteps {

    @Step("Выполнен переход на форму расчёта параметров ипотеки")
    public MortgagePageSteps switchToFrame() {
        new MortgagePage().switchToFrame();
        return this;
    }

    @Step("В поле {0} введено значение {1}")
    public MortgagePageSteps inputValue(String Name, String Value) throws InterruptedException {
        new MortgagePage().inputValue(Name,Value);
        return this;
    }
    @Step("Выполнено нажатие на кнопку {0}")
    public MortgagePageSteps clickOnSwitcher(String Name) throws InterruptedException {
        new MortgagePage().clickOnSwitcher(Name);
        return this;
    }

    @Step("В поле {1} введено значение {0}")
    public MortgagePageSteps checkFieldValue(String Name,String Value) {
        String ActualValue = new MortgagePage().getValue(Name).getText();
        Assert.assertEquals(Value, ActualValue);
        return this;
    }

}
