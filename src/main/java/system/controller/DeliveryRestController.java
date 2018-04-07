package system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}
