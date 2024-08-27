package com.diyconnect.user;

import com.diyconnect.exception.cityException.CityException;
import com.diyconnect.exception.userException.NoUsersForCityException;
import com.diyconnect.exception.userException.UserException;
import com.diyconnect.exception.userException.UserNotFoundException;
import com.diyconnect.message.Message;
import com.diyconnect.user.payload.ModifyCityRequest;
import com.diyconnect.user.payload.SaveNewUserRequest;
import com.diyconnect.user.payload.UserDTO;
import com.diyconnect.utils.mappers.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    private DTOMapper dtoMapper = new DTOMapper();

    @PostMapping("/savenewuser")
    public ResponseEntity<?> saveNewUser(@RequestBody SaveNewUserRequest user){
        try{
            User savedUser = new User(
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    user.isAdmin()
            );

            userService.save(savedUser);

            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        }catch(UserException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyusername")
    public ResponseEntity<?> findByUsername(@RequestParam String username){
        try{
            User user = userService.findByUsername(username).get();

            UserDTO userDTO = dtoMapper.userToDTO(user);

            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);

        }catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

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

    @PostMapping("/modifyCity")
    public ResponseEntity<?> modifyCity(@RequestBody ModifyCityRequest request){
        try{
            User user = userService.modifyCity(request.getCityName(), request.getUserEmail()).get();

            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (UserException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch(CityException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAllUsers(){
        List <User> users = userService.findAll();
        List<UserDTO> usersDto = dtoMapper.ListUsersToDTO(users);

        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping("/confirmregistration")
    public String confirmRegistration(@RequestParam("token") String token) {
        try {
            userService.activateUser(token);
            return "Account activated successfully!";
        } catch (Exception e) {
            return "Activation failed: " + e.getMessage();
        }
    }
}
