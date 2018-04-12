package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import system.dao.FoodDao;
import system.dao.TypeDao;
import system.dao.UserDao;
import system.model.User;

import java.util.List;

@Service
public class DeliveryService {

    private UserDao userDao;

    private FoodDao foodDao;

    private TypeDao typeDao;

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Autowired
    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public boolean addUser(User user){
        List<User> users = userDao.getUsers(user.getName());
        if (!user.getName().equals("") && !user.getPassword().equals("") && users.isEmpty()) {
            User user1 = new User();
            user1.setName(user.getName());
            user1.setPassword(user.getPassword());
            user1.setRole("ROLE_USER");
            userDao.saveUser(user1);
            return true;
        }
        return false;
    }

    public String getUserName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public void addFoodToCart(int id) {
        //надо написать
    }

    public User getCurrentUser(){
        return userDao.getUser(getUserName());
    }

    public List getAllUsers(){
        return  userDao.getAllUsers();
    }

    public List getAllFoods(){
        return  foodDao.getAllFoods();
    }

    public List getAllTypes(){
        return  typeDao.getAllTypes();
    }
}
