package co.com.example.utilitiesGeneral;

import java.sql.*;

public class SQLConnector {
    private String rutaDB = "jdbc:mysql://localhost:3306/pruebas";
    private String usuario = "root";
    private String password = "12345678";
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;

    private void establecerConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conexion = DriverManager.getConnection(rutaDB, usuario,password);
        this.sentencia = this.conexion.createStatement();
    }

    public String traerRegistroEspecifico(String query, String nombreColumna) throws SQLException, ClassNotFoundException {
        establecerConexion();
        this.resultado = this.sentencia.executeQuery(query);
        this.resultado.next();
        String valor = this.resultado.getString(nombreColumna);
        conexion.close();
        return valor;
    }

    public boolean validarRegistroGuardado(String query) throws SQLException, ClassNotFoundException {
        establecerConexion();
        resultado = sentencia.executeQuery(query);
        boolean devuelve = resultado.first();
        conexion.close();
        return devuelve;
    }

    public int scriptActionsBD(String query) throws SQLException, ClassNotFoundException {
        establecerConexion();
        int resultado = 0;
        sentencia = conexion.createStatement();
        resultado = sentencia.executeUpdate(query);
        conexion.close();
        return resultado;
    }




}
