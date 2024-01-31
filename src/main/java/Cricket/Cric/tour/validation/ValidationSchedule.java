package Cricket.Cric.tour.validation;

import Cricket.Cric.tour.model.ElevenTeamModel;
import Cricket.Cric.tour.model.ScheduleTeamModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationSchedule {

    public List<String> validateTeam(ScheduleTeamModel scheduleTeamModel) {
        List<String> validationErrors = new ArrayList<>();

        // Validate gameId
        validateField("gameId", scheduleTeamModel.getGameId(), validationErrors);

        // Validate location
        validateField("location", scheduleTeamModel.getLocation(), validationErrors);
        if (!validationErrors.isEmpty()) {
            return validationErrors;  // Stop processing if the first error is found
        }

        // Validate dist
        validateField("dist", scheduleTeamModel.getDist(), validationErrors);
        if (!validationErrors.isEmpty()) {
            return validationErrors;  // Stop processing if the first error is found
        }

        List<ElevenTeamModel> team = scheduleTeamModel.getTeam();
        if (team == null || team.isEmpty()) {
            validationErrors.add("Team data is empty or null.");
        } else {
            for (ElevenTeamModel teamModel : team) {
                // Validate teamId
                validateAndAddError("teamId", teamModel.getTeamId(), validationErrors);
                if (!validationErrors.isEmpty()) {
                    return validationErrors;  // Stop processing if the first error is found
                }

                // Validate teamName
                validateAndAddError("teamName", teamModel.getTeamName(), validationErrors);
                if (!validationErrors.isEmpty()) {
                    return validationErrors;  // Stop processing if the first error is found
                }

                // Validate captainName
                validateAndAddError("captainName", teamModel.getCaptainName(), validationErrors);
                if (!validationErrors.isEmpty()) {
                    return validationErrors;  // Stop processing if the first error is found
                }

                // Validate viceCaptainName
                validateAndAddError("viceCaptainName", teamModel.getViceCaptainName(), validationErrors);
                if (!validationErrors.isEmpty()) {
                    return validationErrors;  // Stop processing if the first error is found
                }

                // Validate teamMembers
                validateArrayAndAddError(teamModel.getTeamMembers(), validationErrors);
                if (!validationErrors.isEmpty()) {
                    return validationErrors;  // Stop processing if the first error is found
                }

                // Validate dist within team
                validateAndAddError("dist", teamModel.getDist(), validationErrors);
                if (!validationErrors.isEmpty()) {
                    return validationErrors;  // Stop processing if the first error is found
                }
            }
        }

        return validationErrors;
    }
    private void validateField(String fieldName, Object fieldValue, List<String> validationErrors) {
        if (fieldValue == null || fieldValue.toString().trim().isEmpty()) {
            validationErrors.add(fieldName + " should not be empty or null.");
        } else if (!isValidField(fieldValue.toString())) {
            validationErrors.add(fieldName + " should not contain special characters.");
        }
    }
    private void validateArray(String[] array, List<String> validationErrors) {
        if (array == null || array.length != 11) {
            validationErrors.add("teamMembers should have exactly 11 elements.");
        } else {
            for (String element : array) {
                validateAndAddError("teamMembers", element, validationErrors);
            }
        }
    }
    private void validateAndAddError(String fieldName, Object fieldValue, List<String> validationErrors) {
        if (fieldValue == null || fieldValue.toString().trim().isEmpty()) {
            validationErrors.add(fieldName + " should not be empty or null.");
        } else if (!isValidField(fieldValue.toString())) {
            validationErrors.add(fieldName + " should not contain special characters.");
        }
    }
    private void validateArrayAndAddError(String[] array, List<String> validationErrors) {
        if (array == null || array.length != 11) {
            validationErrors.add("teamMembers should have exactly 11 elements.");
        } else {
            for (String element : array) {
                validateAndAddError("teamMembers", element, validationErrors);
            }
        }
    }
    private boolean isValidField(String fieldValue) {
        return fieldValue.matches("^[a-zA-Z0-9_]+$");
    }
}
