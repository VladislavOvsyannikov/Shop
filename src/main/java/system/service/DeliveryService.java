package system.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void addFoodToCart(int id) {
        List<Cart> carts = getCurrentUser().getCart();
        if (carts.isEmpty() || getLastCart().getStatus().equals("confirm")) {
            Cart cart = new Cart();
            cart.setDate(null);
            cart.setStatus("not confirm");
            List<Food> temp = new ArrayList<Food>();
            temp.add(getFood(id));
            cart.setFoods(temp);
            carts.add(cart);
            cartDao.saveCart(cart);
        } else {
            List<Food> foods = getLastCart().getFoods();
            foods.add(getFood(id));
            cartDao.update(getLastCart());
        }

    }

    public void confirmCart() {
        Cart cart = getLastCart();
        cart.setStatus("confirm");
        cartDao.updateCart(cart);
    }

    public Cart getLastCart() {
        List<Cart> carts = getCurrentUser().getCart();
        int max = -1;
        int maxind = 0;
        for (int i = 0; i < carts.size(); ) {
            if (carts.get(i).getId() > max) {
                max = carts.get(i).getId();
                maxind = i;
            }
        }
        return carts.get(maxind);
    }

    public void addFood(int id, Cart cart) {
        List<Food> foods = cart.getFoods();
        foods.add(getFood(id));
    }

    public User getCurrentUser() {
        return userDao.getUser(getUserName());
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
