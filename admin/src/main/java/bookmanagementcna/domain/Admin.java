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

    private String status;      // APPROVED, REJECTED, RESOLVED

    private Long adminId;

    private Date approvedAt;

    private String message;

    @PostPersist
    public void onPostPersist() {
        if ("REPORT".equals(this.requestType)) {
            ReportResolved reportResolved = new ReportResolved(this);
            reportResolved.publishAfterCommit();
        }
        else if ("BOOK".equals(this.requestType)) {
            BookApproved bookApproved = new BookApproved(this);
            bookApproved.publishAfterCommit();
        }
    }

    @PostUpdate
    public void onPostUpdate() {
        if ("AUTHOR".equals(this.requestType)) {
            AuthorApproved authorApproved = new AuthorApproved(this);
            authorApproved.publishAfterCommit();
        }
    }

    public static AdminRepository repository() {
        AdminRepository adminRepository = AdminApplication.applicationContext.getBean(
            AdminRepository.class
        );
        return adminRepository;
    }

    //<<< Clean Arch / Port Method
    public static void requestRegister(RegistrationRequested event) {
        Admin admin = new Admin();
        admin.setRequestId(event.getId());
        admin.setRequestType("AUTHOR");
        admin.setTargetId(event.getEmail());
        admin.setStatus("PENDING");
        admin.setRequestedAt(new Date().toString());
        repository().save(admin);
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void requestRegister(PublishRequestRegistered event) {
       Admin admin = new Admin();
        admin.setRequestId(event.getId());
        admin.setRequestType("BOOK");
        admin.setTargetId(event.getAuthorId());
        admin.setStatus("PENDING");
        admin.setRequestedAt(new Date().toString());
        repository().save(admin);
    }

    public static void requestResolve(ContentReported event) {
        Admin admin = new Admin();
        admin.setRequestId(event.getId());
        admin.setRequestType("REPORT");
        admin.setTargetId(event.getReportedContentId());
        admin.setStatus("PENDING");
        admin.setRequestedAt(new Date().toString());
        repository().save(admin);
    }

    public static void approveLogin(Login login) {
        System.out.println("Login approved for: " + login.getUserId());
    }

   public static void approveLogout(Logout logout) {
        System.out.println("Logout approved for: " + logout.getUserId());
    }

}
