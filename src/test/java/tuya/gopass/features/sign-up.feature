@smoke
Feature: Prueba API

  # Scenario: List users page 2
  #   Given url baseUrl
  #   And path '/api/users'
  #   And param page = 2
  #   When method get
  #   Then status 200
  #   And match response.page == 2

Scenario: Register new user
  Given url baseUrl
  And path '/_next/data/x0lYyFVSD0-XGk8UbMI3m/es/management.json'
  When method get
  Then status 403
  # And match response.__N_SSG == true
