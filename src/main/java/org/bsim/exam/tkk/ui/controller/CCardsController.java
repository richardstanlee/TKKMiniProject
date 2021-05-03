package org.bsim.exam.tkk.ui.controller;

import org.bsim.exam.tkk.service.iservice.ICCardService;
import org.bsim.exam.tkk.shared.dto.CCardDTO;
import org.bsim.exam.tkk.ui.model.request.CCardRequest;
import org.bsim.exam.tkk.ui.model.response.CCardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.CacheResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ccards")
public class CCardsController {
    @Autowired
     ICCardService cardService;

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CCardResponse> getAllCards(@PathVariable String userId){
        List<CCardResponse> value = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        List<CCardDTO> cCardDTOS = cardService.getAllCardsData(userId);

        for (CCardDTO cCardDTO : cCardDTOS){
            value.add(mapper.map(cCardDTO, CCardResponse.class));
        }
        return value;
    }

    @PostMapping(path = "/{userid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CCardResponse addNewCCardData(@PathVariable String userid, @RequestBody CCardRequest cCardRequest){
        ModelMapper mapper = new ModelMapper();

        CCardDTO cCardDTO = mapper.map(cCardRequest, CCardDTO.class);
        CCardDTO createdCcard = cardService.addNewCCardData(userid, cCardDTO);
        return mapper.map(createdCcard, CCardResponse.class);
    }

    @PutMapping(path = "/{userid}/{cardSerialId}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public CCardResponse updateCardData(@PathVariable String userid, @PathVariable String cardSerialId , @RequestBody CCardRequest cCardRequest){
        ModelMapper mapper = new ModelMapper();

        CCardDTO cCardDTO = mapper.map(cCardRequest, CCardDTO.class);
        CCardDTO updateCard = cardService.updateCardData(userid,cardSerialId,cCardDTO);
        return mapper.map(updateCard , CCardResponse.class);
    }

    @DeleteMapping(path = "/{userid}/{cardSerialId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CCardResponse deleteCreditCard (@PathVariable String userid, @PathVariable String cardSerialId){
        ModelMapper mapper = new ModelMapper();
        CCardDTO cCardDTO = cardService.deleteCreditCard(userid,cardSerialId);
        return mapper.map(cCardDTO, CCardResponse.class);
    }
}
