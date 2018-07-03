package TestesSelenium;

import java.util.concurrent.TimeUnit;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TesteInterface {
    
    private static String CHROMEDRIVER_LOCATION = "C:\\chromedriver.exe";
   
    WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    @Test
    public void testeCadastraCliente() {
        PaginaCadastraCliente pCC = new PaginaCadastraCliente(driver);
        pCC.abre();
        pCC.cadastraCliente("Luiz Guilherme Teste", "Lucas Teste", "20/06/2018");
        pCC.apertaBotaoCadastrar();
    }
    
    @Test
    public void testeCadastraAvaliacao(){
        PaginaCadastraAvaliacao pCA = new PaginaCadastraAvaliacao(driver);
        pCA.abre();
        pCA.cadastraAvaliacao("20/06/2018", "Luiz Guilherme", "9", "Excelente");
        pCA.apertaBotaoCadastrar();
    }
    
    @Test
    public void testeCadastraClienteIncompleto(){
        PaginaCadastraCliente pCC = new PaginaCadastraCliente(driver);
        pCC.abre();
        pCC.cadastraCliente("", "Lucas Teste", "20/06/2018");
        pCC.apertaBotaoCadastrar();
        WebElement msgErro = driver.findElement(By.cssSelector("input:required"));
    }
    
    @Test
    public void testeCadastraAvaliacaoIncompleto(){
        PaginaCadastraAvaliacao pCA = new PaginaCadastraAvaliacao(driver);
        pCA.abre();
        pCA.cadastraAvaliacao("", "Luiz Guilherme", "5", "Razoavel");
        pCA.apertaBotaoCadastrar();
        WebElement msgErro = driver.findElement(By.cssSelector("input:required"));
    }
    
    @Test
    public void mostraTodasAvaliacoes(){
        PaginaAvaliacoes pA = new PaginaAvaliacoes(driver);
        pA.abre();
        pA.mostraAvaliacoes();
    }
}
