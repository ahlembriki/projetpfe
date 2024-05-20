package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.models.ContactForm;

public interface ContactRepository extends JpaRepository<ContactForm,Long> {
}
