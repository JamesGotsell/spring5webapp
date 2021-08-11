package guru.springframework.spring5webapp.bootstrap;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepostory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepostory bookRepostory;

    public BootStrapData(AuthorRepository authorRepository, BookRepostory bookRepostory) {
        this.authorRepository = authorRepository;
        this.bookRepostory = bookRepostory;
    }

    @Override
    public void run(String... args) throws Exception {
        Author james = new Author("james", "gotsell");
        Book ddd = new Book("Domain Driven Design", "123456");

        james.getBooks().add(ddd);
        ddd.getAuthors().add(james);

        authorRepository.save(james);
        bookRepostory.save(ddd);

        Author rod = new Author("Rob", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "1234567");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepostory.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("number of books" + bookRepostory.count());
        System.out.println("number of authors" + authorRepository.count());
    }
}
