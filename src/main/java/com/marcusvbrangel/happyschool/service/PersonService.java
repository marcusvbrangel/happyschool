package com.marcusvbrangel.happyschool.service;

import com.marcusvbrangel.happyschool.constants.HappySchoolConstants;
import com.marcusvbrangel.happyschool.model.Person;
import com.marcusvbrangel.happyschool.model.Roles;
import com.marcusvbrangel.happyschool.repository.PersonRepository;
import com.marcusvbrangel.happyschool.repository.RolesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonService(PersonRepository personRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createNewPerson(final Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.findByRoleName(HappySchoolConstants.STUDENT_HOLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        var personCreated = personRepository.save(person);
        if (null != personCreated && personCreated.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

}
