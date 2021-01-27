package eu.lengarski.nlpostcode.repositories;

import eu.lengarski.nlpostcode.models.entity.PostCodeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostCodeRepository extends CrudRepository<PostCodeEntity, Long> {

    Optional<PostCodeEntity> findByPostCode(String postCode);

}
