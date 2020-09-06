package dao;

import app.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCustomerInterface extends CrudRepository<Customer, Long> {

}
