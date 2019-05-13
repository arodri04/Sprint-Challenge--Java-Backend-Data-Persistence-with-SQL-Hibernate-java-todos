package com.sprint.crudapi.crudapi;

import com.sprint.crudapi.crudapi.Model.Role;

import com.sprint.crudapi.crudapi.Model.ToDo;
import com.sprint.crudapi.crudapi.Model.User;
import com.sprint.crudapi.crudapi.Model.UserRoles;
import com.sprint.crudapi.crudapi.Repository.RoleRepository;
import com.sprint.crudapi.crudapi.Repository.ToDoRepository;
import com.sprint.crudapi.crudapi.Repository.UserRepository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;


@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    ToDoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, ToDoRepository todorepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);

        User u1 = new User("sam", "gottem", users);
        User u2 = new User("admin", "password", admins);




        u1.getTodos().add(new ToDo("Quit Lamnda and be a stripper", u1));
        u1.getTodos().add(new ToDo("cry", u1));
//        User u3 = new User("Bob", "password", users);
//        User u4 = new User("Jane", "password", users);

        // the date and time string should get coverted to a datetime Java data type. This is done in the constructor!
//        u4.getToDos().add(new ToDo("Finish java-orders-swagger", "2019-01-13 04:04:04", u4));
//        u4.getToDos().add(new ToDo("Feed the turtles", "2019-03-01 04:04:04", u4));
//        u4.getToDos().add(new ToDo("Complete the sprint challenge", "2019-02-22 04:04:04", u4));
//
//        u3.getToDos().add(new ToDo("Walk the dogs", "2019-01-17 04:04:04", u3),
//                u3.getToDos().add(new ToDo("provide feedback to my instructor", "2019-02-13 04:04:04", u3);

        userrepos.save(u1);
        userrepos.save(u2);
//        userrepos.save(u3);
//        userrepos.save(u4);
        System.out.println(u1.getUsername());
        System.out.println(u1.getTodos());
    }
}
