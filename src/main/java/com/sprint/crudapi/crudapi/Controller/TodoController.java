package com.sprint.crudapi.crudapi.Controller;


import com.sprint.crudapi.crudapi.Model.User;
import com.sprint.crudapi.crudapi.Service.TodoService;
import com.sprint.crudapi.crudapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/todo")
public class TodoController
{
   @Autowired
   private TodoService todoService;
   @Autowired
   private UserService userService;

   @GetMapping(value = "/todos", produces = {"application/json"})
    public ResponseEntity<?> findAll()
   {
      String currentuser;
      Authentication userAuth = SecurityContextHolder.getContext().getAuthentication();
      currentuser = userAuth.getName();
      User user = userService.findUserName(currentuser);
      return new ResponseEntity<>(user, HttpStatus.OK);
   }
}
