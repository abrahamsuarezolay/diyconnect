package com.diyconnect.city;

import com.diyconnect.exception.cityException.CityException;
import com.diyconnect.exception.cityException.NotFoundCityException;
import com.diyconnect.utils.mappers.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    private DTOMapper dtoMapper = new DTOMapper();

    @GetMapping("/byname")
    public ResponseEntity<?> getCityByName(@RequestParam String cityName){
        try{
            City city = cityService.findByName(cityName).get();
            CityDTO cityDTO = dtoMapper.cityToDTO(city);

            return new ResponseEntity<CityDTO>(cityDTO, HttpStatus.OK);

        }catch(NotFoundCityException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
