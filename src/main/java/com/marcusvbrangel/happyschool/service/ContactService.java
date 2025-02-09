package com.marcusvbrangel.happyschool.service;

import com.marcusvbrangel.happyschool.constants.HappySchoolConstants;
import com.marcusvbrangel.happyschool.model.Contact;
import com.marcusvbrangel.happyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
        var contactSaved = contactRepository.save(contact);
        if(null != contactSaved && contactSaved.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
            sortDir.equals("asc") ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
            HappySchoolConstants.OPEN, pageable);
        return msgPage;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(HappySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;

        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(HappySchoolConstants.CLOSE);
        });

        var contactUpdated = contactRepository.save(contact.get());

        if(null != contactUpdated && contactUpdated.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
