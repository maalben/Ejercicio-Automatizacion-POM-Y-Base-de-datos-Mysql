Feature: Acciones en la página de ejemplo
  Description: El usuario debe poder ingresar al formulario los datos requeridos.
  El objetivo de la prueba es realizar validaciones con base de datos mysql
  cuando sea procesado un guardado.

  @RegistroYValidacionConBD
  Scenario Outline: Registro exitoso en la página de ejemplo
    Given Yo Ingreso a la plataforma de ejemplo
    And Yo cargo los datos de prueba
      | nombre    | apellido    | email            |    password    |
      | <nombre>  | <apellido>  | <email>          |    <password>  |
    When Yo realizo el registro de usuario
    Then Yo verifico que el registro sea exitoso
    And Yo verifico valores en la base de datos

    Examples:
   | nombre         | apellido         | email                   |password|
      ##@externaldata@./src/test/resources/datos/datos.xlsx@Sheet1
   |Prueba Nombre   |Prueba Apellido   |datosprueba1@gmail.com   |123456|


  @EjecucionManualFallida
  @manual-result:failed
  Scenario: Validar password invalido
    Given Yo Ingreso a la plataforma colorlib
    And Yo ingreso el usuario
    And Yo ingreso la clave invalida
    When Yo presiono el botón de ingresar
    Then Yo deberia ver un mensaje de error

  @EjecucionManualExitosa
  @manual-result:passed
  Scenario: Validar password valido
    Given Yo Ingreso a la plataforma colorlib
    And Yo ingreso el usuario
    And Yo ingreso la clave invalida
    When Yo presiono el botón de ingresar
    Then Yo deberia ver mensaje en el home
