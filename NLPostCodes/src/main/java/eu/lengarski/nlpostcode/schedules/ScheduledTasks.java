package eu.lengarski.nlpostcode.schedules;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import eu.lengarski.nlpostcode.models.entity.PostCodeEntity;
import eu.lengarski.nlpostcode.repositories.PostCodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private PostCodeRepository postCodeRepository;

    @Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
    public void reportCurrentTime() {
        logger.info("task start");
        long startTime = System.currentTimeMillis();
        try {
            InputStream passwordInputStream =
                    Thread.currentThread().getContextClassLoader().getResourceAsStream("postcodes-coordinates-NL.csv");

            Reader reader = new InputStreamReader(passwordInputStream);

//                    Files.newBufferedReader(Paths.get(
//                    ClassLoader.getSystemResource("postcodes-coordinates-NL.csv").toURI()));

            CSVReader csvReader = new CSVReader(reader);

            for (String[] line : csvReader.readAll()) {

                try {
                    Long id = Long.parseLong(line[0]);

                    Optional<PostCodeEntity> postCodeById = postCodeRepository.findById(id);

                    if (!postCodeById.isPresent()) {
                        String postCode = line[1];
                        Double latitude = Double.parseDouble(line[2]);
                        Double longitude = Double.parseDouble(line[3]);

                        PostCodeEntity entity = new PostCodeEntity(id, postCode, latitude, longitude);
                        postCodeRepository.save(entity);
                    }
                } catch (NumberFormatException e) {
                    logger.error(" NumberFormatException ");
                }
            }
            reader.close();
            csvReader.close();
        } catch (IOException e) {
            logger.error(" IOException ");
        } catch (CsvException e) {
            logger.error(" CsvException ");
        }
//        catch (URISyntaxException e) {
//            logger.error(" URISyntaxException ");
//        }
        double timeRunning = (System.currentTimeMillis() - startTime) / 1000.;
        logger.info("task finished in " + timeRunning + " seconds");
    }

}