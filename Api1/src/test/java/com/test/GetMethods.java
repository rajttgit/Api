package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;  //must be static

import static org.hamcrest.Matchers.*;

public class GetMethods 
{
	@Test (priority = 1)
	public void test1()	//get api response using "given"
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653");
	}
	
	
	@Test (priority = 2)
	public void test2()	//get api response using "when" -- "given" and "when" are interchangeable, except when using parameters. If using parameters you must use "given"
	{
		when()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653");
	}
	
	
	
	
	@Test (priority = 3)
	public void test3()	//assert status code
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().statusCode(200);
	}
		
	
	@Test (priority = 4)
	public void test4()  //Store response as variable then assert status code using "Assert.assertEquals" ("Assert.assertEquals" seems to work even if crossed out)
	{
		Assert.assertEquals
		(
			200 , 
			given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653").statusCode()
		);
	}

	
	
	
	@Test (priority = 5)
	public void test5()  //assert something in body
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().assertThat()
				.body("name", equalTo("New York"));
	}
	
	
	@Test (priority = 6)
	public void test6()  //assert something in body using "containsString"
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().assertThat()
				.body("name", containsString("New"));
	}
	
	
	@Test (priority = 7)
	public void test7()  //assert something in body using "equalToIgnoringCase"
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().assertThat()
				.body("name", equalToIgnoringCase("new york"));
	}
	
	
	
	
	@Test (priority = 8)
	public void test8()  //assert multiple things in body
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().assertThat()
				.body("name", equalTo("New York"))
				.body("base", equalTo("stations"));
	}
	
	@Test (priority = 9)
	public void test9()  //assert multiple things/types in body
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().assertThat()
				.body("name", equalTo("New York"))
				.body("base", equalTo("stations"))
				.body("id", equalTo(420029740));
	}
	
	
	@Test (priority = 10)
	public void test10()  //assert multiple things in body & status code
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().assertThat()
				.body("name", equalTo("New York"))
				.body("base", equalTo("stations"))
				.body("id", equalTo(420029740))
				.statusCode(200);
	}
	
	
	
	
	@Test (priority = 11)
	public void test11()  //print out status code
	{
		System.out.println
		(
			given()
				.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653").statusCode()
		);
	}
	
	
	@Test (priority = 12)
	public void test12()  //print out response data
	{
		System.out.println
		(
			given()
				.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653").asString()
		);
	}
	
	
	@Test (priority = 13)
	public void test13()  //print out status code & response data
	{
		Response resp1 = given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653");
		
		System.out.println(resp1.statusCode());
		System.out.println(resp1.asString());
	}
	
	
	
	
	@Test (priority = 14)
	public void test14()  //print out response as log
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().log().all();
	}
	
	
	@Test (priority = 15)
	public void test15()  //print out only response status code as log
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().log().status();
	}
	
	
	@Test (priority = 16)
	public void test16()  //print out only response body as log
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().log().body();
	}
	
	
	@Test (priority = 17)
	public void test17()  //print out only response status code & body as log
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then()
				.log().status()
				.log().body();
	}
	
	
	
	
	@Test (priority = 18)
	public void test18()  //assert multiple things in body & status code & print out entire log
	{
		given()
			.get("http://api.openweathermap.org/data/2.5/weather?zip=11101&appid=25052499a1c3cc75fe4d18ba7206c653")
			.then().assertThat()
				.body("name", equalTo("New York"))
				.body("base", equalTo("stations"))
				.body("id", equalTo(420029740))
				.statusCode(200)
				.log().all();
	}
	
}