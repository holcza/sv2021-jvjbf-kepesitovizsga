package training360.guinessapp.worldrecord;

import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/worldrecords")
public class WorldRecordController {

    private WorldRecordService service;

    public WorldRecordController(WorldRecordService service) {
        this.service = service;
    }

    @PostMapping
    public WorldRecordDto createWorldRecord(@Valid @RequestBody WorldRecordCreateCommand command){
        return service.createWorldRecord(command);
    }

    @PutMapping("/{id}/beatrecords")
    public BeatWorldRecordDto updateWorldRecord(@Valid @RequestBody BeatWorldRecordCommand command, @PathVariable("id") long id){
        return service.updateWorldRecord(command,id);
    }
}
