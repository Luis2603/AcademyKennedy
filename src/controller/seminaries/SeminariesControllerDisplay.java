package controller.seminaries;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Alumno;
import model.entity.User;
import model.entity.Resource;
import model.entity.Seminary;
import model.entity.Role;

import java.util.List;
import javax.servlet.*;

import javax.jdo.PersistenceManager;

@SuppressWarnings("serial")
public class SeminariesControllerDisplay extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			PersistenceManager pm= PMF.get().getPersistenceManager();
			String query = "select from " + Seminary.class.getName();
			List<Seminary> seminario = (List<Seminary>) pm.newQuery(query).execute();

			// pasar la lista al jsp
			req.setAttribute("seminaries", seminario);

			RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Seminaries/display.jsp");
			var.forward(req, resp);
			
	}
}