package com.diyconnect.user;

import com.diyconnect.exception.userException.NoUsersForCityException;
import com.diyconnect.utils.mappers.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    private DTOMapper dtoMapper = new DTOMapper();

    @GetMapping("/findByCity")
    public ResponseEntity<?> findUsersByCityName(@RequestParam  String cityName){
        try{
            List<User> users = userService.findByCityName(cityName).get();
            List<UserDTO> usersDTO = dtoMapper.ListUsersToDTO(users);

            return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);

        }catch(NoUsersForCityException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
