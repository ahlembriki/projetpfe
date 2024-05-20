package project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.UserEntity;
import project.repository.UserRepository;
@Service
public class Userimpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserEntity findByid(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
