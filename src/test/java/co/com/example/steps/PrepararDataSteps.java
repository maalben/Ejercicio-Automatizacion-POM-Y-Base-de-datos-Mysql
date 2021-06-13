package co.com.example.steps;

import co.com.example.models.UsuariosModels;
import co.com.example.pageobject.PrepararDataPageObject;
import net.thucydides.core.annotations.Step;

import java.sql.SQLException;
import java.util.List;

public class PrepararDataSteps {

    PrepararDataPageObject prepararDataPageObject;

    private List<UsuariosModels> usuariosModels;

    @Step
    public void cargarDatosParaPreparacion(List<UsuariosModels> usuariosModels)
            throws SQLException, ClassNotFoundException {
        this.usuariosModels = usuariosModels;
        prepararDataPageObject.insertarDataEnBD(this.usuariosModels);
    }

    @Step
    public void validarDatos() throws SQLException, ClassNotFoundException {
        prepararDataPageObject.validarDatosEnBD();
    }
}
