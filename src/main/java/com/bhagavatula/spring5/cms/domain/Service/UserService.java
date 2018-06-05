package com.bhagavatula.spring5.cms.domain.Service;

import java.util.List;
import java.util.UUID;

import com.bhagavatula.spring5.cms.domain.models.User;
import com.bhagavatula.spring5.cms.domain.repository.UserRepository;
import com.bhagavatula.spring5.cms.domain.vo.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User update(String id, UserRequest userRequest) {
        final User user = this.userRepository.findOne(id);
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public User create(UserRequest userRequest) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public void delete(String id) {
        final User user = this.userRepository.findOne(id);
        this.userRepository.delete(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findOne(String id) {
        return this.userRepository.findOne(id);
    }
}
