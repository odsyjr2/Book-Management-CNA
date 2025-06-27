package bookmanagementcna.domain;

import bookmanagementcna.domain.*;
import bookmanagementcna.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class EBookSummary extends AbstractEvent {

    private Long id;
    private Long publicationId;
    private String summaryText;
    private Date generatedAt;
    private String status;

    public EBookSummary(Service aggregate) {
        super(aggregate);
    }

    public EBookSummary() {
        super();
    }
}
//>>> DDD / Domain Event
