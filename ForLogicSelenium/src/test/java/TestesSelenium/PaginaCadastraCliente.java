package TestesSelenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author LuizGuilherme
 */
public class PaginaCadastraCliente {
    
    private WebDriver driver;
 
    public PaginaCadastraCliente(WebDriver driver) {
        this.driver = driver;
    }
    
    public void abre(){
        driver.navigate().to("http://127.0.0.1:5500/");
    }
    
    public void cadastraCliente(String cliente, String responsavel, String data){
        driver.findElement(By.id("menu-cad-clientes")).click();
        driver.findElement(By.id("cliente-nome")).sendKeys(cliente);
        driver.findElement(By.id("nome-contato")).sendKeys(responsavel);
        driver.findElement(By.id("cliente-data")).sendKeys(data);
    }
    
    public void apertaBotaoCadastrar(){
        driver.findElement(By.xpath("//*[@id=\"formulario-contato\"]/button")).click();
    }
    
    public String cadastroSucesso(){
        String msgReal = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div")).getText();
        
        return msgReal;
    }
}
