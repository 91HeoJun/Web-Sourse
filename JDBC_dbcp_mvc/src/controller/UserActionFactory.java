package controller;

import action.Action;
import action.UserDeleteAction;
import action.UserInsertAction;
import action.UserListAction;
import action.UserModifyAction;
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

		} else if(cmd.equals("/modify.do")) {
			action = new UserModifyAction("list.do");
		
		} else if(cmd.equals("/delete.do")) {
			action = new UserDeleteAction("list.do");
		}
		
		return action;
	}
}
