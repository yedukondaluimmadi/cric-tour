package Cricket.Cric.tour.service;


import Cricket.Cric.tour.model.UmpireDetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class UmpireService {

    private final Map<String, UmpireDetails> umpires = new HashMap<>();
    public String registerUmpire(UmpireDetails umpireDetails) {

        String umpireId = generateUmpireId();
        umpireDetails.setId(umpireId);
        umpires.put(umpireId, umpireDetails);
        log.info("Request Body: " + umpireDetails);
        log.info(umpireDetails.getName()+" , you have successfully Registered as an umpire with ID: " + umpireId);
        return umpireDetails.getName()+" , You have successfully Registered as an umpire  with ID: " + umpireId ;
}

    public UmpireDetails getUmpireDetailsById(String id) {
        return umpires.get(id);
    }
    private String generateUmpireId() {

        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        return "U" + uuid;
    }
}