Feature: Validate the registration and login functionalities of the demoblaze.com page

  Scenario: Register new user
    Given url baseUrl
    And path '/_next/data/2-4IcbjtcS4ubIbkYsJfb/es/management.json'
    When method get
    Then status 200
    And match response.__N_SSG == true
    # * def actualResponse = response
    # * def expectedResponse = ""
    # * karate.match(actualResponse, expectedResponse)

  # Scenario: Register user has been created
  #   Given url baseUrl
  #   * def validateRequest = read('classpath:request/requestSingUp.json')
  #   And path '/v1/'
  #   And request validateRequest
  #   When method post
  #   Then status 200
  #   And match response.errorMessage == "This user already exist."

  # Scenario: Log in with correct username and password
  #   Given url baseUrl
  #   * def validateRequest = read('classpath:request/requestSingUp.json')
  #   And path '/v1/'
  #   And request validateRequest
  #   When method post
  #   Then status 200
  #   And match response.errorMessage == null

  # Scenario: Log in with incorrect username and password
  #   Given url baseUrl
  #   * def validateRequest = read('classpath:request/BadRequestSingUp.json')
  #   And path '/login'
  #   And request validateRequest
  #   When method post
  #   Then status 200
  #   And match response.errorMessage == "User does not exist."