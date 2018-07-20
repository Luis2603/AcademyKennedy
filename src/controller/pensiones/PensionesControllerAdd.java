
package controller.pensiones;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Alumno;
import model.entity.Resource;
import model.entity.Role;
import model.entity.User;

import javax.servlet.*;
import javax.jdo.PersistenceManager;

@SuppressWarnings("serial")
public class PensionesControllerAdd extends HttpServlet {
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
						doPost(req, resp);
					}
				}

			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String email= req.getParameter("email");
		String names= req.getParameter("names");
		String apellidos= req.getParameter("apellidos");
		String degree= req.getParameter("degree");
		String edad= req.getParameter("edad");
		//String ch_number = req.getParameter("ch_number");
		String DNI = req.getParameter("DNI");
		//String place_birth = req.getParameter("place_birth");
	//	String degree_instruction = req.getParameter("degree_instruction");
		//String race = req.getParameter("race");
		//String occupation = req.getParameter("occupation");
		//String religion = req.getParameter("religion");
		//String civil_status = req.getParameter("civil_status");

		boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
/*
		if (req.getParameter("names") != null && req.getParameter("apellidos") != null && req.getParameter("DNI") != null
				&& req.getParameter("place_birth") != null && req.getParameter("degree_instruction") != null
				&& req.getParameter("race") != null && req.getParameter("occupation") != null
				//&& req.getParameter("religion") != null && req.getParameter("civil_status") != null
				&& req.getParameter("gender") != null && req.getParameter("birth") != null
				&& req.getParameter("created") != null) {
			Patient p;
			
*/
		
		if (req.getParameter("names") != null && req.getParameter("apellidos") != null && req.getParameter("degree") != null && req.getParameter("DNI") != null) {
			Alumno p;
			
			try {
				Date birth = null;
				
				birth = sdf.parse(req.getParameter("birth"));
				p = new Alumno(email,names,apellidos,DNI, gender,  birth, degree,edad);
				try {
					pm.makePersistent(p);
				} finally {
					pm.close();
				}
				System.out.println(p.toString());
				resp.sendRedirect("/alumnos");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Alumnos/add1.jsp");
		try {
			var.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
