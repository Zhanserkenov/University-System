package test;

import menu.EnterMenu;

public class Test {

	public static void main(String[] args) throws Exception {

		EnterMenu menu = EnterMenu.getInstance();

		menu.showMenu();
		menu.enterToTheSystem();
	}
}
