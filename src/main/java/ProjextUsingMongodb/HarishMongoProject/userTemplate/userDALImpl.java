package ProjextUsingMongodb.HarishMongoProject.userTemplate;

import ProjextUsingMongodb.HarishMongoProject.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class userDALImpl implements  UsarDAL {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<User> getalluser() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUser(String userId) {
        Query query=new Query();
        query.addCriteria(Criteria.where("userId").is(userId));

        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public User adduser(User user) {
        mongoTemplate.save(user);
        return user;

    }

    @Override
    public Object getusersetting(String userId) {
        Query query =new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        User user=mongoTemplate.findOne(query,User.class);
        return user!=null? user.getHashmap():"User not found";
    }

    @Override
    public String addusersetting(String userId, String key, String value) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        User user = mongoTemplate.findOne(query, User.class);
        if (user != null)
        {
            user.getHashmap().put(key, value);
            mongoTemplate.save(user);
            return "Key added."; }
        else
            {
            return "User not found.";
        }
    }
}
