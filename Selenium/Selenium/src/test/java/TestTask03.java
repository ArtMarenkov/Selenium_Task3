import org.junit.jupiter.api.Test;
import steps.InsuranceSteps_1;
import steps.InsuranceSteps_2;
import steps.MainSteps;
import steps.TravelInsuranceSteps;

import java.util.HashMap;

public class TestTask03 extends BaseTest {


    @Test
    public void testInsurance() {
        getDriverBaseURL();
        MainSteps mainSteps = new MainSteps();
        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Путешествия");

        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();

        travelInsuranceSteps.stepTravelInsurance();

        InsuranceSteps_1 insuranceSteps_1 = new InsuranceSteps_1();
        insuranceSteps_1.stepMinCheck();
        insuranceSteps_1.stepCheckoutInsurance();

        InsuranceSteps_2 insuranceSteps_2 = new InsuranceSteps_2();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия застрахованного", "Тестов");
        testData.put("Имя застрахованного", "Тест");
        testData.put("Дата рождения застрахованного", "13.12.1999");
        insuranceSteps_2.stepClickTAB();

        testData.put("Фамилия страхователя", "Иванова");
        testData.put("Имя страхователя", "Анна");
        testData.put("Отчество страхователя", "Ивановна");
        testData.put("Дата рождения страхователя", "13.01.1999");

        insuranceSteps_2.stepFillInsuranceFields(testData);
        testData.clear();
        insuranceSteps_2.stepClickTAB();
        insuranceSteps_2.stepGenderChoose("Женский");

        testData.put("Серия паспорта", "1001");
        testData.put("Номер паспорта", "123654");
        testData.put("Дата выдачи паспорта", "01.10.2019");
        testData.put("Кем выдан паспорт", "Тестовым отделом");

        insuranceSteps_2.stepFillInsuranceFields(testData);
        insuranceSteps_2.stepClickContinueButton();

        insuranceSteps_2.stepCheckFieldErrorMessage("При заполнении данных произошла ошибка");
    }
}