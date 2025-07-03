package bookmanagementcna.controller;

import bookmanagementcna.domain.Admin;
import bookmanagementcna.domain.AdminRepository;
import bookmanagementcna.domain.Login;
import bookmanagementcna.domain.Logout;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins") // 기본 경로
@RequiredArgsConstructor
public class AdminController {

    private final AdminRepository adminRepository;

    @PostMapping("/approve-author")
    public void approveAuthor(@RequestParam Long requestId,
                              @RequestParam Long targetId,
                              @RequestParam Long adminId,
                              @RequestParam String message) {
        
        Admin admin = new Admin();
        admin.setRequestId(requestId);
        admin.setRequestType("AUTHOR");
        admin.setTargetId(targetId);
        admin.setAdminId(adminId);
        admin.setMessage(message);
        admin.setStatus("APPROVED");
        adminRepository.save(admin);

        admin.approveAuthor();
        adminRepository.save(admin);
    }

    @PostMapping("/approve-book")
    public void approveBook(@RequestParam Long requestId,
                            @RequestParam Long targetId,
                            @RequestParam Long adminId,
                            @RequestParam String message) {
        Admin admin = new Admin();
        admin.setRequestId(requestId);
        admin.setRequestType("BOOK");
        admin.setTargetId(targetId);
        admin.setAdminId(adminId);
        admin.setMessage(message);
        admin.setStatus("APPROVED");
        adminRepository.save(admin);

        admin.approveBook();
        adminRepository.save(admin);
    }

    @PostMapping("/resolve-report")
    public void resolveReport(@RequestParam Long requestId,
                              @RequestParam Long targetId,
                              @RequestParam Long adminId,
                              @RequestParam String message) {
        Admin admin = new Admin();
        admin.setRequestId(requestId);
        admin.setRequestType("REPORT");
        admin.setTargetId(targetId);
        admin.setAdminId(adminId);
        admin.setMessage(message);
        admin.setStatus("RESOLVED");
        adminRepository.save(admin);

        admin.resolveReport();
        adminRepository.save(admin);
    }

    @PostMapping("/approve-login")
    public void approveLogin(@RequestBody Login login) {
        Admin.approveLogin(login);
    }

    @PostMapping("/approve-logout")
    public void approveLogout(@RequestBody Logout logout) {
        Admin.approveLogout(logout);
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable Long id) {
        return adminRepository.findById(id).orElseThrow();
    }
}
