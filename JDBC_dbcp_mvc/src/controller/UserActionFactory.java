package controller;

import action.Action;
import action.UserInsertAction;
import action.UserListAction;
import action.UserSelectAction;
import action.UserUpdateAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory() {}
	public static UserActionFactory getInstance() {
		if(factory == null) {
			factory = new UserActionFactory();
		}
		return factory;
	}
	public Action action (String cmd) {
		Action action = null;
		if (cmd.equals("/insert.do")) {
			action = new UserInsertAction("list.do");
			
		} else if(cmd.equals("/list.do")) {
			action = new UserListAction("list.jsp");
		
		} else if(cmd.equals("/select.do")) {
			action = new UserSelectAction("select.jsp");
		
		} else if(cmd.equals("/update.do")) {
			action = new UserUpdateAction("update.jsp");
		}
		
		return action;
	}
}
