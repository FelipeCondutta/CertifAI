package com.certifai.CertifAI.domain.users;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> existsByEmail(String email);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteUserById(Long id);
    User save(User user);
}
