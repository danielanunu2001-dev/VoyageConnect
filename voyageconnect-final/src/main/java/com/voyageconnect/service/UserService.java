package com.voyageconnect.service;

import com.voyageconnect.model.User;
import java.util.Optional;

public interface UserService {
    void registerUser(User user);
    Optional<User> findByEmail(String email);
}
