# author: John Rodriguez

Feature: Validar que la suma total a pagar sea correcta
  @TotalCorrecto
  Scenario: Valor a pagar correcto
    Given Que el usuario realizo inicio de sesion con sus credenciales
    When Agregue a la canasta de libros: 3 core Java, 5 ruby for rail y 2 Python cookbook
    Then La suma total a pagar debe ser correcta