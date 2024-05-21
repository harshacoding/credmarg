package server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
public class SendgridConfig {

	@Value("${proj.sendEmail}")
	private String appKey;
	 @Bean
	    public SendGrid sendGrid() {
	        return new SendGrid(appKey);
	    }
}
 