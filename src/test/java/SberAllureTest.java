import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.sl.Ter;
import org.junit.Test;
import ru.appline.autotest.pages.MainPage;
import ru.appline.autotest.pages.MortgagePage;
import ru.appline.autotest.steps.BaseSteps;
import ru.appline.autotest.steps.MainPageSteps;
import ru.appline.autotest.steps.MortgagePageSteps;

public class SberAllureTest {

    MainPageSteps mainPageSteps = new MainPageSteps();
    MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @Before
    public void before() throws Exception {
        BaseSteps.setUp();
    }

    @Test
    public void SberTest() throws InterruptedException {

        mainPageSteps
                .moveCursorToMortgageButton()
                .clickOnMortgageCompleteHouse();
        mortgagePageSteps
                .switchToFrame()
                .inputValue("Стоимость недвижимости", "5180000")
                .inputValue("Первоначальный взнос","3058000")
                .inputValue("Срок кредита", "30")
                .clickOnSwitcher("Есть зарплатная карта Cбербанка")
                .clickOnSwitcher("Молодая семья")
                .checkFieldValue("Сумма кредита","2 122 000 ₽")
                .checkFieldValue("Ежемесячный платёж", "17 535 ₽")
                .checkFieldValue("Необходимый доход", "29 224 ₽")
                .checkFieldValue("Процентная ставка", "11 %");
    }

    @After
    public static void tearDown() throws Exception {
        BaseSteps.tearDown();
    }


}
