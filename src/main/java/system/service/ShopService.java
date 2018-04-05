package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import system.dao.GenericDao;
import system.dao.UserDao;
import system.model.User;

import java.util.List;

@Service
public class ShopService {

    private UserDao userDao;

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
        if (auth.getName().equals("anonymousUser")){
            return "Гость";
        }else return auth.getName();
    }

    public void deleteUser(User user){
        User user1 = userDao.getUser(user.getName());
        userDao.deleteUser(user1);
    }

    public List getAllUsers(){
        return  userDao.getAllUsers();
    }
}
