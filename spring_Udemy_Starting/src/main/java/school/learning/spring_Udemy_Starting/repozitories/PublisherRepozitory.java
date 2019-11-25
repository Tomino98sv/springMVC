package school.learning.spring_Udemy_Starting.repozitories;

import org.springframework.data.repository.CrudRepository;
import school.learning.spring_Udemy_Starting.model.Publisher;

public interface PublisherRepozitory extends CrudRepository<Publisher, Long> {
}
