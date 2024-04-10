package com.ulisses.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ulisses.dto.UserDTO;
import com.ulisses.service.UserService;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Log4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody final UserDTO user) {
        final UserDTO createdUser = userService.create(user);
        logger.debug(String.format("User with ID %1$s created.", user.getId()));
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserDTO> getAllUsers() {
        final List<UserDTO> users = userService.findAll();
        logger.debug("All users found");
        return users;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserById(@RequestParam("id") final Long id) {
        return userService.findById(id).map(dto -> {
            final UserDTO founddUser = userService.create(dto);
            logger.debug(String.format("User with ID %1$s found.", id));
            return new ResponseEntity<>(founddUser, HttpStatus.OK);
        }).orElseGet(() -> {
            logger.debug(String.format("User with ID %1$s not found.", id));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
    }

   @RequestMapping(method = RequestMethod.PUT)
   public ResponseEntity<UserDTO> updateUser(@RequestBody final UserDTO user) {
        return userService.findById(user.getId()).map(dto -> {
            final UserDTO updatedUser = userService.update(user);
            logger.debug(String.format("User with ID %1$s updated.", user.getId()));
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }).orElseGet(() -> {
            logger.debug(String.format("User with ID %1$s not found.", user.getId()));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
   }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<UserDTO> deleteUser(@RequestParam("id") final Long id) {

        return userService.findById(id).map(dto -> {
            userService.delete(id);
            logger.debug(String.format("User with ID %1$s deleted.", id));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }).orElseGet(() -> {
            logger.debug(String.format("User with ID %1$s not found.", id));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
    }

}
