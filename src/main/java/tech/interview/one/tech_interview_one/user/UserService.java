package tech.interview.one.tech_interview_one.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id){
        return this.userRepository.findById(id);
    }
}