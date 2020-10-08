package dominio;

import javax.servlet.http.HttpSession;
import persistencia.*;

public class Manager {
	
	private Manager() {		
	}
	
	private static class ManagerHolder {
		static Manager singleton=new Manager();
	}
	
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	public void enviar(HttpSession session, String nombre, Boolean done) {
		try {
						
			TareaDAO.insert(nombre, done);
			
			
		} catch (Exception e) {
        	
        }
	}
}