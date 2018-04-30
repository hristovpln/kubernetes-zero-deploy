package eu.dreamix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationProperties {
private final Environment env;
	
	@Autowired
	public ApplicationProperties(Environment env) {
		this.env = env;
	}
	
	public String getGreetingMessage() {
		return env.getProperty("app.greeting");
	}

	public String getServerHostName() {
		String fullPodName = env.getProperty("HOSTNAME");
		System.out.println(fullPodName);
		if (fullPodName != null) {
			String[] split = fullPodName.split("-");
			System.out.println("!!!  " + split.length);
			if (split.length == 4)
				return split[split.length - 1];
		}
		return null;
	}
}
