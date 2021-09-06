package training360.guinessapp.dto;

import org.springframework.beans.factory.annotation.Autowired;
import training360.guinessapp.worldrecord.WorldRecordService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorldRecordValidator implements ConstraintValidator<WorldRecordValidation,BeatWorldRecordCommand> {

    @Autowired
    private WorldRecordService service;

    @Override
    public boolean isValid(BeatWorldRecordCommand command, ConstraintValidatorContext constraintValidatorContext) {

        WorldRecordDto worldRecord = service.findRecordById(command.getId());
        return command.getValue()>worldRecord.getValue();
    }
}
