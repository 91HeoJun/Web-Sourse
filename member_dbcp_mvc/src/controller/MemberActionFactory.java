package controller;

import action.Action;
import action.MemberJoinAction;
import action.MemberLeaveAction;
import action.MemberLoginAction;
import action.MemberModifyAction;
import action.MemeberCheckIdAction;

public class MemberActionFactory {

	private static MemberActionFactory factory;
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if (factory == null) {
			factory = new MemberActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if (cmd.equals("/login.do")) {
			action = new MemberLoginAction("view/loginForm.jsp");
			
		} else if(cmd.equals("/modify.do")) {
			action = new MemberModifyAction("view/loginForm.jsp");
		
		} else if(cmd.equals("/leave.do")) {
			action = new MemberLeaveAction("index.jsp");
			
		} else if(cmd.equals("/join.do")) {
			action = new MemberJoinAction("view/loginForm.jsp");
			
		} else if(cmd.equals("/checkID.do")) {
			action = new MemeberCheckIdAction("view/checkID.jsp");
		}
		
		
		return action;
	}
	
}
