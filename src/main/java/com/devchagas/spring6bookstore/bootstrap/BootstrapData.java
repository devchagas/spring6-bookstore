package com.devchagas.spring6bookstore.bootstrap;

import com.devchagas.spring6bookstore.domain.Author;
import com.devchagas.spring6bookstore.domain.Book;
import com.devchagas.spring6bookstore.domain.Customer;
import com.devchagas.spring6bookstore.domain.Publisher;
import com.devchagas.spring6bookstore.repositories.AuthorRepository;
import com.devchagas.spring6bookstore.repositories.BookRepository;
import com.devchagas.spring6bookstore.repositories.CustomerRepository;
import com.devchagas.spring6bookstore.repositories.PubliserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PubliserRepository publiserRepository;

    private final CustomerRepository customerRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PubliserRepository publiserRepository, CustomerRepository customerRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publiserRepository = publiserRepository;
        this.customerRepository = customerRepository;
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
        ddd.setPrice(19.99);

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("654321");
        noEJB.setPrice(49.99);

        //Publishers
        Publisher abril = new Publisher();
        abril.setPublisherName("Editora Abril");
        abril.setAddress("Rua São Paulo, 380, Vila Lidia");
        abril.setCity("São Paulo");
        abril.setState("SP");
        abril.setZip(14307038);

        Publisher rcBooks = new Publisher();
        rcBooks.setPublisherName("Rio Claro Books");
        rcBooks.setAddress("Avenida 42A, 1040, Vila Alema");
        rcBooks.setCity("Rio Claro");
        rcBooks.setState("SP");
        rcBooks.setZip(13506621);

        //Customers
        Customer gabriel = new Customer();
        gabriel.setCustomerName("Gabriel Chagas");
        gabriel.setAge(23);
        gabriel.setAreaOfInterest("SciFi/Cyberpunk");

        Customer mariana = new Customer();
        mariana.setCustomerName("Mariana Pazianoto");
        mariana.setAge(23);
        mariana.setAreaOfInterest("Drama/Investigation");

        Customer john = new Customer();
        john.setCustomerName("John Thompson");
        john.setAge(45);
        john.setAreaOfInterest("Technology/Software Engineering");

        //Saves
        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);

        Book noEJBSaved = bookRepository.save(noEJB);
        Book dddSaved = bookRepository.save(ddd);

        Publisher abrilSaved = publiserRepository.save(abril);
        Publisher rcBooksSaved = publiserRepository.save(rcBooks);

        Customer gabrielSaved = customerRepository.save(gabriel);
        Customer marianaSaved = customerRepository.save(mariana);
        Customer johnSaved = customerRepository.save(john);

        //Relationships between Author and Book and Books and Publishers
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        dddSaved.setPublisher(abrilSaved);
        noEJBSaved.setPublisher(rcBooksSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        //Relationships between Customers and Books and new saves
        gabrielSaved.getBooksPurchased().add(dddSaved);
        marianaSaved.getBooksPurchased().add(noEJBSaved);

        dddSaved.getCustomersSold().add(gabrielSaved);
        noEJBSaved.getCustomersSold().add(marianaSaved);

        customerRepository.save(gabrielSaved);
        customerRepository.save(marianaSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        //Prints
        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publiserRepository.count());
        System.out.println("Customer Count: " + customerRepository.count());
    }
}
