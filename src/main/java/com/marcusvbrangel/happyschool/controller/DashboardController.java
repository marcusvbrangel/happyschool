package com.marcusvbrangel.happyschool.controller;

import com.marcusvbrangel.happyschool.config.HappySchoolProperties;
import com.marcusvbrangel.happyschool.model.Person;
import com.marcusvbrangel.happyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    private final PersonRepository personRepository;
    private final Environment environment;
    private final HappySchoolProperties happySchoolProperties;

    @Value("${happyschool.pageSize}")
    private int defaultPageSize;

    @Value("${happyschool.contact.successMsg}")
    private String message;

    public DashboardController(PersonRepository personRepository, Environment environment, HappySchoolProperties happySchoolProperties) {
        this.personRepository = personRepository;
        this.environment = environment;
        this.happySchoolProperties = happySchoolProperties;
    }

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession httpSession) {
        logMessage();
        Person person = personRepository.findByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        httpSession.setAttribute("loggedInPerson", person);
        return "dashboard.html";
    }

    private void logMessage() {
        System.out.println("----------------------------------------------");
        System.out.println("defaultPageSize => " + defaultPageSize);
        System.out.println("message => " + message);

        System.out.println("bash variable => " + environment.getProperty("NAME_ANIMAL")); // NOTE: wont work!!!

        System.out.println("pageSize => " + happySchoolProperties.getPageSize());
        System.out.println("contact pageSize => " + happySchoolProperties.getContact().get("pageSize"));
        System.out.println("branches => " + happySchoolProperties.getBranches());
        System.out.println("branches get(2) => " + happySchoolProperties.getBranches().get(2));

        System.out.println("----------------------------------------------");
    }

}
