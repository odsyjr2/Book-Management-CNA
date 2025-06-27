package bookmanagementcna.domain;

import bookmanagementcna.SubscribersManagementApplication;
import bookmanagementcna.domain.ContentViewEnabled;
import bookmanagementcna.domain.Login;
import bookmanagementcna.domain.Logout;
import bookmanagementcna.domain.PointsAdded;
import bookmanagementcna.domain.PointsUsed;
import bookmanagementcna.domain.SignedIn;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Subscriber_table")
@Data
//<<< DDD / Aggregate Root
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String name;

    private String message;

    private Integer point;

    private Boolean joinStatus;

    private Boolean ktCustomer;

    private String loginStatus;

    @PostPersist
    public void onPostPersist() {
        SignedIn signedIn = new SignedIn(this);
        signedIn.publishAfterCommit();

        PointsAdded pointsAdded = new PointsAdded(this);
        pointsAdded.publishAfterCommit();

        PointsUsed pointsUsed = new PointsUsed(this);
        pointsUsed.publishAfterCommit();

        ContentViewEnabled contentViewEnabled = new ContentViewEnabled(this);
        contentViewEnabled.publishAfterCommit();

        Login login = new Login(this);
        login.publishAfterCommit();

        Logout logout = new Logout(this);
        logout.publishAfterCommit();
    }

    public static SubscriberRepository repository() {
        SubscriberRepository subscriberRepository = SubscribersManagementApplication.applicationContext.getBean(
            SubscriberRepository.class
        );
        return subscriberRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateFeedWhenBookInfoTransferred(
        BookPublicated bookPublicated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscriber subscriber = new Subscriber();
        repository().save(subscriber);

        */

        /** Example 2:  finding and process
        
        // if bookPublicated.gptApiId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> serviceMap = mapper.convertValue(bookPublicated.getGptApiId(), Map.class);

        repository().findById(bookPublicated.get???()).ifPresent(subscriber->{
            
            subscriber // do something
            repository().save(subscriber);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void bookInfoSave(BookInfoSended bookInfoSended) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscriber subscriber = new Subscriber();
        repository().save(subscriber);

        */

        /** Example 2:  finding and process
        
        // if bookInfoSended.gptApiId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> serviceMap = mapper.convertValue(bookInfoSended.getGptApiId(), Map.class);

        repository().findById(bookInfoSended.get???()).ifPresent(subscriber->{
            
            subscriber // do something
            repository().save(subscriber);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
