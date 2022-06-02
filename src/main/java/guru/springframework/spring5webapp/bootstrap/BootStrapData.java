package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorJPARepository;
import guru.springframework.spring5webapp.repositories.BookJPARepository;
import guru.springframework.spring5webapp.repositories.PublisherJPARepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorJPARepository authorRepository;
    private final BookJPARepository bookRepository;
    private final PublisherJPARepository publisherRepository;

    public BootStrapData(AuthorJPARepository authorRepository, BookJPARepository bookRepository, PublisherJPARepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("Random", "Gurgaon","Gurgaon","Haryana","122122");
        publisherRepository.save(publisher);
        System.out.println("Saved Publisher" + publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        publisher.getBooks().add(book);
        book.setPublisher(publisher);


        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);
        System.out.println("Saved Publisher again" + publisherRepository.count());

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "456456");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);
        System.out.println("Saved Publisher again. Publisher Number of Books " + publisher.getBooks().size());


        System.out.println("Started in Bootstrap.");
        System.out.println("Number of Books:" + bookRepository.count());


    }
}
