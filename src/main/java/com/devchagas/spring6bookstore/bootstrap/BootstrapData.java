package com.devchagas.spring6bookstore.bootstrap;

import com.devchagas.spring6bookstore.domain.Author;
import com.devchagas.spring6bookstore.domain.Book;
import com.devchagas.spring6bookstore.domain.Publisher;
import com.devchagas.spring6bookstore.repositories.AuthorRepository;
import com.devchagas.spring6bookstore.repositories.BookRepository;
import com.devchagas.spring6bookstore.repositories.PubliserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PubliserRepository publiserRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PubliserRepository publiserRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publiserRepository = publiserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Authors
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        //Books
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("654321");

        //Publishers
        Publisher abril = new Publisher();
        abril.setPublisherName("Editora Abril");
        abril.setAddress("Rua São Paulo, 380, Vila Lidia");
        abril.setCity("São Paulo");
        abril.setState("SP");
        abril.setZip(14307038);

        Publisher rcBooks = new Publisher();
        abril.setPublisherName("Rio Claro Books");
        abril.setAddress("Avenida 42A, 1040, Vila Alema");
        abril.setCity("Rio Claro");
        abril.setState("SP");
        abril.setZip(13506621);

        //Saves
        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);

        Book noEJBSaved = bookRepository.save(noEJB);
        Book dddSaved = bookRepository.save(ddd);

        Publisher abrilSaved = publiserRepository.save(abril);
        Publisher rcBooksSaved = publiserRepository.save(rcBooks);

        //Relationships and new saves
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.setPublisher(abrilSaved);
        noEJBSaved.setPublisher(rcBooksSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        //Prints
        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publiserRepository.count());
    }
}
