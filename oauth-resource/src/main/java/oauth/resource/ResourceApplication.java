package oauth.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@EnableResourceServer
@SpringBootApplication
@RestController
public class ResourceApplication {
	@RequestMapping("/")
	public Message home() {
		return new Message("Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
}

class Message {
	private String id = UUID.randomUUID().toString();
	private String content;

	public Message() {
	}

	public Message(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}