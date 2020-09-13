package dao;

import app.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataCustomerInterface extends CrudRepository<Customer, Long> {

    @Query(value = "select c from Customer c where c.name like %?1%")
    public List<Customer> findCustomerByName (String name);

    @Query(value = "select c from Customer c where c.name = :paramName")
    public Customer findCustomerByParam (@Param("paramName") String paramName);

}
