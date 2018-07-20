package controller.seminaries;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
public class SeminariesControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		com.google.appengine.api.users.User uGoogle = UserServiceFactory.getUserService().getCurrentUser();
		// verificando login presente
		if (uGoogle == null) {
			RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/deny11.jsp");
			var.forward(req, resp);
		} else {
			// PMF para consultas
			PersistenceManager pm = PMF.get().getPersistenceManager();
			// buscando usuario registrado activo con el email
			String query1 = "select from " + User.class.getName() + " where email=='" + uGoogle.getEmail() + "'"
					+ "&& status==true";
			List<User> uSearch = (List<User>) pm.newQuery(query1).execute();
			// verificando usuario registrado
			if (uSearch.isEmpty()) {
				RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/deny22.jsp");
				var.forward(req, resp);
			} else {

				System.out.println(req.getServletPath());
				// buscando recurso registrado activo de acuerdo a la url
				String query2 = "select from " + Resource.class.getName() + " where url=='" + req.getServletPath() + "'"
						+ "&& status==true";

				List<Resource> rSearch = (List<Resource>) pm.newQuery(query2).execute();
				// verificando recurso registrado
				if (rSearch.isEmpty()) {
					RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/deny33.jsp");
					var.forward(req, resp);
				} else {
					// buscando acceso registrado para rol y recurso
					String query3 = "select from " + Access.class.getName() + " where IdRole=="
							+ uSearch.get(0).getIdRole() + "&& IdUrl==" + rSearch.get(0).getId() + "&& status==true";
					List<Access> aSearch = (List<Access>) pm.newQuery(query3).execute();
					// verificando acceso registrado
					if (aSearch.isEmpty()) {
						RequestDispatcher var = getServletContext()
								.getRequestDispatcher("/WEB-INF/Views/Errors/deny44.jsp");
						var.forward(req, resp);
					} else {
						RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Seminaries/add.jsp");
						var.forward(req, resp);
					}
				}
			}

		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String classroom = request.getParameter("classroom");
		String hour = request.getParameter("hour");
		String date = request.getParameter("date");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		final Query q = pm.newQuery(Seminary.class);
		List<Seminary> seminaries=(List<Seminary>)q.execute();
		boolean state = false;
		
		for(Seminary sem : seminaries){
			String c = sem.getClassroom();
			String h = sem.getHour();
			String d = sem.getDate();
			if(classroom.equals(c)&&hour.equals(h)&&date.equals(d)){
				state=true;
				break;
			}
		}
		if(state){
			response.setContentType("text/html");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().print("<!Doctype html>");
		    response.getWriter().print("<html>");
		    response.getWriter().print("<head>");
		    response.getWriter().print("<meta charset='UTF-8'>");
		    response.getWriter().print("<meta http-equiv='refresh' content='3;/seminaries/add'>");
		    response.getWriter().print("</head>");
		    response.getWriter().print("<body>");
		    response.getWriter().print("<h1>Horario, fecha y aula para seminario no disponible</h1>");
		    response.getWriter().print("</body>");
		    response.getWriter().print("</html>");
		    


		}else{
	
		Seminary s = new Seminary(
			request.getParameter("course"),
			request.getParameter("teacher"),
			request.getParameter("classroom"),
			request.getParameter("date"),
			request.getParameter("hour")
								);
		try {
			pm.makePersistent(s);
		} finally {
			pm.close();
		}
	
		response.sendRedirect("/seminaries");
		
		}
		
	}
}
