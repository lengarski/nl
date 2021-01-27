package eu.lengarski.nlpostcode.controllers;

import eu.lengarski.nlpostcode.models.dto.PostCodeDto;
import eu.lengarski.nlpostcode.models.dto.PostCodeResponseDto;
import eu.lengarski.nlpostcode.services.PostCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static eu.lengarski.nlpostcode.main.NLPostCodeConstants.API_V1;

@RestController
public class PostCodeController {

    @Autowired
    private PostCodeService postCodeService;

    @PatchMapping(API_V1 + "/postcode/{postcode}")
    public PostCodeResponseDto updatePartOfObject(@PathVariable String postcode, @RequestBody PostCodeDto patch) {

        Optional<PostCodeDto> updatedObject = postCodeService.updatePartOfObject(postcode, patch);
        PostCodeResponseDto postCodeResponse = new PostCodeResponseDto();
        if (updatedObject.isPresent()) {
            postCodeResponse.setPostCode(updatedObject.get());
            postCodeResponse.setStatusMsg("Coordinates are successfully updated");
        } else {
            postCodeResponse.setStatusMsg("An error occurred");
        }
        return postCodeResponse;
    }


    @PutMapping(API_V1 + "/postcode/{postcode}")
    public PostCodeResponseDto uodateEntireObject(@PathVariable String postcode, @RequestBody PostCodeDto put) {

        Optional<PostCodeDto> updatedObject = postCodeService.updateObject(postcode, put);
        PostCodeResponseDto postCodeResponse = new PostCodeResponseDto();
        if (updatedObject.isPresent()) {
            postCodeResponse.setPostCode(updatedObject.get());
            postCodeResponse.setStatusMsg("Coordinates are successfully updated");
        } else {
            postCodeResponse.setStatusMsg("An error occurred");
        }
        return postCodeResponse;
    }
}
