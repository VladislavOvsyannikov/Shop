package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import system.model.User;
import system.service.ShopService;

import java.util.List;

@Controller
public class ShopController {

    private ShopService shopService;

    @Autowired
    public void setShopService(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String shopRegistration() {
        return "/index.html";
    }

    @RequestMapping(value = "/getUsername", method = RequestMethod.GET)
    public @ResponseBody String getUsername(){
        return shopService.getUserName();
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUsers(){
        return shopService.getAllUsers();
    }
}
