package menu;

import main.User;

public interface UserMenu {
	void showMenu();
	void performActions(User user) throws Exception;
}
