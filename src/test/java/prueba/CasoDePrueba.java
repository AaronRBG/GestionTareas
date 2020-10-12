package prueba;

import com.app.gestionTareas.persistencia.TareaDAO;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CasoDePrueba {
	@Given("^una tarea \"([^\"]*)\"$")
	public void una_tarea(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^inserto tarea en la base de datos$")
	public void inserto_tarea_en_la_base_de_datos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^confirma que se ha insertado$")
	public void confirma_que_se_ha_insertado() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
