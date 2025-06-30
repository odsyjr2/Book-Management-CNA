package bookmanagementcna.domain;

import bookmanagementcna.AdminApplication;
import bookmanagementcna.domain.AuthorApproved;
import bookmanagementcna.domain.BookApproved;
import bookmanagementcna.domain.ReportResolved;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Admin_table")
@Data
//<<< DDD / Aggregate Root
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long requestId;

    private String requestType; // AUTHOR, BOOK, REPORT

    private String targetId;

    private String requestedAt;

    private String status;      // APPROVED, REJECTED

    private Long adminId;

    private Date approvedAt;

    private String message;

    @PostPersist
    public void onPostPersist() {
        ReportResolved reportResolved = new ReportResolved(this);
        reportResolved.publishAfterCommit();

        BookApproved bookApproved = new BookApproved(this);
        bookApproved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        AuthorApproved authorApproved = new AuthorApproved(this);
        authorApproved.publishAfterCommit();
    }

    public static AdminRepository repository() {
        AdminRepository adminRepository = AdminApplication.applicationContext.getBean(
            AdminRepository.class
        );
        return adminRepository;
    }

    //<<< Clean Arch / Port Method
    public static void requestRegister(
        RegistrationRequested registrationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Admin admin = new Admin();
        repository().save(admin);

        */

        /** Example 2:  finding and process
        

        repository().findById(registrationRequested.get???()).ifPresent(admin->{
            
            admin // do something
            repository().save(admin);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void requestRegister(
        PublishRequestRegistered publishRequestRegistered
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Admin admin = new Admin();
        repository().save(admin);

        */

        /** Example 2:  finding and process
        

        repository().findById(publishRequestRegistered.get???()).ifPresent(admin->{
            
            admin // do something
            repository().save(admin);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void approveLogin(Login login) {
        //implement business logic here:

        /** Example 1:  new item 
        Admin admin = new Admin();
        repository().save(admin);

        */

        /** Example 2:  finding and process
        

        repository().findById(login.get???()).ifPresent(admin->{
            
            admin // do something
            repository().save(admin);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void approveLogout(Logout logout) {
        //implement business logic here:

        /** Example 1:  new item 
        Admin admin = new Admin();
        repository().save(admin);

        */

        /** Example 2:  finding and process
        

        repository().findById(logout.get???()).ifPresent(admin->{
            
            admin // do something
            repository().save(admin);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
