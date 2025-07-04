package bookmanagementcna.infra;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookmanagementcna.domain.BookSummaryRequested;
import bookmanagementcna.service.BookSummaryService;
import lombok.RequiredArgsConstructor;

//api

@RestController
@RequestMapping("/api/subscribers")
@RequiredArgsConstructor
public class BookSummaryController {

    private final BookSummaryService bookSummaryService;

    @PostMapping("/{subscriberId}/book-summary")
    public void requestSummary(@PathVariable Long subscriberId, @RequestBody BookSummaryRequested request) {
        request.setSubscriberId(subscriberId);
        bookSummaryService.requestBookSummary(request);
    }
}
