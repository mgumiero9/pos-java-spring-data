import dao.SpringDataCustomerInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

    @Autowired
    private SpringDataCustomerInterface customerInterface;

    @Test
    public void testConfig() {
        System.out.println("successfully initiated");
    }

}
