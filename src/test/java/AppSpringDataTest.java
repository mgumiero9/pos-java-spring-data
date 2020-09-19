import app.model.Customer;
import app.model.Phone;
import dao.PhoneInterface;
import dao.SpringDataCustomerInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

    @Autowired
    private SpringDataCustomerInterface customerInterface;
    @Autowired
    private PhoneInterface phoneInterface;

    @Test
    public void testConfig() {
        System.out.println("successfully initiated");
    }

    @Test
    public void testInsertCustomer() {
        final Customer customer = new Customer();
        customer.setAge(48);
        customer.setEmail("email@domain8");
        customer.setName("Marcelo8");
        customer.setUsername("mgumiero8");
        customer.setPassword("pwd8");
        customerInterface.save(customer);
    }

    @Test
    public void testDisplayUser() {
        final Optional<Customer> customer = customerInterface.findById(40L);
        System.out.println(customer);
    }

    @Test
    public void testDisplayPhone() {
        final Optional<Phone> optionalPhone = phoneInterface.findById(41l);
        System.out.println(optionalPhone.orElse(null));
    }

    @Test
    public void testDisplayUserParamsOnly() {
        final Optional<Customer> customer = customerInterface.findById(1L);
        assert customer.isPresent();
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

    @Test
    public void testFindNameByString() {
        final List<Customer> list = customerInterface.findCustomerByName("Marcelo");
        list.forEach(System.out::println);
    }

    @Test
    public void testFindCustomerByParam() {
        final Customer customer = customerInterface.findCustomerByParam("Marcelo2");
        System.out.println(customer);
    }

    @Test
    public void testDeleteByName() {
        customerInterface.deleteByName("Marcelo4");
        System.out.println("user deleted or non-existent");
    }

    @Test
    public void testUpdateByName() {
        customerInterface.updateByName("Marcelo6", 46);
    }

    @Test
    public void testInsertPhone() {
        final Phone phone = new Phone();
        final Customer customer = customerInterface.findCustomerByParam("Marcelo7");
        phone.setCustomer(customer);
        phone.setType("mobile");
        phone.setNumber("777770");
        phoneInterface.save(phone);
    }

    @Test
    public void testUpdateCustomerPhone() {
        final Customer customer = customerInterface.findCustomerByParam("Marcelo7");
        final Optional<Phone> optionalPhone = phoneInterface.findById(43L);
        final ArrayList<Phone> phones = new ArrayList<>();
        phones.add(optionalPhone.orElse(null));
        customer.setPhones(phones);
        customerInterface.save(customer);
    }

}
