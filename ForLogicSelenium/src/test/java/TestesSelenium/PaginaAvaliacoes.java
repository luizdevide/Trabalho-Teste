/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestesSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author LuizGuilherme
 */
public class PaginaAvaliacoes {
    private WebDriver driver;
    
    public PaginaAvaliacoes(WebDriver driver) {
        this.driver = driver;
    }
    
    public void abre(){
        driver.navigate().to("http://127.0.0.1:5500/");
    }
    
    public void mostraAvaliacoes(){
        driver.findElement(By.id("menu-avalacoes-home")).click();
        driver.findElement(By.id("av-buscar-todos")).click();
    }
    
    public String recebeAvaliador(){
        String avaliador = driver.findElement(By.xpath("//*[@id=\"toRenderAval\"]/tr[1]/th")).getText();
        return avaliador;
    }
}
