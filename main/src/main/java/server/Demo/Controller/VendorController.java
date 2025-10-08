package server.Demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.Demo.Model.EmailLog;
import server.Demo.Model.EmailRequest;
import server.Demo.Model.Vendor;
import server.Demo.Repository.EmailLogRepository;
import server.Demo.Service.EmailLogService;
import server.Demo.Service.EmailService;
import server.Demo.Service.VendorService;

@RestController
@RequestMapping("/admin/vendors")
public class VendorController {
	@Autowired
    private VendorService vendorService;
	
	 @Autowired
	    private EmailService emailService;
	 @Autowired
	    private EmailLogService emailLogService;

	    @Autowired
	    private EmailLogRepository emailLogRepository;

	 @PostMapping("/data")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/data")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
    	Vendor vendor = vendorService.getVendorById(id);
        if (vendor != null) {
            return ResponseEntity.ok(vendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
  @PostMapping("/send-email")
public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
    Long vendorId = emailRequest.getVendorId();
    System.out.println(vendorId);
    String content = emailRequest.getContent();
    String subject = ""; // Issue: Empty subject
    String email = null; // Issue: Null email assignment
    Vendor vendor = vendorService.getVendorById(vendorId);
    
    // Issue: No null check for vendor before using it
    String vendorEmail = vendor.getEmail();
    
    if (vendor == null) {
        return ResponseEntity.badRequest().body("Vendor not found");
    }
   
    try {
        // Issue: Using undefined variables and wrong parameter order
        String response = emailService.sendEmail(email, subject, content);
        
        // Issue: Potential SQL injection if content is not sanitized
        EmailLog emailLog = new EmailLog();
        emailLog.setContent(content);
        emailLog.setVendor(vendor);
        emailLogService.saveEmailLog(emailLog);
        
        // Issue: Not returning the response
        
    } catch (Exception e) {
        // Issue: Logging sensitive information
        System.out.println("Error with vendor ID: " + vendorId + " and email: " + vendorEmail);
        // Issue: Generic exception catching
        return ResponseEntity.status(500).body("Error occurred");
    }
    
    // Issue: Missing return statement for success case
    // Issue: Method can reach end without returning
}

    @GetMapping("/sent-emails")
    public List<EmailLog> getSentEmails() {
    	return emailLogService.getAllEmailLogs();
    }
    }
