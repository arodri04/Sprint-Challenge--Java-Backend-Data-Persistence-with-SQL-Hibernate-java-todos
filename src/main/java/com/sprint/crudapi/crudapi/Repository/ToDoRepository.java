package com.sprint.crudapi.crudapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.sprint.crudapi.crudapi.Model.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Long>
{
}
