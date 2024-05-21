package server.Demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import server.Demo.Model.Vendor;
import server.Demo.Service.VendorService;

@RestController
@RequestMapping("/admin/vendors")
public class VendorController {
	@Autowired
    private VendorService vendorService;
	
	 @Autowired
	    private EmailService emailService;

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
    
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        try {
            String response = emailService.sendEmail(to, subject, body);
            // Save the email log
            EmailLog emailLog = new EmailLog(to, subject, body, response);
            emailLogRepository.save(emailLog);
            return response;
        } catch (IOException e) {
            return "Error while sending email: " + e.getMessage();
        }
    }

 
    }
