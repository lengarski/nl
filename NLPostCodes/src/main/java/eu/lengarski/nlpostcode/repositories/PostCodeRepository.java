package eu.lengarski.nlpostcode.repositories;

import eu.lengarski.nlpostcode.models.entity.PostCodeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostCodeRepository extends PagingAndSortingRepository<PostCodeEntity, Long> {

    Optional<PostCodeEntity> findByPostCode(String postCode);

    @Query(value = "select  p.post_code from post_code p order by p.post_code  ", nativeQuery = true)
    List<String> findAllPostecodes();

//    @Query(value = "select  p.post_code from post_code p where p.post_code like %:postcode% order by p.post_code", nativeQuery = true)
    @Query(value = "select  p.post_code from post_code p where p.post_code like :postcode%", nativeQuery = true)
    List<String> findAllPostcodesByPostCode(@Param("postcode") String postCode, Pageable pageable);

}
