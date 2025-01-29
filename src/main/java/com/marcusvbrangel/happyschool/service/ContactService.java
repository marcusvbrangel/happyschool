package com.marcusvbrangel.happyschool.service;

import com.marcusvbrangel.happyschool.constants.HappySchoolConstants;
import com.marcusvbrangel.happyschool.model.Contact;
import com.marcusvbrangel.happyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(HappySchoolConstants.OPEN);
        contact.setCreatedBy(HappySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        var contactSaved = contactRepository.save(contact);
        if(null != contactSaved && contactSaved.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(HappySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;

        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(HappySchoolConstants.CLOSE);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });

        var contactUpdated = contactRepository.save(contact.get());

        if(null != contactUpdated && contactUpdated.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
