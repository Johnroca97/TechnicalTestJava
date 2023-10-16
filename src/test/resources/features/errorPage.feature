# author: John Rodriguez

Feature: Validar acceso a Web Page con error 500
  @ErrorPage
  Scenario: Acceso a 500 page
    Given Que el usuario accede a la Pagina Sahi Tests
    And Presiona la opcion Error Page
    When Selecciona la opcion 500 Page
    Then Debe ingresar a la pagina 500 Page