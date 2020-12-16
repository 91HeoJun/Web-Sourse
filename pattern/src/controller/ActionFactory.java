package controller;

import action.Action;
import action.DeleteAction;
import action.InsertAction;

public class ActionFactory {
	// action을 만들어서 리턴하는 메소드만 소유
	
	// 싱글톤 패턴 : 객체를 한개만 만들어서 사용하는 것.(새로운 객체생성방지[new => X])
	private static ActionFactory factory;
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	
	public Action action(String cmd) {
		Action action = null;
		if (cmd.equals("/insert.do")) {
			action = new InsertAction("index.jsp");

		} else if (cmd.equals("/delete.do")) {
			action = new DeleteAction("index.jsp");

		} else if (cmd.equals("/update.do")) {

		} else if (cmd.equals("/select.do")) {

		}
		
		return action;
	
	}

}
