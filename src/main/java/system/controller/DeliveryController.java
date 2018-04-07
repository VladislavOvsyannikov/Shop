package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import system.model.User;
import system.service.DeliveryService;

import java.util.List;

@Controller
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String shopRegistration() {
        return "/index.html";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "/home.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login.html";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "/registration.html";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "/error.html";
    }

}