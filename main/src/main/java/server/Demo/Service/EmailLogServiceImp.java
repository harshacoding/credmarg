package server.Demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.Demo.Model.EmailLog;
import server.Demo.Repository.EmailLogRepository;

@Service
public class EmailLogServiceImp implements EmailLogService {
	 @Autowired
	    private EmailLogRepository emailLogRepository;

	    @Override
	    public void saveEmailLog(EmailLog emailLog) {
	        emailLogRepository.save(emailLog);
	    }
	    @Override
	    public List<EmailLog> getAllEmailLogs() {
	        return emailLogRepository.findAll();
	    }


}
