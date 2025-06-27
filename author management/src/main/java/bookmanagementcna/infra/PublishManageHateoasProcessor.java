package bookmanagementcna.infra;

import bookmanagementcna.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PublishManageHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PublishManage>> {

    @Override
    public EntityModel<PublishManage> process(
        EntityModel<PublishManage> model
    ) {
        return model;
    }
}
