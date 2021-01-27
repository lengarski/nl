package eu.lengarski.nlpostcode.services;

import eu.lengarski.nlpostcode.models.dto.DistanceDTO;
import eu.lengarski.nlpostcode.models.dto.PostCodeDto;
import eu.lengarski.nlpostcode.models.entity.LoggingEntity;
import eu.lengarski.nlpostcode.models.entity.PostCodeEntity;
import eu.lengarski.nlpostcode.repositories.LoggingRepository;
import eu.lengarski.nlpostcode.repositories.PostCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
public class DistanceService {

    private static DecimalFormat df = new DecimalFormat("####0.00");

    @Autowired
    private PostCodeRepository postCodeRepository;

    @Autowired
    private LoggingRepository loggingRepository;

    private final static double EARTH_RADIUS = 6371; // radius in kilometers

    public DistanceDTO getDistanceBetweenPostCodes(String startPostCode, String endPostCode) {
        Optional<PostCodeEntity> startDestination = postCodeRepository.findByPostCode(startPostCode);

        LoggingEntity loggingEntity = new LoggingEntity();
        loggingEntity.setStartPostcode(startPostCode);
        loggingEntity.setEndPostCode(endPostCode);
        loggingEntity.setTime(System.currentTimeMillis());

        if (!startDestination.isPresent()) {
            loggingEntity.setStatus("Get Destination failed. There are no postcode with id " + startPostCode);
            loggingRepository.save(loggingEntity);
            throw new RuntimeException("Post Code not found " + startPostCode);
        }

        Optional<PostCodeEntity> endDestination = postCodeRepository.findByPostCode(endPostCode);

        if (!endDestination.isPresent()) {
            loggingEntity.setStatus("Get Destination failed. There are no postcode with id " + endPostCode);
            loggingRepository.save(loggingEntity);
            throw new RuntimeException("Post Code not found " + endPostCode);
        }

        DistanceDTO distance = new DistanceDTO();
        distance.setStartLocation(new PostCodeDto(startDestination.get()));
        distance.setEndLocation(new PostCodeDto(endDestination.get()));

        Double distanceKm = calculateDistance(startDestination.get(), endDestination.get());
        distance.setDistance(distanceKm);

        loggingEntity.setStatus("Succesfull get distance ");
        loggingRepository.save(loggingEntity);

        return distance;
    }

    private Double calculateDistance(PostCodeEntity entity, PostCodeEntity entity1) {
        Double distance = calculateDistance(entity.getLatitude(), entity.getLongitude(), entity1.getLatitude(), entity1.getLongitude());
        return Double.parseDouble(df.format(distance));
    }


    private double calculateDistance(double latitude, double longitude,
                                     double latitude2, double longitude2) {
        // Using Haversine formula. See Wikipedia.
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);

        double a = haversine(lat1Radians, lat2Radians)
                + Math.cos(lat1Radians) * Math.cos(lat2Radians) *
                haversine(lon1Radians, lon2Radians);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (EARTH_RADIUS * c);
    }

    private double haversine(double degree1, double degree2) {
        return square(Math.sin((degree1 - degree2) / 2.0));
    }

    private double square(double x) {
        return x * x;
    }


}
