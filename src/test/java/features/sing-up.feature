Feature: Prueba API

  Scenario: List users page 2
    Given url baseUrl
    And path '/api/users'
    And param page = 2
    And header User-Agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'
    When method get
    Then status 200
    And match response.page == 2