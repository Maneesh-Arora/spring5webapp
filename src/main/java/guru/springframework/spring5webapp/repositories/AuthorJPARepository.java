package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorJPARepository extends JpaRepository<Author,Long> {
}
