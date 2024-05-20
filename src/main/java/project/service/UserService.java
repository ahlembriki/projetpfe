package project.service;

import project.models.UserEntity;

public interface UserService {
    UserEntity findByid(Long id);
}
