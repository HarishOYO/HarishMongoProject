package ProjextUsingMongodb.HarishMongoProject.service;

import ProjextUsingMongodb.HarishMongoProject.user.User;
import ProjextUsingMongodb.HarishMongoProject.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void removeUser(String userid){

       userRepository.deleteById(userid);

    }
    public List<User> getAllUser(){

        return userRepository.findAll();
    }

}
