package ProjextUsingMongodb.HarishMongoProject.userRepository;

import ProjextUsingMongodb.HarishMongoProject.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {



}
