package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.Catalog;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetCatalog
 */
@WebServlet("/GetCatalog")
public class GetCatalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCatalog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("contentType","text/html; charset=utf-8");
		if(request.getParameter("catalogNo")!=null&&request.getParameter("catalogNo")!=""){
			System.out.println(Integer.parseInt(request.getParameter("catalogNo")));
			PrintWriter out = response.getWriter();
			int catalogNum = Integer.parseInt(request.getParameter("catalogNo"));
			Catalog catalog = new Catalog();
			JSONObject json=new JSONObject();
			json.put("cataNo",catalog.getCatalogLevel2()[catalogNum].length);
			String cata2s = "";
			for (int i = 0; i < catalog.getCatalogLevel2()[catalogNum].length; i++){
				cata2s+=catalog.getCatalogLevel2()[catalogNum][i];
				cata2s+="*";
			}
			json.put("cata2s", cata2s);
			out.print(json);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
