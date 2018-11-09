package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

//구구단 출력 customView
//spring customView를 만들기 위해서는 View interface를 구현할 필요가 있음
public class TimesTablesView implements View {

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.setContentType("text/html; charset=utf-8");
		
		Integer tables = Integer.parseInt(request.getParameter("tables"));
		
		PrintWriter pw = response.getWriter();

		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head> ");
		pw.println("		<meta charset=\"UTF-8\"> ");
		pw.println("		<title>index</title> ");
		pw.println("	</head> ");
		pw.println("	<body id = \"body\"> ");
		pw.println("		<table border=\"1\">");

		for (int j = 1; j <= 9; j++) {
			pw.println("			<tr>");

			for (int i = 2; i <= tables; i++) {
				pw.println("				<td>" + i + " *  " + j + " = " + (i * j) + "</td>");
			}

			pw.println("			</tr>");
		}

		pw.println("		</table>	");
		pw.println("	</body> ");
		pw.println("</html> ");
	}

}
