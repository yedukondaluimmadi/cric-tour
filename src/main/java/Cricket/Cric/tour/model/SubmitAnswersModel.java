package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitAnswersModel {
    private List<QuestionModel> questions;
    private int candidateId;
    private String candidateName;
}
