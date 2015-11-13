package org.revo.Repository;

import org.revo.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by revo on 13/11/15.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}
