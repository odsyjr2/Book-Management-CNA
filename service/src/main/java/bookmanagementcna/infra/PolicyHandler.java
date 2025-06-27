package bookmanagementcna.infra;

import bookmanagementcna.config.kafka.KafkaProcessor;
import bookmanagementcna.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ServiceRepository serviceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RequestApproved'"
    )
    public void wheneverRequestApproved_CreateAiCoverImage(
        @Payload RequestApproved requestApproved
    ) {
        RequestApproved event = requestApproved;
        System.out.println(
            "\n\n##### listener CreateAiCoverImage : " +
            requestApproved +
            "\n\n"
        );

        // Sample Logic //
        Service.createAiCoverImage(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointsUsed'"
    )
    public void wheneverPointsUsed_BookRequest(@Payload PointsUsed pointsUsed) {
        PointsUsed event = pointsUsed;
        System.out.println(
            "\n\n##### listener BookRequest : " + pointsUsed + "\n\n"
        );

        // Sample Logic //
        Service.bookRequest(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointsUsed'"
    )
    public void wheneverPointsUsed_ViewIncrease(
        @Payload PointsUsed pointsUsed
    ) {
        PointsUsed event = pointsUsed;
        System.out.println(
            "\n\n##### listener ViewIncrease : " + pointsUsed + "\n\n"
        );

        // Sample Logic //
        Service.viewIncrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReportResolved'"
    )
    public void wheneverReportResolved_DeactivateContent(
        @Payload ReportResolved reportResolved
    ) {
        ReportResolved event = reportResolved;
        System.out.println(
            "\n\n##### listener DeactivateContent : " + reportResolved + "\n\n"
        );

        // Sample Logic //
        Service.deactivateContent(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
