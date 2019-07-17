package ProjextUsingMongodb.HarishMongoProject.userTemplate;

import ProjextUsingMongodb.HarishMongoProject.user.User;

import java.util.List;

public interface UsarDAL {

    List<User> getalluser();

    User getUser(String userId);

    User adduser(User user);

    Object getusersetting(String userId);

    //String getUserSetting(String userId, String key);

    String addusersetting(String userId, String key, String value);
}
