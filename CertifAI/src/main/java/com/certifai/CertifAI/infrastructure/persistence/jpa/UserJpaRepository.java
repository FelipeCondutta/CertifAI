package com.certifai.CertifAI.infrastructure.persistence.jpa;

import com.certifai.CertifAI.domain.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);
}
