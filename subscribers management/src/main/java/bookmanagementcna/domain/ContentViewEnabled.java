package bookmanagementcna.domain;

import bookmanagementcna.domain.*;
import bookmanagementcna.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ContentViewEnabled extends AbstractEvent {

    private Long id;
    private String email;
    private String name;
    private Boolean joinStatus;

    public ContentViewEnabled(Subscriber aggregate) {
        super(aggregate);
    }

    public ContentViewEnabled() {
        super();
    }
}
//>>> DDD / Domain Event
