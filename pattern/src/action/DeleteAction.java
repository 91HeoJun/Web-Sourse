package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevice.DeleteService;

public class DeleteAction {
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		//request.getParameter
		
		String name = request.getParameter("name");
		System.out.println("Delete Action : " + name);
		
		DeleteService service = new DeleteService();
		service.deleteMember(name);
	}
}
