package system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeliveryController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String shopRegistration() {
        return "/index.html";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contacts() {
        return "/contacts.html";
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

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart() {
        return "/cart.html";
    }

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public String information() {
        return "/information.html";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history() {
        return "/history.html";
    }

    @RequestMapping(value = "/man", method = RequestMethod.GET)
    public String manager() {
        return "/manager1.html";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "/admin.html";
    }
}
