package com.voyageconnect.dao;

import com.voyageconnect.model.User;
import java.util.Optional;

public interface UserDAO {
    void save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
}
