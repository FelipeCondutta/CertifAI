package com.certifai.CertifAI.infrastructure.persistence.jpa;

import com.certifai.CertifAI.domain.users.User;
import com.certifai.CertifAI.domain.users.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final SpringUserJpaRepository jpaRepository;
    private final UserMapper mapper;

    public UserRepositoryImpl(SpringUserJpaRepository jpaRepository, UserMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<User> existsByEmail(String email) {
        return jpaRepository.existsByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void deleteUserById(Long id) {
        if(jpaRepository.existsById(id)){
            jpaRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Usuario com ID" + id +"nao encontrado");
        }
    }
    @Override
    public Optional<User> findById(Long id){
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
    @Override
    public List<User> findAll(){
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
