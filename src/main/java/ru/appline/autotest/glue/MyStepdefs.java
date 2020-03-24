package ru.appline.autotest.glue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import ru.appline.autotest.pages.MainPage;
import ru.appline.autotest.steps.BaseSteps;
import ru.appline.autotest.steps.MainPageSteps;
import ru.appline.autotest.steps.MortgagePageSteps;

import java.util.Map;

public class MyStepdefs {

    private MainPageSteps mainPageSteps = new MainPageSteps();

    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @Before
    public void before() throws Exception {
        BaseSteps.setUp();
    }


    @Когда("^выбрано меню Ипотека$")
    public void выбрано_меню_Ипотека(){
        mainPageSteps.moveCursorToMortgageButton();
    }

    @Когда("^выбран вид ипотеки Ипотека на готовое жильё$")
    public void выбран_вид_ипотеки_Ипотека_на_готовое_жильё(){ mainPageSteps.clickOnMortgageCompleteHouse();;
    }

    @Когда("^выполнен переход на форму расчёта параметров ипотеки$")
    public void выполнен_переход_на_форму_расчета_ипотеки(){ mortgagePageSteps.switchToFrame();
    }

    @Когда("^заполняются поля:$")
    public void заполняются_поля(DataTable fields){
        Map<String,String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach((Name, Value) -> {
            try {
                new MortgagePageSteps().inputValue(Name, Value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Когда("^выполнено нажатие на кнопку \"Молодая семья\"$")
    public void нажатие_на_кнопку_Молодая_семья() throws InterruptedException {
        mortgagePageSteps.clickOnSwitcher("Молодая семья");
    }

    @Когда("^выполнено нажатие на кнопку \"Есть зарплатная карта Cбербанка\"$")
    public void нажатие_на_кнопку_Зарплатная_карта() throws InterruptedException {
        mortgagePageSteps.clickOnSwitcher("Есть зарплатная карта Cбербанка");
    }

    @Тогда("^значения полей равны:$")
    public void значения_полей_равны(DataTable fields) {
        Map<String,String> dataMap = fields.asMap(String.class, String.class);
        dataMap.forEach((Name, Value) -> mortgagePageSteps.checkFieldValue(Name, Value));
    }

    @After
    public void after() throws Exception {
        BaseSteps.tearDown();
    }


}
