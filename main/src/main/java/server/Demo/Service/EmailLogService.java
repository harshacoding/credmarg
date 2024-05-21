package server.Demo.Service;

import java.util.List;

import server.Demo.Model.EmailLog;

public interface EmailLogService {
	void saveEmailLog(EmailLog emailLog);
	List<EmailLog> getAllEmailLogs();

}
