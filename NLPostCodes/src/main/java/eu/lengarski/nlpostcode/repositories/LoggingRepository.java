package eu.lengarski.nlpostcode.repositories;

import eu.lengarski.nlpostcode.models.entity.LoggingEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoggingRepository extends CrudRepository<LoggingEntity, Long> {

}
