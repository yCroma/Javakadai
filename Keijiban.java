package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Keijiban
 */
@WebServlet("/Keijiban")
public class Keijiban extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Keijiban() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action.equals("リセット")) {
			terminateSession(request, response);
		} else if (action.equals("送信")) {
			keiji(request, response);
		}
	}

	void keiji (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chat = request.getParameter("chat");

		HttpSession session = request.getSession();
		List<String> chatarray = (List<String>)session.getAttribute("chatarray");
		if (chatarray == null) {
			chatarray = createArray();
			session.setAttribute("chatarray", chatarray);
		}
		if (chat != "") {
			chatarray.add(chat);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/keijiban.jsp");
		dispatcher.forward(request, response);
		System.out.println(chatarray);
	}

	void terminateSession (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/keijiban.jsp");
		dispatcher.forward(request, response);
	}

	public List<String> createArray() {
		List<String> list = new ArrayList<String>();
		return list;
	}

}
