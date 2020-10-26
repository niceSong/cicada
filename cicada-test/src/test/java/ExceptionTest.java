import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.tyytogetheyy.TestApplication;
import org.tyytogetheyy.service.TestService;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionTest {

    @Autowired
    TestService testService;

    @Test
    public void test(){
        testService.testCicada();
    }
}
