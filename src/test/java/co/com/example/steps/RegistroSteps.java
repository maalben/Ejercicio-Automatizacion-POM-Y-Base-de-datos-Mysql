package co.com.example.steps;

import co.com.example.models.UsuariosModels;
import co.com.example.pageobject.RegistroPageObject;
import net.thucydides.core.annotations.Step;

import java.sql.SQLException;
import java.util.List;

public class RegistroSteps {

    RegistroPageObject registroPageObject;
    private List<UsuariosModels> usuariosModels;

    @Step
    public void abrirNavegador() throws SQLException, ClassNotFoundException {
        registroPageObject.eliminarDatosEnBD();
        registroPageObject.open();
    }

    @Step
    public void llevarDatos(List<UsuariosModels> usuariosModels) {
        this.usuariosModels = usuariosModels;
        registroPageObject.CargarValoresEnMemoria(usuariosModels);
    }

    @Step
    public void diligenciarFormulario() {
        registroPageObject.escribirDatosFormulario(
                this.usuariosModels.get(0).getNombre(),
                this.usuariosModels.get(0).getApellido(),
                this.usuariosModels.get(0).getEmail(),
                this.usuariosModels.get(0).getPassword()
        );
    }

    @Step
    public void comprueboNuevoRegistro() {
        registroPageObject.verificarGuardado();
    }

    @Step
    public void compruebaValoresEnBD() throws SQLException, ClassNotFoundException {
        registroPageObject.validoEnBaseDeDatos();
    }
}
