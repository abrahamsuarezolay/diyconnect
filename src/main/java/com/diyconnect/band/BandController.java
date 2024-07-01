package com.diyconnect.band;

import com.diyconnect.band.payload.BandDTO;
import com.diyconnect.exception.bandException.BandException;
import com.diyconnect.exception.userException.UserNotFoundException;
import com.diyconnect.utils.mappers.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bands")
public class BandController {

    @Autowired
    BandService bandService;

    private DTOMapper dtoMapper = new DTOMapper();

    @GetMapping("/findByCity")
    public ResponseEntity getBandByCity(@RequestParam String cityName){
        try{
            List<Band> bands = bandService.findByCityName(cityName).get();
            List<BandDTO> bandsDTO = dtoMapper.listBandToDTOs(bands);

            return new ResponseEntity(bandsDTO, HttpStatus.OK);
        }catch(BandException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByUserEmail")
    public ResponseEntity findByUserEmail(@RequestParam String userEmail){
        try{

            List<Band> bandsByUser = bandService.findByUserEmail(userEmail).get();
            List<BandDTO> bandsDTO = dtoMapper.listBandToDTOs(bandsByUser);

            return new ResponseEntity<>(bandsDTO, HttpStatus.OK);

        }catch(BandException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
