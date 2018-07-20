package controller.seminaries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import model.entity.Access;
import model.entity.Resource;
import model.entity.Role;
import model.entity.Seminary;
import model.entity.User;

@SuppressWarnings("serial")
public class SeminariesControllerUsers extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String sem_id=req.getParameter("seminaryID");
		
		Long seminario_id= Long.parseLong(sem_id);
		
		try{
			Seminary list_users;
			Key ksem = KeyFactory.createKey(Seminary.class.getSimpleName(),seminario_id);
			list_users=pm.getObjectById(Seminary.class, ksem);
			
			ArrayList<String> users= list_users.getUsers_go();
			req.setAttribute("users", users);
			
		
		}finally{
			pm.close();
		}
		RequestDispatcher rd= getServletContext().getRequestDispatcher("/WEB-INF/Views/Seminaries/users.jsp");
		rd.forward(req, resp);
		

	}
}