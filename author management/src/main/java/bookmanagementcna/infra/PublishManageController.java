package bookmanagementcna.infra;

import bookmanagementcna.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/publishManages")
@Transactional
public class PublishManageController {

    @Autowired
    PublishManageRepository publishManageRepository;
}
//>>> Clean Arch / Inbound Adaptor
