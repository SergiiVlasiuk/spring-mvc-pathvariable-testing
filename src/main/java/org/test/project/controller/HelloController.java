package org.test.project.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/greet")
public class HelloController {

    @RequestMapping(value="/welcome/{countryName}/{userName}")
    public ModelAndView test(@PathVariable("userName") String userName, @PathVariable("countryName") String countryName) throws IOException {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("myMessage", "Welcome To "+countryName+" , Spring MVC - "+userName);
        return mav;
    }

    @RequestMapping(value="/hi/{cn}/{un}")
    public ModelAndView hi(@PathVariable Map<String, String> pathVars){

        String countryName = pathVars.get("cn");
        String userName = pathVars.get("un");

        ModelAndView mav = new ModelAndView("home");
        mav.addObject("myMessage", "Hi "+userName+" in "+ countryName);
        return mav;
    }
}
