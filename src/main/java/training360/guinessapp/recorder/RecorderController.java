package training360.guinessapp.recorder;

import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recorders")
public class RecorderController {

    private RecorderService service;

    public RecorderController(RecorderService service) {
        this.service = service;
    }

    @PostMapping
    public RecorderDto createRecorder(@Valid @RequestBody RecorderCreateCommand command){
        return service.createRecorder(command);
    }

    @GetMapping
    public List<RecorderShortDto> listOfRequestedRecorders (){
        return service.listOfRequestedRecorders();
    }
}
