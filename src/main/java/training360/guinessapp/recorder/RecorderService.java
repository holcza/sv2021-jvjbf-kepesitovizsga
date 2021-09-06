package training360.guinessapp.recorder;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private ModelMapper mapper;

    private RecorderRepository repo;

    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(),command.getBirthDate());

        repo.save(recorder);

        return mapper.map(recorder,RecorderDto.class);
    }

    public List<RecorderShortDto> listOfRequestedRecorders() {

        List<Recorder> recorders = repo.findAllRequestedRecorders("e","B");

        Type type = new TypeToken<List<RecorderShortDto>>(){}.getType();
        return mapper.map(recorders,type);
    }
}
