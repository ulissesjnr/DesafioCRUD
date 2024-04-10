package com.ulisses.service;

import java.util.List;
import java.util.Optional;

import com.ulisses.dto.UserDTO;

public interface IUserService {
    public UserDTO create(final UserDTO user);

    public Optional<UserDTO> findById(final Long  id);

    public List<UserDTO> findAll();

    public UserDTO update(final UserDTO user);

    public void delete(final Long id);
}
