package controller.seminaries;

import java.io.IOException;
import java.util.*;

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
import model.entity.User;
import model.entity.Seminary;

@SuppressWarnings("serial")
public class SeminariesControllerGo extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String sem_id=req.getParameter("seminaryID");
		String email_user=req.getParameter("email_user");
		
		Long seminario_id= Long.parseLong(sem_id);
		

		try{
			
			Seminary update;
			Key ksem = KeyFactory.createKey(Seminary.class.getSimpleName(),seminario_id);
			update=pm.getObjectById(Seminary.class, ksem);
			ArrayList<String>revision=update.getUsers_go();
			boolean serepite =false;
			for(String email : revision){
				if(email_user.toLowerCase().equals(email)){
					serepite=true;
					break;
				}
			}
			if(serepite){
				RequestDispatcher var = getServletContext().getRequestDispatcher("/WEB-INF/Views/Errors/deny55.jsp");
				var.forward(req, resp);
			}else{
				update.addUser(email_user);
			}
		}finally{
			pm.close();
		}
		resp.sendRedirect("/seminaries/display");
		

	}
}