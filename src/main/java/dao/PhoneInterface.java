package dao;

import app.model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneInterface extends CrudRepository<Phone, Long> {
}
