package com.diyconnect.utils.mappers;

import com.diyconnect.city.City;
import com.diyconnect.city.CityDTO;

public class DTOMapper {

    public DTOMapper() {
    }

    public CityDTO cityToDTO(City city){
        return new CityDTO(city.getCity_id(), city.getName(), city.getUsers(), city.getBands());
    }
}
