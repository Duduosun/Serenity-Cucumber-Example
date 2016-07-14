package com.sridhar.moviesearch.Stepdefs;

//import cucumber.api.PendingException;
import com.sridhar.moviesearch.Steps.apiCalls;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Sridhar on 6/3/2016.
 */

public class movieSearchStepdef {
	
	apiCalls api = new apiCalls();

    @Given("I can access OMDB rest api")
    public void api_Setup() throws Throwable {
    	api.initialize_and_check_api();
    } 
    
    @When("I pass movie title as '(.*)'")
    public void i_search_for_movie_title(String name) throws Throwable {
        api.search_title(name);
    }
    
    @When("I pass IMDB ID as '(.*)'")
    public void i_search_for_IMDB_ID(String ID) throws Throwable {
        api.search_withID(ID);
    }

    @Then("I should see Director as '(.*)'")
    public void i_should_see_Director_as(String dir_name) throws Throwable {
    	api.verify_dirName(dir_name);   
    }
    
    @Then("I should see HTTP Status as '(.*)'")
    public void i_should_see_HTTP_status_as(String httpStatus) throws Throwable {
    	api.verify_HttpStatus(httpStatus);
    }
    
    @Then("I should see Title as '(.*)'")
    public void i_should_see_title_as(String title) throws Throwable {
    	api.verify_movieName(title);   
    }

    @Then("I should see Genre as '(.*)'")
    public void i_should_see_Genre_as(String genre) throws Throwable {
    	api.verify_genre(genre);        
    }
    
    
    @Then("I should see error message as '(.*)'")
    public void i_should_see_errorMessage_as(String error) throws Throwable {
    	api.verify_error(error);        
    }
    
    @When("make a call to API")
    public void request_api_for_data() throws Throwable {
    	api.getData();        
    }
    
    @When("I pass year as '(.*)'")
    public void with_released_year_as(String year) throws Throwable {
    	api.set_releaseData(year);        
    }




}
