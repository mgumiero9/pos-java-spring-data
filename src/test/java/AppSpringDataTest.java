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
    public void testDisplayUser() {
        final Optional<Customer> customer = customerInterface.findById(1L);
        System.out.println(customer);
    }

    @Test
    public void testDisplayUserParamsOnly() {
        final Optional<Customer> customer = customerInterface.findById(1L);
        System.out.println(customer.get().getAge());
        System.out.println(customer.get().getEmail());
        System.out.println(customer.get().getId());
        System.out.println(customer.get().getName());
        System.out.println(customer.get().getUsername());
        System.out.println(customer.get().getPassword());
    }

    @Test
    public void testDisplayAllUsers() {
        final Iterable<Customer> customers = customerInterface.findAll();
        customers.forEach(System.out::println);
    }

    @Test
    public void testUpdateUser() {
        final Optional<Customer> optionalCustomer = customerInterface.findById(1L);
        final Customer customer = optionalCustomer.orElse(null);
        assert customer != null;
        customer.setName("NameChanged");
        customerInterface.save(customer);
    }

    @Test
    public void testDeleteUserById() {
        customerInterface.deleteById(36L);
    }

    @Test
    public void testDeleteUser() {
        final Optional<Customer> optionalCustomer = customerInterface.findById(34L);
        final Customer customer = optionalCustomer.orElse(null);
        assert customer != null;
        customerInterface.delete(customer);
    }

}
