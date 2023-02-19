Feature: API Tests
  This feature includes tests that test the exchangeratesapi

  @smokeTest
  Scenario: User is able to check latest currency rates
    When I send GET request with successful data
    Then the response has a 200 response code
    When I send GET request with wrong request data
    Then the response has a 400 response code
    When I send GET request but I am unauthorized to get response data
    Then the response has a 401 response code
    When I send GET request but the endpoint is forbidden to me
    Then the response has a 403 response code
    When I send GET request but the endpoint is not found
    Then the response has a 404 response code