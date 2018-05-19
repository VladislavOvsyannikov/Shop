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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DeliveryService {

    private UserDao userDao;

    private FoodDao foodDao;

    private TypeDao typeDao;

    private CartDao cartDao;

    private DriverDao driverDao;

    private long time = 10 * 60 * 10;   // 10 minutes

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
        int[] array = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
        int driverId = array[0];
        Driver driver = driverDao.getDriver(driverId);
        driver.setDate(new Date());
        driverDao.update(driver);
        for (int i=1; i<array.length; i++){
            Cart cart = cartDao.getCart(array[i]);
            cart.setDriver(driver);
            cart.setStatus("in delivery");
            cartDao.update(cart);
        }
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

    public void deleteFromUserCart(String data) {
        int cartId = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray()[0];
        int foodId = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray()[1];
        Cart cart = cartDao.getCart(cartId);
        List<Food> foods = cart.getFoods();
        if (foods.size() != 1) {
            foods.remove(getFood(foodId));
            cartDao.update(cart);
        } else {
            foods.clear();
            cartDao.deleteCart(cart);
        }
    }

    public void deleteUser(int id) {
        User user = userDao.getUser(id);
        userDao.deleteUser(user);
    }

    public void deleteDriver(int id) {
        Driver driver = driverDao.getDriver(id);
        long local = new Date().getTime();
        if (driver.getDate()==null || driver.getDate().getTime() + time <= local){
            driverDao.deleteDriver(driver);
        }
        // ошибка, если этот водитель есть в driver_id в cart
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
        List<Cart> carts = user.getCart();
        for (Cart cart:carts){
            if (cart.getStatus().equals("in delivery")){
                Driver driver = cart.getDriver();
                long local = new Date().getTime();
                if (driver.getDate().getTime() + time <= local){
                    cart.setStatus("delivered");
                    cartDao.updateCart(cart);
                }
            }
        }
        return user.getCart();
    }

    public List<Driver> getFreeDrivers() {
        long local = new Date().getTime();
        List<Driver> drivers = driverDao.getAllDrivers();
        for (Driver driver : drivers) {
            if (driver.getDate() != null && driver.getDate().getTime() + time > local)
                drivers.remove(driver);
        }
        return drivers;
    }

    public List<Cart> getCartsForDelivery() {
        return cartDao.getCarts("confirm");
    }

    public void addDriver(Driver driver) {
        if (driver.getName()!=null && driver.getPhone()!=null){
            driver.setFree(true);
            driverDao.saveDriver(driver);
        }
    }

    public void addManager(User user) {
        if (user.getName()!=null && user.getPassword()!=null){
            user.setRole("ROLE_MANAGER");
            userDao.saveUser(user);
        }
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

    public List getAllCarts(){
        return cartDao.getAllCarts();
    }
}
