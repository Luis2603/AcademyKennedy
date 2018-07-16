package controller.access;

import java.io.IOException;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Resource;
import model.entity.Role;
import model.entity.User;

@SuppressWarnings("serial")
public class AccessControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query11 = "select from " + Role.class.getName();
		String query21 = "select from " + Resource.class.getName();

		List<Role> roles = (List<Role>) pm.newQuery(query11).execute();
		List<Resource> resources = (List<Resource>) pm.newQuery(query21).execute();
		// pasar la lista al jsp
		req.setAttribute("roles", roles);
		req.setAttribute("resources", resources);
		RequestDispatcher var = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/add1.jsp");

		var.forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Long IdRole = Long.parseLong(req.getParameter("IdRole"));
		Long IdUrl = Long.parseLong(req.getParameter("IdUrl"));
		boolean status = Boolean.parseBoolean(req.getParameter("status"));

		if (req.getParameter("IdUrl") != null && req.getParameter("IdRole") != null
				&& req.getParameter("status") != null) {
			Access a;
			a = new Access(IdRole, IdUrl, status);
			System.out.println(a);
			System.out.println(IdRole);
			System.out.println(IdUrl);
			System.out.println(Boolean.valueOf(status));
			try {
				pm.makePersistent(a);
			} finally {
				pm.close();
			}
			resp.sendRedirect("/access");
		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/add1.jsp");

		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}