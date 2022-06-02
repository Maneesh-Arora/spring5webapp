package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJPARepository extends JpaRepository<Book,Long> {
}
