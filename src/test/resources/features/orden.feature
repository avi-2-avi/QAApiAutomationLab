Feature: Crear y consultar orden en PetStore

  @ordenPetStore
  Scenario Outline: Crear orden en PetStore

    Given creo la orden con el status "<statusInicial>"
    When obtengo el código de respuesta
    Then el código de respuesta debe ser 200
    And el status de la orden debe ser "<statusFinal>"
    And el body de la respuesta debe estar completo

    Examples:
      | statusInicial | statusFinal |
      | placed        | placed      |

  @ordenPetStore
  Scenario Outline: Consultar orden en PetStore
    Given hago la consulta de la orden con el id "<ordenId>"
    When obtengo el código de respuesta
    Then el código de respuesta debe ser 200
    And el status de la orden debe ser "<statusConsulta>"
    And el body de la respuesta debe estar completo

    Examples:
      | ordenId | statusConsulta |
      | 1       | placed         |
