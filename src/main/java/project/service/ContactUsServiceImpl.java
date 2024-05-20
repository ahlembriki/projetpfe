package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import project.models.ContactForm;
import project.repository.ContactRepository;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactForm sendContactMessage(ContactForm contactForm)throws Exception {
        return contactRepository.save(contactForm);
    }

    @Override
    public ContactForm getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }
}
