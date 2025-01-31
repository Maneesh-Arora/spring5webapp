package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherJPARepository extends JpaRepository<Publisher,Long> {

}
