package ru.appline.autotest.pages;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.autotest.steps.BaseSteps;

import static ru.appline.autotest.steps.BaseSteps.getDriver;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void fillField(WebElement element, String value) throws InterruptedException {
        element.clear();
        Thread.sleep(1500);
        element.sendKeys(value);
        waitWhileValueInput(element, value);
        Thread.sleep(500);
    }

    public void scrollToElement(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(500);
    }


    public void waitWhileValueChanges(WebElement element) throws InterruptedException {
        String CurrentValue;
        while (true) {
            CurrentValue=element.getText();
            Thread.sleep(500);
            if (CurrentValue.equals(element.getText())) break;
        }
    }

    public void waitWhileValueInput(WebElement element, String value) throws InterruptedException {
        while(true) {
            if (element.getAttribute("value").replaceAll("[^0-9]","").equals(value)) {
                break;
            } else {
                Thread.sleep(500);
            }
        }
    }
    public static WebElement waitVisibilityOfElement(WebElement element){
        return new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOf(element));
    }

}
