package controller.alumnos;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Alumno;
import model.entity.Resource;
import model.entity.User;

@SuppressWarnings("serial")
public class AlumnosControllerUpdate extends HttpServlet {
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

						Alumno alumno = pm.getObjectById(Alumno.class, Long.parseLong(req.getParameter("id")));
						pm.close();
						req.setAttribute("alumno", alumno);
						RequestDispatcher var = this.getServletContext()
								.getRequestDispatcher("/WEB-INF/Views/Alumnos/update1.jsp");
						var.forward(req, resp);
					}
				}
			}

		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Alumno alumno = pm.getObjectById(Alumno.class, Long.parseLong(req.getParameter("id")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date  birth = null;
		try {

			birth = sdf.parse(req.getParameter("birth"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alumno.setEmail(req.getParameter("email"));
		alumno.setNames(req.getParameter("names"));
		alumno.setApellidos(req.getParameter("apellidos"));
		alumno.setDNI(req.getParameter("DNI"));
		alumno.setDegree(req.getParameter("degree"));
		alumno.setEdad(req.getParameter("edad"));
		
		//alumno.setCh_number(req.getParameter("ch_number"));
		//alumno.setCivil_status(req.getParameter("civil_status"));
		//alumno.setOccupation(req.getParameter("occupation"));
		//alumno.setPlace_birth(req.getParameter("place_birth"));
		//alumno.setDegree_instruction(req.getParameter("degree_instruction"));
		//alumno.setRace(req.getParameter("race"));
		//alumno.setReligion(req.getParameter("religion"));
		alumno.setGender(Boolean.parseBoolean(req.getParameter("gender")));
		//alumno.setCreated(created);
		alumno.setBirth(birth);

		pm.close();
		req.setAttribute("alumno", alumno);
		resp.sendRedirect("/alumnos/view?id=" + req.getParameter("id"));
	}
}