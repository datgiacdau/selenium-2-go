/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.datgiacdau.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 *
 * @author DELL
 */
public class Guru99Test {
    
    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";
    
    
    @BeforeAll
    public static void setUpClass() {
       
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        myBrowser = new ChromeDriver(opt);
         
        myBrowser.manage().window().maximize();
    }
    @Test
    public void testLoginGivenRightAcocountSaysHelloUserName() throws InterruptedException{
        String userName = "mngr510990";
        String pass = "EtYbujY";
        myBrowser.get("https://demo.guru99.com/v4/");
        
        //tìm thẻ user và pass qua css seclector, name , jquery,... tùy
        //là 1 dạng câu sql áp dụng cho html/css
        //đưa câu query này cho myBrowser để tìm
        //nếu tìm thấy thẻ thì đó là  1 object đc trả về thuộc class WebElement
        WebElement userTag = myBrowser.findElement(By.xpath("(//input[@name='uid'])[1]"));
        userTag.sendKeys(userName); //gõ vào text nếu thấy
        WebElement passTag = myBrowser.findElement(By.cssSelector("input[name=\"password\"]"));
        passTag.sendKeys(pass);
        WebElement loginTag = myBrowser.findElement(By.xpath("(//input[@name='btnLogin'])[1]"));
        loginTag.click();
        
        Thread.sleep(3000); //cần chờ chuyển trang do mạng hoặc front end
                                   // cần đợi để ra trang mới vì nó đag ở trang cũ
                                   //còn trang mới chưa kịp lên nên cần wait
        
        WebElement helloTag = myBrowser.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        //lấy đc cái <td> chứa câu xin chào, lấy thử xem
        //System.out.println("Hello Msg after login successfully:" +
         //                       helloTag.getText());
        String actualHelloMsg = helloTag.getText();
        assertEquals("Manger Id : " + userName, actualHelloMsg);
        
        Thread.sleep(5000);
        
    }
    
    
    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit(); //dọn rác undo khi @Test đã chạy
    }
    
}
