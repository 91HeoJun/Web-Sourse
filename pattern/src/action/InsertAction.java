package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevice.InsertService;

public class InsertAction {

		public void insert(HttpServletRequest request, HttpServletResponse response) {
			// ~Pro.jsp에서 했던 작업
			// request.getParameter()
			String name = request.getParameter("name");
			System.out.println("insert_Action name : " + name);
			
			// DB 작업을 InsertService에 부탁
			InsertService service = new InsertService();
			service.insertMember(name);
		}
}
