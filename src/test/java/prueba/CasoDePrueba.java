package prueba;

import javax.swing.text.Document;

import com.app.gestionTareas.persistencia.TareaDAO;
import com.app.gestionTareas.persistencia.agenteDB;
import com.mongodb.client.MongoCollection;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;


public class CasoDePrueba {
	
	@Given("^Una tarea \"([^\"]*)\"$")
	public void una_tarea(String arg1) throws Throwable {
		TareaDAO.insertar(arg1);
	}
/*
	@When("^Inserto tarea en la base de datos$")
	public void inserto_tarea_en_la_base_de_datos(MongoCollection<Document> coleccion ,Document document) throws Throwable {
		coleccion.insertOne(document);
		
	}
*/
	@Then("^Confirma que se ha insertado$")
	public void confirma_que_se_ha_insertado() throws Throwable {
		TareaDAO.leer();
	}
	
}
