package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import system.dao.GenericDao;
import system.model.User;

import java.util.List;

@Service
public class ShopService {

    private GenericDao genericDao;

    @Autowired
    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }


    public boolean addUser(User user){
        List<User> users = genericDao.getList("from User where name=:n", user.getName());
        if (!user.getName().equals("") && !user.getPassword().equals("") && users.isEmpty()) {
            User user1 = new User();
            user1.setName(user.getName());
            user1.setPassword(user.getPassword());
            user1.setRole("ROLE_USER");
            genericDao.save(user1);
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
        User user1 = (User) genericDao.getElement("from User where id=:n", user.getId());
        genericDao.delete(user1);
    }

    public List getAll(String s){
        return genericDao.getAll(s);
    }
}
