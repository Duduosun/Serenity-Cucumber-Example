Feature: Movie Search
  In order to get the details on films
  As a normal user
  I want to be able to perform search with OMDB's open API
  
  Background:
    Given I can access OMDB rest api

  @smoke
  Scenario: Movie Search with Title
    When I pass movie title as 'Baasha'
    And make a call to API
    Then I should see HTTP Status as '200' 
    And I should see Director as 'Suresh Krishna'
    And I should see Genre as 'Action, Drama, Thriller'

  @smoke
  Scenario: Movie Search with Title & Year
    When I pass movie title as 'nayakan'
    And I pass year as '1987'
    And make a call to API
    Then I should see HTTP Status as '200' 
    And I should see Director as 'Mani Ratnam'
    And I should see Genre as 'Crime, Drama'

  @negative
  Scenario: Movie Search with Title & Incorrect Year
    When I pass movie title as 'kill bill'
    And I pass year as '2016'
	And make a call to API
    Then I should see HTTP Status as '200' 
    And I should see error message as 'Movie not found!'

  @smoke
  Scenario: Movie Search with IMBD ID
    When I pass IMDB ID as 'tt1285016'
    And make a call to API
    Then I should see HTTP Status as '200'
    And I should see Title as 'The Social Network'
    And I should see Genre as 'Biography, Drama'

  @failing
  Scenario: Movie Search with IMBD ID (Failed Intentionally)
    When I pass IMDB ID as 'tt1285016'
    And make a call to API
    Then I should see HTTP Status as '201'
    And I should see Title as 'The Scientific Network'
    And I should see Genre as 'Biography, Drama'

  @regression
  Scenario Outline: Search with Title
    When I pass movie title as '<Name>'
    And make a call to API
    Then I should see HTTP Status as '200'
    And I should see Genre as '<Genre>'
    Examples:
      | Name                     | Genre                        |
      | now you see me           | Crime, Mystery, Thriller     |
      | zootopia                 | Animation, Action, Adventure |
      | toy story                | Animation, Adventure, Comedy |
      | The Shawshank Redemption | Crime, Drama                 |



