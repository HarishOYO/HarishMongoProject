
namespace java  ProjextUsingMongodb.HarishMongoProject

struct User{
    1:string id;
    2:string name;
    3:string date;
    4:map<string,string> hashMapForSetting;
}



service UserService{
    list<User> getAllUser();

    void removeUser(1:string id);
}