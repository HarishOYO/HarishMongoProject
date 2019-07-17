
package ProjextUsingMongodb.HarishMongoProject.usercontroller;




import ProjextUsingMongodb.HarishMongoProject.service.UserService;
import ProjextUsingMongodb.HarishMongoProject.user.User;
import ProjextUsingMongodb.HarishMongoProject.userRepository.UserRepository;
//import ProjextUsingMongodb.HarishMongoProject.userTemplate.UsarDAL;
import ProjextUsingMongodb.HarishMongoProject.userTemplate.UsarDAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
   @Autowired
   private UserService userService;


   // private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Logger logger= LoggerFactory.getLogger(getClass());

    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @RequestMapping(value = "/alluser",method = RequestMethod.GET)
    public List<User> getalluser(){
       return userService.getAllUser();

    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public User adduser(@RequestBody User user)
    {  logger.info("User added");
        return userRepository.save(user);
    }
    @RequestMapping(value ="/{userid}" ,method = RequestMethod.GET)
    public User getUser(@PathVariable String userid)
    {
        logger.info("Get one user details...");
        Optional<User> userOptional= userRepository.findById(userid);
       // if(userOptional.isPresent())
              return userOptional.get();

    }
    @RequestMapping(value = "/removeuser/{userid}",method = RequestMethod.DELETE)
    public void removeUser(@PathVariable String userid){
               userService.removeUser(userid);

    }
    @RequestMapping(value = "/usersettings/{userid}",method = RequestMethod.GET)
    public Object getusersetting(@PathVariable String userid){
        User user=userRepository.findById(userid).orElse(null);
        if(user!=null)
            return user.getHashmap();//getHashmap()work as getusersetting();
        else
            return "user Not Found";
    }
    @RequestMapping(value = "/addsettings/{userid}/{key}/{value}",method = RequestMethod.GET)
    public  String addusersetting(@PathVariable String userid,@PathVariable String  key,@PathVariable String value)
    {
        User user=userRepository.findById(userid).orElse(null);
        if(user!=null)
        {
            user.getHashmap().put(key,value);
            userRepository.save(user);
            return "key added";

        }
        else
            return "key not found";
    }


}
