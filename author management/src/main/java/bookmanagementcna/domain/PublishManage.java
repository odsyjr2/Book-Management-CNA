package bookmanagementcna.domain;

import bookmanagementcna.AuthorManagementApplication;
import bookmanagementcna.domain.PublishRequestRegistered;
import bookmanagementcna.domain.RequestApproved;
import bookmanagementcna.domain.SaveCompleted;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PublishManage_table")
@Data
//<<< DDD / Aggregate Root
public class PublishManage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authorName;

    private Long authorId;

    private String bookTitle;

    private String bookContent;

    private Boolean finalSave;

    private String publishStatus;

    @PostPersist
    public void onPostPersist() {
        SaveCompleted saveCompleted = new SaveCompleted(this);
        saveCompleted.publishAfterCommit();

        RequestApproved requestApproved = new RequestApproved(this);
        requestApproved.publishAfterCommit();

        PublishRequestRegistered publishRequestRegistered = new PublishRequestRegistered(
            this
        );
        publishRequestRegistered.publishAfterCommit();
    }

    public static PublishManageRepository repository() {
        PublishManageRepository publishManageRepository = AuthorManagementApplication.applicationContext.getBean(
            PublishManageRepository.class
        );
        return publishManageRepository;
    }

    //<<< Clean Arch / Port Method
    public static void approvePublish(BookApproved bookApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        PublishManage publishManage = new PublishManage();
        repository().save(publishManage);

        RequestApproved requestApproved = new RequestApproved(publishManage);
        requestApproved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookApproved.get???()).ifPresent(publishManage->{
            
            publishManage // do something
            repository().save(publishManage);

            RequestApproved requestApproved = new RequestApproved(publishManage);
            requestApproved.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
