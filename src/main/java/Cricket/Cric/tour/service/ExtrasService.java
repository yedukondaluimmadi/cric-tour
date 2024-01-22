package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.ExtraModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExtrasService {
    public ResponseEntity<String> recordExtras(ExtraModel extraModel) {
        String message = String.format("Extras recorded successfully. Total: %d, Wide: %d, No Ball: %d.",
                extraModel.getTotal(), extraModel.getWide(), extraModel.getNoBall());
        return ResponseEntity.ok(message);
    }

}
