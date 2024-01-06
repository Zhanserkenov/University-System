package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import main.User;
import main.Data;
import main.SupportRequest;
import main.TechSupportSpecialist;

public class TechSupportSpecialistMenu implements UserMenu {
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

    public void showMenu() {
        System.out.println("\n________________ Tech Support Specialist Commands ________________");
        System.out.println("__________________________________________________________________");
        System.out.println("                   1.View Support Requests                        ");
        System.out.println("                   2.Process Support Request                      ");
        System.out.println("                   0.Exit                                         ");
        System.out.println("__________________________________________________________________");
    }

    public void viewSupportRequests(User user) {
    	System.out.println("\nSupport Requests: ");
    	((TechSupportSpecialist) user).viewSupportRequests();
    }

    public void processSupportRequest(User user) throws NumberFormatException, IOException {
    	System.out.println("\nChoose Support Request to Process: ");
        int id = 1;
        Vector<SupportRequest> supportRequests = Data.getData().getSupportRequests();
        for (SupportRequest request : supportRequests) {
            System.out.println(id + ". " + request.getMessage());
            id++;
        }
        
        int chooseRequest = Integer.parseInt(inp.readLine());
        SupportRequest selectedRequest = supportRequests.get(chooseRequest - 1);
        
        System.out.println("Do you want to approve this Support Request? (yes/no)");
        String decision = inp.readLine().toLowerCase();
        
        boolean approve = decision.equals("yes");
        boolean result = ((TechSupportSpecialist) user).processSupportRequest(selectedRequest, approve);
        
        if(result) {
            supportRequests.remove(selectedRequest);
        }
        else {
        	System.out.println("Invalid choice.");
        }
    }

    public void performActions(User user) throws Exception {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        try {
            boolean exit = false;

            while (!exit) {
                showMenu();
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(inp.readLine());

                switch (choice) {
                    case 1:
                        viewSupportRequests(user);
                        break;
                    case 2:
                        processSupportRequest(user);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

}

