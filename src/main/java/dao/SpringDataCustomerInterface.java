package dao;

import app.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SpringDataCustomerInterface extends CrudRepository<Customer, Long> {

    @Query(value = "select c from Customer c where c.name like %?1%")
    public List<Customer> findCustomerByName (String name);

    @Query(value = "select c from Customer c where c.name = :paramName")
    public Customer findCustomerByParam (@Param("paramName") String paramName);

    /* How to use Interface custom methods: CTRL+Space and select ex. `save` */
    /* you will see something like: */

    /* @Override */
    /* <S extends Customer> S save(S entity); */

    /* remove @Override to allow you to rename method */
    /* And do something like this below, not forgetting to use `save` at the end... */

    default <S extends Customer> S saveCurrent(S entity) {
        // process what you want
        return save(entity);
    }

    @Modifying
    @Transactional
    @Query(value = "delete from Customer c where c.name = ?1")
    public void deleteByName (String name);
}
