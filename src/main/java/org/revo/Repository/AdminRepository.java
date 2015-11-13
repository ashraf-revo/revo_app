package org.revo.Repository;

import org.revo.domain.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by revo on 13/11/15.
 */
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Optional<Admin> findByNameAndPassword(String name, String password);

    List<Admin> findAll();
}
