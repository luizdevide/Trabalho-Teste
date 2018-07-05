package TestesSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 *
 * @author LuizGuilherme
 */
public class PaginaCadastraAvaliacao {
    private WebDriver driver;
    
    public PaginaCadastraAvaliacao(WebDriver driver) {
        this.driver = driver;
    }
    
    public void abre(){
        driver.navigate().to("http://127.0.0.1:5500/");
    }
    
    public void cadastraAvaliacao(String data, String avaliador, String nota, String feedback){
        driver.findElement(By.id("menu-cad-avaliacoes")).click();
        driver.findElement(By.id("mes-avaliacao")).sendKeys(data);
        Select avaliadorOption = new Select(driver.findElement(By.id("select-client")));
        avaliadorOption.selectByVisibleText(avaliador);
        driver.findElement(By.id("nota-avaliacao")).sendKeys(nota);
        driver.findElement(By.id("feedback-avaliacao")).sendKeys(feedback);
    }
    
    public void apertaBotaoCadastrar(){
        driver.findElement(By.xpath("//*[@id=\"formulario-aval\"]/button")).click();
    }
    
    public int camposVazios(){
        int i = 0;
        
        String feedback = driver.findElement(By.id("feedback-avaliacao")).getText();
        String nota = driver.findElement(By.id("nota-avaliacao")).getText();
        String data = driver.findElement(By.id("mes-avaliacao")).getText();
        
        if(nota.isEmpty())
            i++;
        else if(data.isEmpty())
            i++;
        else if(feedback.isEmpty())
            i++;
        
        return i;
    }
    
    public String cadastroSucesso(){
        String msgReal = driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div")).getText();
        
        return msgReal;
    }
}
