package bookmanagementcna.domain;

import bookmanagementcna.AuthorManagementApplication;
import bookmanagementcna.domain.RegistrationRequested;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Author_table")
@Data
//<<< DDD / Aggregate Root
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String name;

    private String introduce;

    private String major;

    private String portfolio;

    private String registerStatus;

    @PostPersist
    public void onPostPersist() {
        RegistrationRequested registrationRequested = new RegistrationRequested(
            this
        );
        registrationRequested.publishAfterCommit();
    }

    public static AuthorRepository repository() {
        AuthorRepository authorRepository = AuthorManagementApplication.applicationContext.getBean(
            AuthorRepository.class
        );
        return authorRepository;
    }

    //<<< Clean Arch / Port Method
    public static void approveAuthor(AuthorApproved authorApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Author author = new Author();
        repository().save(author);

        */

        /** Example 2:  finding and process
        

        repository().findById(authorApproved.get???()).ifPresent(author->{
            
            author // do something
            repository().save(author);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
