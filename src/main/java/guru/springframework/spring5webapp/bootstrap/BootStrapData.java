package guru.springframework.spring5webapp.bootstrap;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepostory;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepostory bookRepostory;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepostory bookRepostory, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepostory = bookRepostory;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author james = new Author("james", "gotsell");
        Book ddd = new Book("Domain Driven Design", "123456");
        Publisher pub = new Publisher("asylum road", "london", "london", "se15 2ju", "james books");
        pub.setAddress_1_line("cool strint");
        pub.setName("boom town");

        publisherRepository.save(pub);
        james.getBooks().add(ddd);
        ddd.getAuthors().add(james);

        authorRepository.save(james);
        bookRepostory.save(ddd);

        Author rod = new Author("Rob", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "1234567");
        //String address_1_line, String city, String state, String zip

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);

        noEJB.setPublisher(pub);

        pub.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepostory.save(noEJB);

        publisherRepository.save(pub);






        System.out.println("Started in Bootstrap");
        System.out.println("number of books" + bookRepostory.count());
        System.out.println("number of authors" + authorRepository.count());
        System.out.println("number of publishers" + publisherRepository.count());
        System.out.println("number of  books to publishers" + pub.getBooks().size());
    }
}
