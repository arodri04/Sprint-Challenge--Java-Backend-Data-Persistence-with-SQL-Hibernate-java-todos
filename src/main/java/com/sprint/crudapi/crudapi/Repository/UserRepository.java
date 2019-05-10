package com.sprint.crudapi.crudapi.Repository;

import com.sprint.crudapi.crudapi.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}