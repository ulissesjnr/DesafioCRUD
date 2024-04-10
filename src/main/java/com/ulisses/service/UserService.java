package com.ulisses.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulisses.dto.UserDTO;
import com.ulisses.entity.User;
import com.ulisses.repository.UserRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserService implements IUserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final Logger logger = Logger.getLogger(UserService.class);

    public UserDTO create(final UserDTO user) {
        logger.debug(String.format("Creating user with ID %1$s.", user.getId()));
        return this.userRepository.save(user.toEntity()).toDTO();
    }

    public Optional<UserDTO> findById(final Long  id) {
        logger.debug(String.format("Finding user with ID %1$s.", id));
        final Optional<User> optionalUser = Optional.ofNullable(this.userRepository.findOne(id));
        return optionalUser.map(user -> user.toDTO());
    }

    public List<UserDTO> findAll() {
        logger.debug(String.format("Finding all users."));
        return this.userRepository.findAll().stream().map(user -> user.toDTO()).collect(Collectors.toList());
    }

    public UserDTO update(final UserDTO user) {
        logger.debug(String.format("Updating user with ID %1$s.", user.getId()));
        return this.userRepository.save(user.toEntity()).toDTO();
    }

    public void delete(final Long id) {
        logger.debug(String.format("Updating user with ID %1$s.", id));
        this.userRepository.delete(id);
    }
}
