import org.junit.jupiter.api.AfterEach;
import util.TestService;


public class BaseTest {


    private TestService testService = new TestService();
    protected void getDriverBaseURL(){
        testService.getInitDriver().get(testService.getBaseURL());
    }


    @AfterEach
    public void tearDown() {
        testService.getInitDriver().quit();
    }

}