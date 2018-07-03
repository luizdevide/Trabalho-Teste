package TestesSelenium;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.ProxySpecification;
import java.util.HashMap;
import java.util.Map;
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

    //Teste Cliente
    @Test
    public void testTemCliente() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                get("customers?id=-LGHh8QFO8xIz3x-xKNg").
        then()
                .statusCode(200).
                body("nome", is("Luiz Guilherme "));
    }
    
    @Test
    public void testAddCliente() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> cliente = new HashMap<>();
        cliente.put("data_cad", "2018-06-20T00:00:00Z");
        cliente.put("nome", "Nome Add API");
        cliente.put("nome_responsavel", "Nome Res Add API");

        given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(cliente).
        when().
                post("customers").
        then()
                .statusCode(201);
    }
    
    @Test
    public void testAtualizaCliente() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> cliente = new HashMap<>();
        cliente.put("data_cad", "2018-06-20T00:00:00Z");
        cliente.put("nome", "Nome Atualizado");
        cliente.put("nome_responsavel", "Nome Res Atualizado");

        given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(cliente).
        when().
                put("customers?id=-LGJJFGFvnrl3csuc4nd").
        then()
                .statusCode(200).
                body("nome", is("Nome Atualizado"));
    }

    @Test
    public void testDeletaCliente() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                delete("customers?id=-LGJJFGFvnrl3csuc4nd").
        then()
                .statusCode(200);
    }
    
    //Teste Avaliacao
    @Test
    public void testTemAvaliacao() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                get("evaluations?id=-LGJC9_aqrPiUEknNCNd").
        then()
                .statusCode(200).
                body("feedback", is("Excelente"));
    }
    
    @Test
    public void testAddAvaliacao() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> avaliacao = new HashMap<>();
        avaliacao.put("clienteAvaliador", "-LGHh8QFO8xIz3x-xKNg");
        avaliacao.put("data_avaliacao", "2018-06-20T00:00:00Z");
        avaliacao.put("feedback", "Gostei Muito");
        avaliacao.put("notaAvaliacao", "7");

        given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(avaliacao).
        when().
                post("evaluations").
        then()
                .statusCode(201);
    }
    
    @Test
    public void testAtualizaAvaliacao() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        Map<String, String> avaliacao = new HashMap<>();
        avaliacao.put("clienteAvaliador", "-LGHh8QFO8xIz3x-xKNg");
        avaliacao.put("data_avaliacao", "2018-06-20T00:00:00Z");
        avaliacao.put("feedback", "Feedback Atualizado");
        avaliacao.put("notaAvaliacao", "5");

        given().
                header("Authorization", "projeto-teste-b2928").
                contentType(ContentType.JSON).
                body(avaliacao).
        when().
                put("evaluations?id=-LGO6vlf7smhlv9Tlw66").
        then()
                .statusCode(200).
                body("feedback", is("Feedback Atualizado"));
    }
    
    @Test
    public void testDeletaAvaliacao() {
        baseURI = "http://desafio4devs.forlogic.net/api/";

        given().
                header("Authorization", "projeto-teste-b2928").
        when().
                delete("evaluations?id=-LGJJFGFvnrl3csuc4nd").
        then()
                .statusCode(200);
    }
}
