package co.com.example.definitions;

import co.com.example.models.UsuariosModels;
import co.com.example.steps.RegistroSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.sql.SQLException;
import java.util.List;

public class RegistroAutomatizadoDefinitions {

    @Steps
    RegistroSteps registroSteps;

    @Given("^Yo Ingreso a la plataforma de ejemplo$")
    public void yo_Ingreso_a_la_plataforma_de_ejemplo() throws SQLException, ClassNotFoundException {
        registroSteps.abrirNavegador();
    }

    @Given("^Yo cargo los datos de prueba$")
    public void yo_cargo_los_datos_de_prueba(List<UsuariosModels> usuariosModels) {
        registroSteps.llevarDatos(usuariosModels);
    }

    @When("^Yo realizo el registro de usuario$")
    public void yo_realizo_el_registro_de_usuario() {
        registroSteps.diligenciarFormulario();
    }

    @Then("^Yo verifico que el registro sea exitoso$")
    public void yo_verifico_que_el_registro_sea_exitoso() {
        registroSteps.comprueboNuevoRegistro();
    }

    @Then("^Yo verifico valores en la base de datos$")
    public void yo_verifico_valores_en_la_base_de_datos() throws SQLException, ClassNotFoundException {
        registroSteps.compruebaValoresEnBD();
    }
}
