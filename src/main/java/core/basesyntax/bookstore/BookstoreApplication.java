package core.basesyntax.bookstore;

import core.basesyntax.bookstore.model.Book;
import core.basesyntax.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = Book.builder()
                    .author("Stephen King")
                    .title("Shining")
                    .description("spooky book")
                    .isbn("9781444720723")
                    .price(BigDecimal.valueOf(645))
                    .coverImage("https://content2.rozetka.com.ua/goods"
                            + "/images/big/230033464.jpg")
                    .build();
            System.out.println(bookService.save(book));
            System.out.println(bookService.findAll());
        };
    }
}
