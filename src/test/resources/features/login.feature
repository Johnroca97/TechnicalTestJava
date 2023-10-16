# author: John Rodriguez

  Feature: Login
    @LoginExitoso
    Scenario: Login exitoso
      Given Que el usuario accede a la pagina de inicio de sesion
      When Ingresa Username, Password correcto y presiona el boton Login
      Then accede a la pagina de libros disponibles para seleccionar

