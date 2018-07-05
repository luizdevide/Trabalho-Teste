package TestesSelenium;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
/**
 *
 * @author LuizGuilherme
 */
public class TesteDaAPI {

    String id;
    
    @BeforeClass
    public static void beforeClass() {
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
    
    @Before
    public void before(){
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> cliente = new HashMap<>();
        cliente.put("data_cad", "2018-06-20T00:00:00Z");
        cliente.put("nome", "Nome Teste");
        cliente.put("nome_responsavel", "Nome Res Teste");
        
        ResponseBody body = given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(cliente).
        when().
                post("customers").getBody();
        
        Cliente resultado = body.as(Cliente.class);
        id = resultado.getId();
    }
    
    @After
    public void after(){
        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                delete("customers?id=" +id);
    }
    
    //Teste Cliente
    @Test
    public void testTemCliente() {
        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                get("customers?id=" +id).
        then()
                .statusCode(200).
                body("nome", is("Nome Teste"));
    }
    
    
    @Test
    public void testAddEDeletaCliente() {
        //Adiciona
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> cliente = new HashMap<>();
        cliente.put("data_cad", "2018-06-20T00:00:00Z");
        cliente.put("nome", "Nome Teste");
        cliente.put("nome_responsavel", "Nome Res Teste");
        
        ResponseBody body = given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(cliente).
        when().
                post("customers").getBody();
        
        Cliente resultado = body.as(Cliente.class);
        String id = resultado.getId();
        
        //Deleta
        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                delete("customers?id=" +id);
    }
    
    
    @Test
    public void testAtualizaCliente() {
        Map<String, String> cliente = new HashMap<>();
        cliente.put("data_cad", "2018-06-20T00:00:00Z");
        cliente.put("nome", "Nome Atualizado");
        cliente.put("nome_responsavel", "Nome Res Atualizado");

        given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(cliente).
        when().
                put("customers?id=" +id).
        then()
                .statusCode(200);    
    }
    
    /*
    //Teste Avaliacao
    @Test
    public void testTemAvaliacao() {
        //Adiciona
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> avaliacao = new HashMap<>();
        avaliacao.put("clienteAvaliador", "-LGHh8QFO8xIz3x-xKNg");
        avaliacao.put("data_avaliacao", "2018-06-20T00:00:00Z");
        avaliacao.put("feedback", "Gostei Muito");
        avaliacao.put("notaAvaliacao", "7");
        
        ResponseBody body = given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(avaliacao).
        when().
                post("evaluations").getBody();
        Avaliacao resultado = body.as(Avaliacao.class);
        String id = resultado.getId();
        //Testa
        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                get("evaluations?id=" +id).
        then()
                .statusCode(200).
                body("feedback", is("Gostei Muito"));
        //Deleta
        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                delete("evaluations?id=" +id);
    }
    
    @Test
    public void testAddEDeletaAvaliacao() {
        //Adiciona
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> avaliacao = new HashMap<>();
        avaliacao.put("clienteAvaliador", "-LGHh8QFO8xIz3x-xKNg");
        avaliacao.put("data_avaliacao", "2018-06-20T00:00:00Z");
        avaliacao.put("feedback", "Gostei Muito");
        avaliacao.put("notaAvaliacao", "7");
        
        ResponseBody body = given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(avaliacao).
        when().
                post("evaluations").getBody();
        
        Avaliacao resultado = body.as(Avaliacao.class);
        String id = resultado.getId();
        
        //Deleta
        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                delete("evaluations?id=" +id);
    }
    
    @Test
    public void testAtualizaAvaliacao() {
        //Adiciona
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> avaliacao = new HashMap<>();
        avaliacao.put("clienteAvaliador", "-LGHh8QFO8xIz3x-xKNg");
        avaliacao.put("data_avaliacao", "2018-06-20T00:00:00Z");
        avaliacao.put("feedback", "Gostei Muito");
        avaliacao.put("notaAvaliacao", "7");
        
        ResponseBody body = given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(avaliacao).
        when().
                post("evaluations").getBody();
        Avaliacao resultado = body.as(Avaliacao.class);
        String id = resultado.getId();
        
        //Atualiza
        avaliacao.put("clienteAvaliador", "-LGHh8QFO8xIz3x-xKNg");
        avaliacao.put("data_avaliacao", "2018-06-20T00:00:00Z");
        avaliacao.put("feedback", "Feedback Atualizado");
        avaliacao.put("notaAvaliacao", "5");

        given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(avaliacao).
        when().
                put("evaluations?id=" +id).
        then()
                .statusCode(200);
        
        //Deleta
        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                delete("evaluations?id=" +id);
    }*/
}
