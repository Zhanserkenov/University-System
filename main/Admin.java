package main;

import java.security.SecureRandom;

public class Admin extends User {
	private static final long serialVersionUID = 1L;
	
	private static final Admin INSTANCE = new Admin();
	
	private Admin() {
    	
    }
	
	public static Admin getInstance() {
    	return INSTANCE;
    }
	
	public boolean submitSupportRequest(String description) {
		Message message = new Message("Support request from Admin: " + description);
		SupportRequest supportRequest = new SupportRequest(message, this.getName());
		Data.getData().getSupportRequests().add(supportRequest);
		return true;
	}

	public boolean addUser(User user) {
    	user.setLogin(generateLogin(user));
    	user.setPassword(generatePassword(user));
    	
    	System.out.print(user.getPassword());
    	if(Data.getData().getUsers().contains(user))
    		return false;
    	
    	Data.getData().getUsers().add(user);
    	return true;
    }
	
	public boolean removeUser(User user) {
    	if(!Data.getData().getUsers().contains(user))
    		return false;
    	
    	return Data.getData().getUsers().remove(user);
    }
	
    public String generateLogin(User user) {
    	String domen = "@kbtu.kz";
    	char mode = ' ';
    	
    	if(user instanceof Student)
    		mode = '_';
    	else if(user instanceof Employee)
    		mode = '.';
    		
    	
    	return user.getName().substring(0, 1).toLowerCase() + mode + user.getSurname().toLowerCase() + domen;
    }
    
    public String generatePassword(User user) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*.,";
 
        SecureRandom random = new SecureRandom();
        String password = "";
 
        for (int i = 0; i < 8; i++){
            int randomIndex = random.nextInt(chars.length());
            password += chars.charAt(randomIndex);
        }
        
        System.out.println(password);
        return password;
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
