package br.com.elvisfarias.main.modules.user.repository;

import br.com.elvisfarias.main.modules.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
