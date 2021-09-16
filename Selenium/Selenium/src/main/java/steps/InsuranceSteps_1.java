package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.InsurancePage_1;


public class InsuranceSteps_1 extends BaseSteps{

    private InsurancePage_1 insurancePage_1;

    public InsuranceSteps_1() {
        insurancePage_1 = new InsurancePage_1(testService.getInitDriver());
    }

    @Step ("проверка, что выбрана 'Минимальная'")
    public void stepMinCheck (){
        Assertions.assertTrue(insurancePage_1.minCheck.getAttribute("class").contains("selected"));
    }

    @Step("поле {0} заполняется значением {1}")
    public void stepCheckoutInsurance() {
        insurancePage_1.checkoutInsurance.click();
    }
}
