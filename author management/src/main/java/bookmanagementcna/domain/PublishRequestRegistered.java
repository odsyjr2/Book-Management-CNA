package bookmanagementcna.domain;

import bookmanagementcna.domain.*;
import bookmanagementcna.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PublishRequestRegistered extends AbstractEvent {

    private Long id;
    private Long authorId;
    private String bookTitle;
    private String bookContent;
    private Boolean finalSave;
    private String publishStatus;
    private String authorName;

    public PublishRequestRegistered(PublishManage aggregate) {
        super(aggregate);
    }

    public PublishRequestRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
