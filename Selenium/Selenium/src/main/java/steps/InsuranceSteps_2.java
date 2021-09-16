package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.InsurancePage_2;

import java.util.HashMap;

public class InsuranceSteps_2 extends BaseSteps {

    private InsurancePage_2 insurancePage_2;

    public InsuranceSteps_2() {
        insurancePage_2 = new InsurancePage_2(testService.getInitDriver());
    }


    @Step("поле {0} заполняется значением {1}")
    public void stepFillInsuranceField(String field, String value) {
        insurancePage_2.fillInsuranceField(field, value);
    }

    @Step("заполняются поля:")
    public void stepFillInsuranceFields(HashMap<String, String > fields) {
        fields.forEach(this::stepFillInsuranceField);
    }

    @Step("нажатие клавиши TAB")
    public void stepClickTAB (){
        insurancePage_2.secureDateBirth.sendKeys(Keys.TAB);
    }

    @Step("нажатие клавиши 'Продолжить'")
    public void stepClickContinueButton (){
        insurancePage_2.continuebutton.click();
    }

    @Step("выбор пола")
    public void stepGenderChoose(String gender){
        insurancePage_2.getElementByGender(gender).click();
    }

    @Step("проверка возникновения ошибки")
    public void stepCheckFieldErrorMessage(String error){
        insurancePage_2.checkFieldErrorMessage(error);
    }


}
