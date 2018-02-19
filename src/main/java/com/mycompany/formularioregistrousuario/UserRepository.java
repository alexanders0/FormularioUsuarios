package com.mycompany.formularioregistrousuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexanders0
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByIdentityCard(Integer identityCard);
}
