

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistencia.agenteDB;

@Repository
public interface TareaDAO extends CrudRepository<User, String> {

	private TareaDAO() {

	}
	
	public static void insert(String nombre, Boolean done) {
		
		int donette = 0;
		if(done)
			donette=1;
		
		try (Connection bd = agenteDB.get().getBd()) {
			String sql = "insert into Tareas (nombre, done) values (?, ?)";
			try (PreparedStatement ps = bd.prepareStatement(sql)) {
				ps.setString(1, nombre);
				ps.setString(2, donette);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void update(String nombre, Boolean done) {
		
		int donette = 0;
		if(done)
			donette=1;
		
		try (Connection bd = agenteDB.get().getBd()) {
			String sql = "update Tareas set done = ? where nombre = ?";
			try (PreparedStatement ps = bd.prepareStatement(sql)) {
				ps.setString(2, nombre);
				ps.setString(1, donette);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void delete(String nombre) {
				
		try (Connection bd = agenteDB.get().getBd()) {
			String sql = "delete from Tareas where nombre = ?";
			try (PreparedStatement ps = bd.prepareStatement(sql)) {
				ps.setString(1, nombre);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
