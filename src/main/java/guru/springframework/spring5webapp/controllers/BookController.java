package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// Controller annotatie om aan te geven dat dit een spring mvc controller is
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Map de functie aan een specifiek endpoint (in dit geval books)
    @RequestMapping("/books")
    public String getBooks(Model model) {

        // Voeg een object toe aan het model om mee terug te geven aan de spring servlet (View)
        // Gebruik de ingebouwde findAll methode van de repository om alle records op te halen
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }

}
