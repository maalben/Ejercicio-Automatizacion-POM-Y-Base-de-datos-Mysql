package co.com.example.definitions;

import co.com.example.models.UsuariosModels;
import co.com.example.steps.PrepararDataSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.sql.SQLException;
import java.util.List;

public class PrepararDataDefinitions {

    @Steps
    PrepararDataSteps prepararDataSteps;

    @When("^Yo cargo los datos de prueba para la automatizacion$")
    public void yo_cargo_los_datos_de_prueba_para_la_automatizacion(List<UsuariosModels> usuariosModels)
            throws SQLException, ClassNotFoundException {
        prepararDataSteps.cargarDatosParaPreparacion(usuariosModels);
    }

    @Then("^Yo valido que sea exitoso el proceso$")
    public void yo_valido_que_sea_exitoso_el_proceso() throws SQLException, ClassNotFoundException {
        prepararDataSteps.validarDatos();
    }


}
