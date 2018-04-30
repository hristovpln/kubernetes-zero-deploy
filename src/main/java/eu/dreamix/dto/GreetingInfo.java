package eu.dreamix.dto;

public class GreetingInfo {
	
	private final String message;
	private final String version;
	private final String pod;
	
	public GreetingInfo(String message, String version, String pod) {
		super();
		this.message = message;
		this.version = version;
		this.pod = pod;
	}
	public String getMessage() {
		return message;
	}
	public String getVersion() {
		return version;
	}
	public String getPod() {
		return pod;
	}
}
