package main;

import java.util.Vector;

public class TechSupportSpecialist extends Employee {
	private static final long serialVersionUID = 1L;

	public TechSupportSpecialist(String name, String surname) {
        super(name, surname);
    }

    public void viewSupportRequests() {
        Vector<SupportRequest> supportRequests = Data.getData().getSupportRequests();

        for (SupportRequest request : supportRequests) {
            System.out.println(request);
        }
    }

    public boolean processSupportRequest(SupportRequest supportRequest, boolean approve) {
        if (approve) {
            supportRequest.markAsProcessed();
            System.out.println("Support request approved: " + supportRequest.getMessage());
            return true;
        } else {
            System.out.println("Support request rejected: " + supportRequest.getMessage());
            return false;
        }
    }
}


