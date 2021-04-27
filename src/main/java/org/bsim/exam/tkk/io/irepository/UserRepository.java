package org.bsim.exam.tkk.io.irepository;

import org.bsim.exam.tkk.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserId(String userid);

}
