@tagsAirlinesyPasajeros
Feature: Obtener todas las aerolíneas

  Como un usuario de la API de aerolíneas
  Quiero obtener la lista de todas las aerolíneas
  Para poder verificar los detalles de las aerolíneas disponibles


  @ObtenerAerolineas
  Scenario: Obtener las aerolineas exitosamente
    Given el actor establece el endpoint para obtener las aerolineas
    When el actor envia una solicitud GET
    Then el codigo de respuesta deberia ser 200


  @CrearAerolinea
  Scenario Outline: Crear una aerolinea exitosamente
    Given el actor establece el endpoint POST para crear una aerolinea
    When el envia una solicitud HTTP POST con el "<_id>" "<name>" "<country>" "<logo>" "<slogan>" "<head_quaters>" "<website>" "<established>"
    Then el codigo de respuesta deberia ser 200
    Examples:
      | _id | name           | country | logo     | slogan                   | head_quaters | website     | established |  |  |
      | 1   | Ramon Castilla | Lima    | lima.png | Miraflores ciudad amable | Miraflores   | flowers.com | 1857        |  |  |
      | 3   | Alfredo Parodi | Lima    | lima.png | Centro financiero        | San Isidro   | isidro.pe   | 1931        |  |  |
      
  @ObtenerAerolineaporId
  Scenario Outline: Obtener aerolinea por id exitoso
    Given el actor establece el endpoint para obtener las aerolineas
    When el actor envia un "<_id>" en una solicitud GET
    Then el codigo de respuesta deberia ser 200
    Examples:
      | _id                                  |  |
      | 73dd5420-3bf9-48f3-a0b6-17cf7aa61b19 |  |

  @ActualizarNombredePasajero
  Scenario Outline: Actualizar el nombre del pasajero exitosamente
    Given el actor establece el endpoint para obtener los pasajeros
    When el envia el id "<_id>" con el nombre "<name>" que se va a modificar
    Then el codigo de respuesta deberia ser 200
    Examples:
      | _id                      | name        |  |
      | 667ab7617ad8fb2f294343a7 | Elias Moran |  |
      | 667ab7677ad8fb440f4343c5 | Jhon Cena   |  |


  @EliminarPasajeromedianteId
  Scenario Outline: Eliminacion correcta del pasajero mediante su Id
    Given el actor establece el endpoint para obtener los pasajeros
    When el envia el id "<_id>" del dicho pasajero que se va a eliminar
    Then el codigo de respuesta deberia ser 200
    Examples:
      | _id                      |  |
      | 667ab7697ad8fb1be24343cf |  |
      | 667ab7667ad8fb23544343c0 |  |
      | 667ab7677ad8fb440f4343c5 |  |
      | 667ab7697ad8fb52294343ca |  |
