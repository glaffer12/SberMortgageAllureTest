package ru.appline.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.appline.autotest.steps.BaseSteps;

public class MainPage extends  BasePage{

    @FindBy(xpath = "//button[contains(@aria-label,\"Ипотека\")]")
    WebElement MortgageButton;

    @FindBy(xpath =  "//a[@href=\"/ru/person/credits/home/buying_complete_house\" and contains(text(),\"Ипотека на готовое жильё\") and @class = \"lg-menu__sub-link\"]")
    WebElement MortgageCompleteHouse;

    public void moveCursorToMortgageButton() {
        new Actions(BaseSteps.getDriver()).moveToElement(MortgageButton).build().perform();
    }

    public void clickOnMortgageCompleteHouse() {
        new Actions(BaseSteps.getDriver()).moveToElement(MortgageCompleteHouse).click().build().perform();
    }

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
