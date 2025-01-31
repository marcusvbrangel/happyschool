package com.marcusvbrangel.happyschool.controller;

import com.marcusvbrangel.happyschool.model.Person;
import com.marcusvbrangel.happyschool.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("public")
public class PublicController {

    private final PersonService personService;

    public PublicController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("person", new Person());
        return "register.html";
    }

    @RequestMapping(value = "/createUser", method = { RequestMethod.POST })
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "register.html";
        }
        boolean isSaved = personService.createNewPerson(person);
        if (isSaved) {
            return "redirect:/login?register=true";
        } else {
            return "register.html";
        }

    }

}
