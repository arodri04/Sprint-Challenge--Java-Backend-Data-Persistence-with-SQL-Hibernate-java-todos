package com.sprint.crudapi.crudapi.Service;

import com.sprint.crudapi.crudapi.Model.ToDo;
import com.sprint.crudapi.crudapi.Repository.ToDoRepository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private ToDoRepository todorepos;

    @Override
    public ArrayList<ToDo> findAll() {
        ArrayList<ToDo> list = new ArrayList<>();
        todorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

}
