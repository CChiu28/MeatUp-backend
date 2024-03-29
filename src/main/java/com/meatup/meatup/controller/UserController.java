package com.meatup.meatup.controller;

import com.meatup.meatup.model.UserDTO;
import com.meatup.meatup.model.Users;
import com.meatup.meatup.repository.UserRepository;
import com.meatup.meatup.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173","https://meatup1028.netlify.app/"})
public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    private ModelMapper modelMapper;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        System.out.println("Getting all users...");
        return userService.getAllUsers();
    }

    @GetMapping("/users/friends/{uid}")
    public Set<UserDTO> getFriendsOfUser(@PathVariable String uid) {
        Set<Users> set = userRepository.findByUid(uid).getAddedFriends();
        System.out.println("Getting friends of user "+uid);
        return convertToDto(set);
    }
    @GetMapping("/users/{uid}")
    public Users getUserByUid(@PathVariable String uid) {
        return userRepository.findByUid(uid);
    }

//    @GetMapping("/users/{email}")
//    public Users getUserByEmail(@PathVariable String email) {
//        return userRepository.findByEmail(email);
//    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        Users user = convertFromDto(userDTO);
        System.out.println(user);
        if (!userRepository.existsByUid(user.getUid()))
            userRepository.save(user);
    }

    @PostMapping("/users/add/{uid}/{friendId}")
    public void addFriend(@PathVariable String uid, @PathVariable String friendId) {
        Users user = userRepository.findByUid(uid);
        if (userRepository.existsByUid(friendId)) {
            Users friend = userRepository.findByUid(friendId);
            user.getAddedFriends().add(friend);
            friend.getAddedFriends().add(user);
            userRepository.save(user);
            userRepository.save(friend);
        } else System.out.println("no");
    }

    @DeleteMapping("users/delete/{uid}/{friendId}")
    public void deleteFriend(@PathVariable String uid, @PathVariable String friendId) {
        Users user = userRepository.findByUid(uid);
        if (userRepository.existsByUid(friendId)) {
            Users friend = userRepository.findByUid(friendId);
            user.getAddedFriends().remove(friend);
            userRepository.save(user);
        } else System.out.println("Failed to remove friend");
    }

    private Set<UserDTO> convertToDto(Set<Users> set) {
        if (!set.isEmpty()) {
            Set<UserDTO> userDTO = new HashSet<>();
            set.forEach(user -> {
                userDTO.add(modelMapper.map(user,UserDTO.class));
            });
            return userDTO;
        } else return new HashSet<>();
    }

    private Users convertFromDto(UserDTO userDTO) {
        return modelMapper.map(userDTO,Users.class);
    }
}
