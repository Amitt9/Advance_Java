package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test1",loadOnStartup = 1)
//wc reads this when only once at web app deployment time
//wc creates an empty map and then populate the url map  -->(at webapp deployment time)
//key:/test1 value:pages.Servlet1
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doget by : "+Thread.currentThread());
		//set resp content type(setting a resp header content-type:text/html )
		resp.setContentType("text/html");
		//get the printwriter to send char , buf data (resp) to clnt
		try(PrintWriter pw=resp.getWriter()){
			pw.print("<h4>Welcome to servlet : </h4>"+getClass()+" TS "+LocalDateTime.now());
			//wc : pw.flush()-->buffer contents are sent--->pw.close()
		}
	
	}

	@Override
	public void destroy() {
		System.out.println("in destroy by : "+Thread.currentThread());
		
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init by 235 : "+Thread.currentThread());

	}

}
