package eu.lengarski.nlpostcode.controllers;


import eu.lengarski.nlpostcode.main.NLPostCodeConstants;
import eu.lengarski.nlpostcode.models.dto.DistanceDTO;
import eu.lengarski.nlpostcode.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static eu.lengarski.nlpostcode.main.NLPostCodeConstants.API_V1;

@RestController
@CrossOrigin
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    @GetMapping(API_V1 + "/distance")
    public DistanceDTO getDistance(@RequestParam String startPostCode, @RequestParam String destinationPostCode) {

        if (null == startPostCode || startPostCode.length() < NLPostCodeConstants.MIN_POST_CODE_LENGTH) {
            throw new RuntimeException("Start post code is required. Can not be empty and length must be at least 4 characters");
        }

        if (null == destinationPostCode || destinationPostCode.length() < NLPostCodeConstants.MIN_POST_CODE_LENGTH) {
            throw new RuntimeException("Destination post code is required. Can not be empty and length must be at least 4 characters");
        }


        return distanceService.getDistanceBetweenPostCodes(startPostCode, destinationPostCode);
    }

}
