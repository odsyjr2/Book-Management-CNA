package bookmanagementcna.infra;

import bookmanagementcna.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "SubscriptionList",
    path = "SubscriptionList"
)
public interface SubscriptionListRepository
    extends PagingAndSortingRepository<SubscriptionList, Long> {}
