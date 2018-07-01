package TestesSelenium;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.specification.ProxySpecification;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.BeforeClass;
/**
 *
 * @author LuizGuilherme
 */
public class TesteDaAPI {
    
    @BeforeClass
    public static void beforeClass() {    
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
    
    /*@Test
    public void testTemCliente() {
        when().
                get("http://desafio4devs.forlogic.net/api/customers/projeto-teste-b2928").
        then()
                .statusCode(200).
                body("name", is("Luiz Guilherme"));
    }*/
}
