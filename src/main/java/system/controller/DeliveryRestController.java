package system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.model.Food;
import system.model.User;
import system.service.DeliveryService;

import java.util.List;

@RestController
public class DeliveryRestController {

    private DeliveryService deliveryService;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @RequestMapping(value = "/getUsername", method = RequestMethod.GET)
    public String getUsername(){
        return deliveryService.getUserName();
    }

    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public User getCurrentUser(){
        return deliveryService.getCurrentUser();
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers(){
        return deliveryService.getAllUsers();
    }

    @RequestMapping(value = "/getFoods", method = RequestMethod.GET)
    public List<User> getFoods(){
        return deliveryService.getAllFoods();
    }

    @RequestMapping(value = "/getTypes", method = RequestMethod.GET)
    public List<User> getTypes(){
        return deliveryService.getAllTypes();
    }

    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public boolean shopRegistration(@RequestBody User user){
        return deliveryService.addUser(user);
    }

    @RequestMapping(value = "/addFoodToCart", method = RequestMethod.POST)
    public void addFoodToCart(@RequestBody Food food){
        deliveryService.addFoodToCart(food.getId());
    }

    @RequestMapping(value = "/deleteFromCart", method = RequestMethod.POST)
    public void deleteFromCart(@RequestBody Food food){
        deliveryService.deleteFromCart(food.getId());
    }

    @RequestMapping(value = "/confirmCart", method = RequestMethod.POST)
    public void confirmCart(){
        deliveryService.confirmCart();
    }
}
