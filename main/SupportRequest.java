package main;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SupportRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Message message;
	private String customerName;
	private LocalDateTime creationDate;
	private boolean processed;
	
	public SupportRequest(Message message, String customerName) {
		this.message = message;
		this.customerName = customerName;
		this.creationDate = LocalDateTime.now();
		this.processed = false;
	}
	
	public Message getMessage() {
        return message;
    }
	
	public String getCustomerName() {
        return customerName;
    }
	
	public LocalDateTime getCreationDate() {
        return creationDate;
    }
	
	public boolean isProcessed() {
        return processed;
    }
	
	public void markAsProcessed() {
        this.processed = true;
    }
	
	public String toString() {
        return "SupportRequest{" +
                "message=" + message +
                ", customerName='" + customerName + '\'' +
                ", creationDate=" + creationDate +
                ", processed=" + processed +
                '}';
    }
}
