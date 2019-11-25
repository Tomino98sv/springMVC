package school.learning.spring_Udemy_Starting.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import school.learning.spring_Udemy_Starting.model.Author;
import school.learning.spring_Udemy_Starting.model.Book;
import school.learning.spring_Udemy_Starting.model.Publisher;
import school.learning.spring_Udemy_Starting.repozitories.AuthorRepozitory;
import school.learning.spring_Udemy_Starting.repozitories.BookRepozitory;
import school.learning.spring_Udemy_Starting.repozitories.PublisherRepozitory;


//for initializing database with testing data
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepozitory authorRepozitory;
    private BookRepozitory bookRepozitory;
    private PublisherRepozitory publisherRepozitory;

    public DevBootstrap(AuthorRepozitory authorRepozitory, BookRepozitory bookRepozitory, PublisherRepozitory publisherRepozitory) {
        this.authorRepozitory = authorRepozitory;
        this.bookRepozitory = bookRepozitory;
        this.publisherRepozitory = publisherRepozitory;
    }

    @Override //Came from ApplicationListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
        //ked sa zapne program tak sa to vola
    }

    private void initData() {

        Publisher publisher = new Publisher("FOX","1th Yellow Green Terase");

        publisherRepozitory.save(publisher);

        Author eric = new Author("Eric", "Wolfenstein");
        Book bookfromEric = new Book("Spring cloud","1234",publisher);
        eric.getBooks().add(bookfromEric);
        bookfromEric.getAuthors().add(eric);

        authorRepozitory.save(eric);
        bookRepozitory.save(bookfromEric);

        Author boris = new Author("Boris", "Galinsky");
        Book bookfromBoris = new Book("Spring cloud, mvc testing data","23444",publisher);
        boris.getBooks().add(bookfromBoris);
        bookfromBoris.getAuthors().add(boris);

        authorRepozitory.save(boris);
        bookRepozitory.save(bookfromBoris);

    }
}
