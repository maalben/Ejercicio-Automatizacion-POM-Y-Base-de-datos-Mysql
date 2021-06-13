package co.com.example.pageobject;

import co.com.example.models.UsuariosModels;
import co.com.example.utilitiesGeneral.SQLConnector;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;
import java.util.List;

import static co.com.example.utilitiesGeneral.Utilidades.clickElement;
import static co.com.example.utilitiesGeneral.Utilidades.typeInField;

@DefaultUrl("http://localhost/mvc/index.php")
public class RegistroPageObject extends PageObject {

    SQLConnector bd = new SQLConnector();
    private List<UsuariosModels> usuariosModels;

    public void eliminarDatosEnBD() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM usuarios";
        bd.scriptActionsBD(query);
    }

    public void CargarValoresEnMemoria(List<UsuariosModels> usuariosModels) {
        this.usuariosModels = usuariosModels;
    }

    public void escribirDatosFormulario(String nombre, String apellido, String email, String password) {
        typeInField(this.getDriver().findElement(By.name("nombre")), nombre);
        typeInField(this.getDriver().findElement(By.name("apellido")), apellido);
        typeInField(this.getDriver().findElement(By.name("email")), email);
        typeInField(this.getDriver().findElement(By.name("password")), password);
        clickElement(this.getDriver(), "//input[@type='submit']", "xpath");
    }

    public void verificarGuardado() {
        WebElement buttonBorrar = this.getDriver().findElement(By.xpath("//section//div[1]//a[@class='btn btn-danger']"));
        Assert.assertTrue(buttonBorrar.isDisplayed());
    }

    public void validoEnBaseDeDatos() throws SQLException, ClassNotFoundException {
        WebElement valores = this.getDriver().findElement(By.xpath("//section[@class='col-lg-7 usuario']"));
        String[] resultadoFila = valores.getText().trim().split("Borrar")[0].split(" - ");
        String nombrePagina = resultadoFila[1].trim();
        String apellidoPagina = resultadoFila[2].trim();
        String correooPagina = resultadoFila[3].trim();

        String query = "SELECT * FROM usuarios WHERE email = '"+ usuariosModels.get(0).getEmail() +"'";
        Assert.assertTrue(bd.validarRegistroGuardado(query));
        Assert.assertEquals(nombrePagina, bd.traerRegistroEspecifico(query, "nombre").trim());
        Assert.assertEquals(apellidoPagina, bd.traerRegistroEspecifico(query, "apellido").trim());
        Assert.assertEquals(correooPagina, bd.traerRegistroEspecifico(query, "email").trim());
    }

}
