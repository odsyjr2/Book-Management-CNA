package bookmanagementcna.domain;

import lombok.Data;

//이벤트
@Data
public class BookSummaryCompleted {    
    private Long subscriberId;
    private String bookTitle;
    private String summary;
    
}
