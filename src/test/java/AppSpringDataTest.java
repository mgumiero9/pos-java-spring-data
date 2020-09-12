import app.model.Customer;
import dao.SpringDataCustomerInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

    @Autowired
    private SpringDataCustomerInterface customerInterface;

    @Test
    public void testConfig() {
        System.out.println("successfully initiated");
    }

    @Test
    public void testInsert() {
        final Customer customer = new Customer();
        customer.setAge(45);
        customer.setEmail("email@domain3");
        customer.setName("Marcelo3");
        customer.setUsername("mgumiero3");
        customer.setPassword("pwd3");

        customerInterface.save(customer);
    }

    @Test
    public void displayUser() {
        final Optional<Customer> customer = customerInterface.findById(1L);
        System.out.println(customer);
    }

    @Test
    public void displayAllUsers() {
        final Iterable<Customer> customers = customerInterface.findAll();
        customers.forEach(System.out::println);
    }

}
