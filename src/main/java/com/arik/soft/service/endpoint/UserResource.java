package com.arik.soft.service.endpoint;

import com.arik.soft.domain.User;
import com.arik.soft.service.UserService;
import com.arik.soft.service.authorization.AuthorizationService;
import com.arik.soft.service.representation.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity userDetails() {
        return new ResponseEntity(userService.getUserDetails(), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity addNewUser(@NotNull @RequestBody UserRepresentation userRepresentation) {
        User user = UserRepresentation.getUser(userRepresentation);
        user.setPassword(authorizationService.generateHashedPassword(userRepresentation.getPassword()));

        return new ResponseEntity(userService.saveUser(new UserRepresentation(user)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserDetailById(@PathVariable final Long id) {
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable final Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
