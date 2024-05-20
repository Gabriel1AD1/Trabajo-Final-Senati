package com.bolsadeideas.springboot.app.controllers;

import com.bolsadeideas.springboot.app.models.dto.ContactForm;
import com.bolsadeideas.springboot.app.models.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute ContactForm contactForm, Model model) {
        // Enviar el correo electrónico
        emailService.sendSimpleMessage(
                contactForm.getEmail(), // Cambia esto a la dirección de correo del destinatario
                contactForm.getSubject(),
                "Nombre: " + contactForm.getName() + "\nEmail: " + contactForm.getEmail() + "\nMensaje: " + contactForm.getMessage()
        );
        return "redirect:/contact?success";
    }
}
