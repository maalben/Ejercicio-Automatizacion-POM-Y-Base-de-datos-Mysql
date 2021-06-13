package co.com.example.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistroManualDefinitions {

    @Given("^Yo Ingreso a la plataforma colorlib$")
    public void yo_Ingreso_a_la_plataforma_colorlib() {}

    @Given("^Yo ingreso el usuario$")
    public void yo_ingreso_el_usuario() {}

    @Given("^Yo ingreso la clave invalida$")
    public void yo_ingreso_la_clave_invalida() {}

    @When("^Yo presiono el botón de ingresar$")
    public void yo_presiono_el_botón_de_ingresar() {}

    @Then("^Yo deberia ver un mensaje de error$")
    public void yo_deberia_ver_un_mensaje_de_error() {}

    @Then("^Yo deberia ver mensaje en el home$")
    public void yo_deberia_ver_mensaje_en_el_home() {}
}