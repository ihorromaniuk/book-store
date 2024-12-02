package core.basesyntax.bookstore.repository;

import core.basesyntax.bookstore.model.Book;
import java.util.List;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    <S extends Book> @NonNull S save(@NonNull S entity);

    @Override
    @NonNull
    List<Book> findAll();
}
