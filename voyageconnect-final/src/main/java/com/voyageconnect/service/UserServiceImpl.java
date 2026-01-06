package com.voyageconnect.service;

import com.voyageconnect.dao.UserDAO;
import com.voyageconnect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        // Hasher le mot de passe avant de sauvegarder
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Par défaut, un nouvel utilisateur est un CLIENT
        user.setRole("CLIENT");
        userDAO.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
