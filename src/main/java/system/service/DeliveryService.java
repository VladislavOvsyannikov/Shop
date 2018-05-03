package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import system.dao.*;
import system.model.Cart;
import system.model.Driver;
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

    private DriverDao driverDao;

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

    @Autowired
    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
    }


    public boolean addUser(User user) {
        List<User> users = userDao.getUsers(user.getName());
        if (!user.getName().equals("") && !user.getPassword().equals("") && users.isEmpty()) {
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setRole("ROLE_USER");
            userDao.saveUser(newUser);
            return true;
        }
        return false;
    }

    public void addCartsToDriver(String data) {
        String[] array = data.split(" ");
//        Driver driver = driverDao.getDriver(driverid);
//        driver.setFree(false);
//        driver.setDate(new Date());
//        Cart cart = cartDao.getCart(cardid);
//        cart.setDriver(driver);
//        cartDao.update(cart);
//        driverDao.update(driver);
    }

    public String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @Secured("ROLE_USER")
    public void addFoodToCart(int id) {
        Cart lastCart = getLastCart();
        if (lastCart == null || lastCart.getStatus().equals("confirm")) {
            Cart cart = new Cart();
            cart.setStatus("not confirm");
            cart.setUser(getCurrentUser());
            List<Food> foods = new ArrayList<Food>();
            foods.add(getFood(id));
            cart.setFoods(foods);
            cartDao.saveCart(cart);
        } else {
            List<Food> foods = lastCart.getFoods();
            foods.add(getFood(id));
            cartDao.update(lastCart);
        }
    }

    public void deleteFromCart(int id) {
        Cart lastCart = getLastCart();
        List<Food> foods = lastCart.getFoods();
        if (foods.size() != 1) {
            foods.remove(getFood(id));
        } else {
            foods.clear();
        }
        cartDao.update(lastCart);
    }

    public void deleteUser(int id) {
        User user = userDao.getUser(id);
        //надо написать и проверить, что при удалении стираются все корзины юзера,
        // а за корзинами стираются все соответствующие записи в таблице foodincart
    }

    public void deleteDriver(int id) {
        Driver driver = driverDao.getDriver(id);
        //надо написать, походу могут быть трудности, если этот водитель доставляет заказ в данный момент
    }


    public Cart getLastCart() {
        List<Cart> carts = getCurrentUser().getCart();
        for (Cart cart : carts) {
            if (cart.getStatus().equals("not confirm") || cart.getStatus().equals("")) {
                return cart;
            }
        }
        return null;
    }

    public User getCurrentUser() {
        User user = userDao.getUser(getUserName());
        return user;
    }

    public void confirmCart() {
        Cart cart = getLastCart();
        cart.setStatus("confirm");
        cart.setDate(new Date());
        cartDao.updateCart(cart);
    }

    public void updateUser(User user) {
        User existedUser = userDao.getUser(user.getId());
        if (user.getName() != null && !user.getName().equals("")) {
            existedUser.setName(user.getName());
        }
        if (user.getPassword() != null && !user.getPassword().equals("")) {
            existedUser.setPassword(user.getPassword());
        }
        if (user.getAddress() != null && !user.getAddress().equals("")) {
            existedUser.setAddress(user.getAddress());
        }
        userDao.updateUser(existedUser);
    }

    public List<Cart> getCarts() {
        User user = getCurrentUser();
        //сюда надо дописать обновление
        return user.getCart();
    }

    public List<Driver> getFreeDrivers() {
        long local = new Date().getTime();
        long time = 10 * 60 * 10;               // 10 minutes
        List<Driver> drivers = driverDao.getAllDrivers();
        for (Driver driver : drivers) {
            if (driver.getDate() != null && driver.getDate().getTime() - time <= local)
                drivers.remove(driver);
        }
        return drivers;
    }

    public List<Cart> getCartsForDelivery() {
        return cartDao.getCarts("confirm");
    }

    public void addDriver(Driver driver) {
        //надо написать, лучше сделать проверку на пустые входящие данные (name, phone)
    }

    public void addManager(User user) {
        //надо написать, лучше сделать проверку на пустые входящие данные (name, password)
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

    public List getAllDrivers(){
        return driverDao.getAllDrivers();
    }
}
