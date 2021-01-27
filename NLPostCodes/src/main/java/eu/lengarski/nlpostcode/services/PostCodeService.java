package eu.lengarski.nlpostcode.services;

import eu.lengarski.nlpostcode.models.dto.PostCodeDto;
import eu.lengarski.nlpostcode.models.entity.PostCodeEntity;
import eu.lengarski.nlpostcode.repositories.PostCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostCodeService {

    @Autowired
    private PostCodeRepository postCodeRepository;

    public Optional<PostCodeDto> updatePartOfObject(String postcode, PostCodeDto patch) {
        Optional<PostCodeEntity> byPostCode = postCodeRepository.findByPostCode(postcode);
        PostCodeDto response = null;

        if (byPostCode.isPresent()) {
            PostCodeEntity entity = byPostCode.get();

            if (patch.getLatitude() != null) {
                entity.setLatitude(patch.getLatitude());
            }

            if (patch.getLongitude() != null) {
                entity.setLongitude(patch.getLongitude());
            }

            PostCodeEntity save = postCodeRepository.save(entity);
            response = new PostCodeDto(save);
        }

        return Optional.of(response);
    }

    public Optional<PostCodeDto> updateObject(String postcode, PostCodeDto put) {
        Optional<PostCodeEntity> byPostCode = postCodeRepository.findByPostCode(postcode);
        PostCodeDto response = null;

        if (byPostCode.isPresent()) {
            PostCodeEntity entity = byPostCode.get();
            entity.setLatitude(put.getLatitude());
            entity.setLongitude(put.getLongitude());
            PostCodeEntity save = postCodeRepository.save(entity);
            response = new PostCodeDto(save);
        }

        return Optional.of(response);

    }
}
