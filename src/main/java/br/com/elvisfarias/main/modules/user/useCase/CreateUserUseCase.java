package br.com.elvisfarias.main.modules.user.useCase;

import br.com.elvisfarias.main.modules.user.entity.UserEntity;
import br.com.elvisfarias.main.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public UserEntity execute(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
