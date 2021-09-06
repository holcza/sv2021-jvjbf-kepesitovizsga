package training360.guinessapp.worldrecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecord {

    private String description;

    private String unitOfMeasure;

    private String oldRecorderName;

    private double oldRecordValue;

    private String newRecorderName;

    private double newRecordValue;

    private double recordDifference;
}
