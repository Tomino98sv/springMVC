package school.learning.spring_Udemy_Starting.repozitories;

import org.springframework.data.repository.CrudRepository;
import school.learning.spring_Udemy_Starting.model.Author;

public interface AuthorRepozitory extends CrudRepository<Author, Long> {
}
