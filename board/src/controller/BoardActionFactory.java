package controller;

import action.Action;
import action.BoardHitUpdateAction;
import action.BoardListAction;
import action.BoardModifyAction;
import action.BoardRemoveAction;
import action.BoardReplyViewAction;
import action.BoardUpdateAction;
import action.BoardViewAction;
import action.BoardWriteAction;

public class BoardActionFactory {

	private static BoardActionFactory baf;
	private BoardActionFactory() {}

	public static BoardActionFactory getInstance() {
		if (baf == null) {
			baf = new BoardActionFactory();
		}
		return baf;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if (cmd.equals("/qWrite.do")) {
			action = new BoardWriteAction("qList.do");
			
		} else if(cmd.equals("/qList.do")) {
			action = new BoardListAction("view/qna_board_list.jsp");
			
		} else if(cmd.equals("/qView.do")) {
			action = new BoardViewAction("view/qna_board_view.jsp");
		
		} else if(cmd.equals("/qHitUpdate.do")) {
			action = new BoardHitUpdateAction("qView.do");
			
		} else if(cmd.equals("/qRemove.do")) {
			action = new BoardRemoveAction("qList.do");
			
		} else if(cmd.equals("/qModify.do")) {
			action = new BoardModifyAction("view/qna_board_modify.jsp");
			//action = new BoardViewAction("view/qna_board_view.jsp");
			
		} else if(cmd.equals("/qUpdate.do")) {
			action = new BoardUpdateAction("qView.do");

		} else if(cmd.equals("/qReplyView.do")) {
			action = new BoardReplyViewAction("view/qna_board_reply.jsp");
			
		}
		
		return action;
	}
}