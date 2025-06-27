package bookmanagementcna.domain;

import bookmanagementcna.domain.*;
import bookmanagementcna.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RegistrationRequested extends AbstractEvent {

    private Long id;
    private String email;
    private String name;
    private String introduce;
    private String major;
    private String portfolio;
}
