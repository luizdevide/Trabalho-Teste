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
        driver.findElement(By.xpath("//*[@id=\"formulario-aval\"]/button")).click();
    }
}
