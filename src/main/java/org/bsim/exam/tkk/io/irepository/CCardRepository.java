package org.bsim.exam.tkk.io.irepository;

import org.bsim.exam.tkk.io.entity.CCardEntity;
import org.bsim.exam.tkk.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CCardRepository extends JpaRepository<CCardEntity,Long> {
    List<CCardEntity> findAllByUser(UserEntity userEntity);
    CCardEntity findByCardSerialId(String cardSerialId);
}
