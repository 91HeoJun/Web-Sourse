package action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.FileUploadUtil;
import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardUpdateAction implements Action {

	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map = utils.uploadFile(request);
		
		BoardVO vo = new BoardVO();

		vo.setBno(Integer.parseInt(map.get("bno"))); // PK 불러오기
		vo.setTitle(map.get("title"));
		vo.setContent(map.get("content"));
		vo.setPassword(map.get("password"));	// PK + PW 사용하므로 호출
		if (map.containsKey("attach"))
			vo.setAttach(map.get("attach"));
 
		String page = map.get("page");
		String criteria = map.get("criteria");
		String keyword = URLEncoder.encode(map.get("keyword"), "utf-8");
		
		// service 호출
		BoardService service = new BoardServiceImpl();
		boolean flag = service.updateArticle(vo);

		if (!flag) { // 실패
			path = "qModify.do?bno="+map.get("bno")+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
			
		} else { // 성공
			path += "?bno="+map.get("bno")+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}
		return new ActionForward(path, true);
	}
}
