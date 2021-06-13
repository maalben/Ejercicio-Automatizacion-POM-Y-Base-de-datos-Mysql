Feature: Preparación de datos de prueba
  Description: El usuario debe ser capaz de preparar datos de prueba.

  @PrepararDatosDePrueba
  Scenario Outline: Crear datos de prueba para automatizacion
    When Yo cargo los datos de prueba para la automatizacion
      | nombre    | apellido    | email            |    password    |
      | <nombre>  | <apellido>  | <email>          |    <password>  |
    Then Yo valido que sea exitoso el proceso

    Examples:
   | nombre         | apellido         | email                   |password|
      ##@externaldata@./src/test/resources/datos/datos.xlsx@Sheet2
   |Prueba Nombre   |Prueba Apellido   |datosprueba1@gmail.com   |123456|
   |Prueba Nombre   |Prueba Apellido   |datosprueba2@gmail.com   |123457|
   |Prueba Nombre   |Prueba Apellido   |datosprueba3@gmail.com   |123458|
   |Prueba Nombre   |Prueba Apellido   |datosprueba4@gmail.com   |123459|
   |Prueba Nombre   |Prueba Apellido   |datosprueba5@gmail.com   |123460|
   |Prueba Nombre   |Prueba Apellido   |datosprueba6@gmail.com   |123461|
   |Prueba Nombre   |Prueba Apellido   |datosprueba7@gmail.com   |123462|
   |Prueba Nombre   |Prueba Apellido   |datosprueba8@gmail.com   |123463|
   |Prueba Nombre   |Prueba Apellido   |datosprueba9@gmail.com   |123464|
   |Prueba Nombre   |Prueba Apellido   |datosprueba10@gmail.com   |123465|
   |Prueba Nombre   |Prueba Apellido   |datosprueba11@gmail.com   |123466|
   |Prueba Nombre   |Prueba Apellido   |datosprueba12@gmail.com   |123467|
   |Prueba Nombre   |Prueba Apellido   |datosprueba13@gmail.com   |123468|
   |Prueba Nombre   |Prueba Apellido   |datosprueba14@gmail.com   |123469|


