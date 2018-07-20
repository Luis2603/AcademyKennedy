package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import model.entity.User;
import model.entity.Role;
import controller.PMF;

@SuppressWarnings("serial")
public class UsersControllerLogin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		UserService us = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User user = us.getCurrentUser();
		if(user == null){
			resp.sendRedirect(us.createLoginURL("/users/login"));
		}else{
			String mensaje;
			String admin_email="Skyper.2603@gmail.com";
			if(user.getEmail().toLowerCase().equals(admin_email.toLowerCase())){
				mensaje="Usted ha iniciado sesion como: Administrador";
				req.setAttribute("mensaje", mensaje);
				req.setAttribute("user", user);
				
				RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginadmin.jsp");
				var.forward(req, resp);
			}else{
				
				PersistenceManager pm = PMF.get().getPersistenceManager();
				String query = "select from " + User.class.getName();
				List<User> usuarios = (List<User>) pm.newQuery(query).execute();
				User usuarioencontrado=null;
				boolean existe=false;
				for(User search: usuarios){
					if(search.getEmail().toLowerCase().equals(user.getEmail().toLowerCase())){
						existe=true;
						usuarioencontrado=search;
						break;	
					}
				}
				if(existe){
					String queryrole = "select from " + Role.class.getName() + " where id==" + usuarioencontrado.getIdRole();
					List<Role> rol_usuario= (List<Role>) pm.newQuery(queryrole).execute();
					
					String mensaje2="Usted ha iniciado sesion como: "+rol_usuario.get(0).getName() ;
					req.setAttribute("mensaje", mensaje2);
					req.setAttribute("user", user);
					req.setAttribute("EntityUser", usuarioencontrado);
					RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/loginadmin.jsp");
					var.forward(req, resp);
								
				}else{
						String mensaje3="Usted no esta registrado";
						req.setAttribute("mensaje", mensaje3);
						resp.sendRedirect("/users/logout");
					}
				
		
		}
		}
		}
	
	
}