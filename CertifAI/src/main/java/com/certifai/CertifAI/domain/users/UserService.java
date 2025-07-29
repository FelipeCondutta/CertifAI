package com.certifai.CertifAI.domain.users;

import com.certifai.CertifAI.infrastructure.persistence.jpa.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserJpaRepository userRepository;
    public UserService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insertUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
