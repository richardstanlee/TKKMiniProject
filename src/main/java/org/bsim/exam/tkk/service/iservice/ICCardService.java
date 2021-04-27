package org.bsim.exam.tkk.service.iservice;

import org.bsim.exam.tkk.shared.dto.CCardDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICCardService {

    CCardDTO addNewCCardData(String userid, CCardDTO cCardDTO);

    List<CCardDTO> getAllCardsData(String userid);


    CCardDTO deleteCreditCard(String userid, String cardSerialId);

    CCardDTO updateCardData(String userid, String cardSerialId, CCardDTO cCardDTO);
}
