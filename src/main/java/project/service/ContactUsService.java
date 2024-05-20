package project.service;

import project.models.ContactForm;

public interface ContactUsService {
    ContactForm sendContactMessage(ContactForm contactForm) throws  Exception;
    ContactForm getContactById(Long id);
    void deleteContactById(Long id);
}