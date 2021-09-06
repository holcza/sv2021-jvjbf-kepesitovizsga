package training360.guinessapp.worldrecord;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.RecorderNotFoundException;
import training360.guinessapp.WorldRecordNotFoundException;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;
import training360.guinessapp.recorder.Recorder;
import training360.guinessapp.recorder.RecorderRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private ModelMapper mapper;

    private WorldRecordRepository repo;

    private RecorderRepository recorderRepository;

    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {

        Recorder recorder = recorderRepository.findById(command.getRecorderId()).orElseThrow(()->new RecorderNotFoundException());

        WorldRecord worldRecord = new WorldRecord(
                command.getDescription(),
                command.getValue(),
                command.getUnitOfMeasure(),
                command.getDateOfRecord(),
                command.getRecorderId(),
                recorder.getName()
        );

        repo.save(worldRecord);

        return mapper.map(worldRecord,WorldRecordDto.class);
    }

    public WorldRecordDto findRecordById(long id) {

        WorldRecord record = repo.findById(id).orElseThrow(()->new WorldRecordNotFoundException());

        return mapper.map(record, WorldRecordDto.class);
    }

    @Transactional
    public BeatWorldRecordDto updateWorldRecord(BeatWorldRecordCommand command, long id) {
        Recorder recorder = recorderRepository.findById(id).orElseThrow(()->new RecorderNotFoundException());

        WorldRecord record = repo.findById(command.getId()).orElseThrow(()->new WorldRecordNotFoundException());

        record.setRecorderId(id);
        record.setRecorderName(recorder.getName());
        record.setValue(command.getValue());
        record.setDateOfRecord(LocalDate.now());

        BeatWorldRecord beatWorldRecord = new BeatWorldRecord(
                record.getDescription(),
                record.getUnitOfMeasure(),
                record.getRecorderName(),
                record.getValue(),
                recorder.getName(),
                command.getValue(),
                command.getValue()-record.getValue()
        );

        return mapper.map(beatWorldRecord,BeatWorldRecordDto.class);
    }
}
