package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.DataConnection;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetReader
 */
@WebServlet("/GetReader")
public class GetReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		String readerid = request.getParameter("readerid");
		if(readerid!=null){
			JSONObject json = new JSONObject();
			String sql1 = "Select * from reader where readerId = '"+readerid+"';";
			PrintWriter out = response.getWriter();
			
			try {
				conn = DataConnection.getConnection();
				stmt = conn.createStatement();
				ResultSet rs1 = stmt.executeQuery(sql1);
				if(rs1.next()){
					json.put("exist", "1");
					json.put("readername", rs1.getString("readerName"));
				}	else {
					json.put("exist", "0");
				}
				out.println(json);
			} catch (Exception e) {
				e.printStackTrace();  
			}
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
