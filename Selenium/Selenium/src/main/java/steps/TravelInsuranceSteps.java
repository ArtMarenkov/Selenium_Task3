package steps;

import io.qameta.allure.Step;
import pages.TravelInsurancePage;

public class TravelInsuranceSteps extends BaseSteps{

    private TravelInsurancePage travelInsurancePage;

    public TravelInsuranceSteps() {
        travelInsurancePage = new TravelInsurancePage(testService.getInitDriver());
    }

    @Step("нажатие на кнопку 'Оформить онлайн")
    public void stepTravelInsurance() {
        travelInsurancePage.checkout.click();
    }
}
