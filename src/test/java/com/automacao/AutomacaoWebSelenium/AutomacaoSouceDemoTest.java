package com.automacao.AutomacaoWebSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


class AutomacaoSouceDemoTest {

    private WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testSauceDemoFlow() throws InterruptedException {
        abrirPagina();
        realizarLogin("standard_user", "secret_sauce");
        adicionarAoCarrinho();
        removerDoCarrinho();
        acessarCarrinho();
    }

    public void abrirPagina() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }

    public void realizarLogin(String username, String password) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys(username);
        Thread.sleep(1000);


        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);
        Thread.sleep(1000);


        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(2000);
    }

    public void adicionarAoCarrinho() throws InterruptedException {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartButton.click();
        Thread.sleep(2000);
    }

    public void removerDoCarrinho() throws InterruptedException {
        WebElement removeButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
        removeButton.click();
        Thread.sleep(2000);
    }

    public void acessarCarrinho() throws InterruptedException {
        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();
        Thread.sleep(2000);
    }
    @AfterEach
    public void teardown() {
        fecharPagina();
    }

    public void fecharPagina() {
        if (driver != null) {
            driver.quit();
        }
    }
}