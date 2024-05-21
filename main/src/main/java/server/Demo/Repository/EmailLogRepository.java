package server.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.Demo.Model.EmailLog;

public interface EmailLogRepository extends JpaRepository<EmailLog, Long>  {

}
