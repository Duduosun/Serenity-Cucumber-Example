package com.sridhar.moviesearch.Tests;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Sridhar on 6/3/2016.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
					  features = { "src/test/resources/features" },
	                  glue     = { "com.softcrylic.moviesearch.Stepdefs" },
	                  tags     = { "@smoke, @regression, @negative, @failing" }
					  //tags     = { "@failing" }
				)
public class testRunner {

}
