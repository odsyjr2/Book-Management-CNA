package bookmanagementcna.domain;

import bookmanagementcna.domain.*;
import bookmanagementcna.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RegistrationRequested extends AbstractEvent {

    private Long id;
    private String email;
    private String name;
    private String introduce;
    private String major;
    private String portfolio;

    public RegistrationRequested(Author aggregate) {
        super(aggregate);
    }

    public RegistrationRequested() {
        super();
    }
}
//>>> DDD / Domain Event