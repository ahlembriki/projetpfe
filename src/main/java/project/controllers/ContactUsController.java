package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.models.ContactForm;
import project.service.ContactUsService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/contact-us")
    public List<ContactForm> displayContactForm() {
      ContactForm contzct=contactUsService.getContactById(1L);
        return (List<ContactForm>) ResponseEntity.ok(contzct).getBody();
    }

    @PostMapping("/sendmessage")
    public ContactForm submitContactForm(@RequestBody ContactForm contactForm) throws Exception {

       return  contactUsService.sendContactMessage(contactForm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactForm> getContactById(@PathVariable("id") Long id) {
        ContactForm contactForm = contactUsService.getContactById(id);
        if (contactForm == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable("id") Long id) {
        ContactForm contactForm = contactUsService.getContactById(id);
        if (contactForm == null) {
            return ResponseEntity.notFound().build();
        }
        contactUsService.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }
}
