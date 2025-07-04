package bookmanagementcna.domain;

import lombok.Data;

//커맨드
@Data
public class BookSummaryRequested {
    private Long subscriberId;
    private String bookTitle;
    private String bookContent;
    
}
