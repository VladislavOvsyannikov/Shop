package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import system.dao.CartDao;
import system.dao.FoodDao;
import system.dao.TypeDao;
import system.dao.UserDao;
import system.model.Cart;
import system.model.Food;
import system.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeliveryService {

    private UserDao userDao;

    private FoodDao foodDao;

    private TypeDao typeDao;

    private CartDao cartDao;

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

    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public boolean addUser(User user) {
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

    public String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @Secured("ROLE_USER")
    public void addFoodToCart(int id) {
        Cart cart1 = getLastCart();
        if (cart1 == null || cart1.getStatus().equals("confirm")) {
            Cart cart = new Cart();
            cart.setStatus("not confirm");
            cart.setUser(getCurrentUser());
            List<Food> foods = new ArrayList<Food>();
            foods.add(getFood(id));
            cart.setFoods(foods);
            cartDao.saveCart(cart);
        } else {
            List<Food> foods = cart1.getFoods();
            foods.add(getFood(id));
            cartDao.update(cart1);
        }
    }

    public void deleteFromCart(int id) {
        List<Food> foods = getLastCart().getFoods();
        if (foods.size() != 1) {foods.remove(getFood(id));}
        else {foods.clear();}
    }

    public void confirmCart() {
        Cart cart = getLastCart();
        cart.setStatus("confirm");
        cart.setDate(new Date());
        cartDao.updateCart(cart);
    }

    public Cart getLastCart() {
        List<Cart> carts = getCurrentUser().getCart();
        if (carts.size() != 0) {
            int max = -1;
            int maxind = 0;
            for (int i = 0; i < carts.size(); i++) {
                if (carts.get(i).getId() > max) {
                    max = carts.get(i).getId();
                    maxind = i;
                }
            }
            return carts.get(maxind);
        } else return null;
    }

    public User getCurrentUser() {
        return userDao.getUser(getUserName());
    }

    public void updateUser(User user) {
        //надо написать
//        userDao.updateUser(user);
    }


    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    public List getAllFoods() {
        return foodDao.getAllFoods();
    }

    public Food getFood(int id) {
        return foodDao.getFood(id);
    }

    public List getAllTypes() {
        return typeDao.getAllTypes();
    }
}
