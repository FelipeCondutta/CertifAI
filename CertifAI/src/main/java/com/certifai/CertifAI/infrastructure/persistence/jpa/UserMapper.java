package com.certifai.CertifAI.infrastructure.persistence.jpa;

import com.certifai.CertifAI.domain.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(User user){
        UserEntity entity = new UserEntity();

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        return entity;
    }

    public User toDomain(UserEntity entity){
        return new User(entity.getName(), entity.getEmail(), entity.getPassword());
    }
}
