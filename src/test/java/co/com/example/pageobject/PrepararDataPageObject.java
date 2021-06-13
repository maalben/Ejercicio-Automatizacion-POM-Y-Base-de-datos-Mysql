package co.com.example.pageobject;

import co.com.example.models.UsuariosModels;
import co.com.example.utilitiesGeneral.SQLConnector;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;

public class PrepararDataPageObject extends PageObject {

    private List<UsuariosModels> usuariosModels;
    SQLConnector bd = new SQLConnector();

    public void insertarDataEnBD(List<UsuariosModels> usuariosModels) throws SQLException, ClassNotFoundException {
        this.usuariosModels = usuariosModels;

        String query =
                "INSERT INTO usuarios (email, password, nombre, apellido) VALUES ('"+this.usuariosModels.get(0).getEmail()+"', '"+this.usuariosModels.get(0).getPassword()+"', '"+this.usuariosModels.get(0).getNombre()+"', '"+this.usuariosModels.get(0).getApellido()+"')";

        bd.scriptActionsBD(query);
    }

    public void validarDatosEnBD() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM usuarios WHERE email = '"+this.usuariosModels.get(0).getEmail()+"'";
        Assert.assertTrue(bd.validarRegistroGuardado(query));
    }
}
