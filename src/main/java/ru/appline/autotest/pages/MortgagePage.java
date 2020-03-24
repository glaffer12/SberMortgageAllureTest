package ru.appline.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.autotest.steps.BaseSteps;

public class MortgagePage extends BasePage {

    @FindBy(xpath="//iframe[@id=\"iFrameResizer0\"]")
    WebElement Frame;

    @FindBy(xpath = "//*[@id=\"estateCost\"]")
    WebElement Sum;

    @FindBy(xpath = "//input[@id=\"initialFee\"]")
    WebElement InitialFee;

    @FindBy(xpath = "//input[@id=\"creditTerm\"]")
    WebElement CreditTerm;

    @FindBy(xpath ="//span[@data-test-id=\"amountOfCredit\"]")
    static WebElement AmountOfCredit;

    @FindBy(xpath ="//span[@data-test-id=\"monthlyPayment\"]")
    static WebElement MonthlyPayment;

    @FindBy(xpath ="//span[@data-test-id=\"requiredIncome\"]")
    static WebElement RequiredIncome;

    @FindBy(xpath = "//span[@data-test-id=\"rate\"]")
    static WebElement Rate;

    @FindBy(xpath = "//label[./input[@data-test-id=\"paidToCard\"]]")
    WebElement SalaryCardExistance;

    @FindBy(xpath ="//label[./input[@data-test-id=\"canConfirmIncome\"]]")
    WebElement CanConfirm;

    @FindBy(xpath = "//label[./input[@data-test-id=\"youngFamilyDiscount\"]]")
    WebElement YoungFamily;

    @FindBy(xpath = "//div[@data-pid=\"ColumnsContainer-2999841\"]//h2[@class=\"t-header-big\"]")
    WebElement Pointer;

    public void switchToFrame() {
        (new WebDriverWait(BaseSteps.getDriver(), 10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Frame));
    }

    public void clickOnSwitcher(String Name) throws InterruptedException {
        scrollToElement(CreditTerm);
        switch (Name){
            case "Есть зарплатная карта Cбербанка":
                SalaryCardExistance.click();
                waitWhileValueChanges(MonthlyPayment);
                waitVisibilityOfElement(CanConfirm);
                break;
            case "Молодая семья":
                YoungFamily.click();
                waitWhileValueChanges(MonthlyPayment);
        }

    }

    public void inputValue(String Name, String Value) throws InterruptedException {
        switch (Name){
            case  "Стоимость недвижимости":
                fillField(Sum, Value);
                break;
            case  "Первоначальный взнос":
                fillField(InitialFee, Value);
                break;
            case  "Срок кредита":
                fillField(CreditTerm, Value);
                break;
            default:  throw new AssertionError("Поле '"+Name+"' не объявлено на странице");
        }
    }

    public static WebElement getValue(String Name) {

        switch (Name) {
            case "Сумма кредита":
                return AmountOfCredit;
            case "Ежемесячный платеж":
                return MonthlyPayment;
            case "Необходимый доход":
                return RequiredIncome;
            case "Процентная ставка":
                return Rate;
            default:
                throw new AssertionError("Нет такого параметра");
        }
    }

    public MortgagePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
