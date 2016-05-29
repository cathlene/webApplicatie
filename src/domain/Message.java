package domain;

public class Message {

	private String message;
	private Person target;
	private Person sender;
	public Message(String message, Person target, Person sender){
		this.setMessage(message);
		this.setTarget(target);
		this.setSender(sender);
	}
	
	public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public Person getTarget() {
		return target;
	}

	public void setTarget(Person target) {
		this.target = target;
	}
	
	

	
}
