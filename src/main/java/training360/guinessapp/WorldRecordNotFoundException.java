package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class WorldRecordNotFoundException extends AbstractThrowableProblem {

    public WorldRecordNotFoundException() {
        super(
                URI.create("world_record/not-found"),
                "World record not found",
                Status.NOT_FOUND,
                String.format("World record not found")
        );
    }
}
