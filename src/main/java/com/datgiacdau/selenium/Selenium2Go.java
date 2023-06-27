/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.datgiacdau.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author DELL
 */
public class Selenium2Go {

    public static void main(String[] args) throws InterruptedException {
        
//cách của mấy a Ấn Độ        
//        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(co);
//        driver.get("https://www.google.com");
//        System.out.println(driver.getTitle());

          searchGoogle();
        
    }

    
    public static void searchGoogle1(){
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*","--incognito");
        opt.addArguments("--lang=zh-cn"); //=vi việt; en-GB: anh; =zh-cn:trung
  
        
        //1. khai báo biến đại diện cho trình duyệt sẽ đc mở/new
        WebDriver myBrowser; //biến object thc thư viên selenuim
                             //thg  này sẽ trở đến cái trình  duyệt khi được new
                             //mỗi lần new là 1 trình duyệt đc mở ra 1 vung ram đc cấp
                             //1 object trình duyệt đc new trong HEAP
        //2. Khai báo ng ae song sinh, gã sẽ điều khiển trình duyệt
        // nó luôn đc phát hành song song vs phiên bản trình duyệt mà bá tánh xài
        //tg thích version vs trình duyệt dang xài. bắt bc
        //web driver là tên gọi ng ae song sinh là  file .exe/.dll
        String driverPath = "chromedriver.exe";
        
        //3. new Trình duyệt (mở) gắn kêt vs ng em song sinh
        System.setProperty("webdriver.chrome.driver", driverPath);
        //giải thích: báo vs máy ảo Java rằng có 1 thg .exe muốn tham gia vào
        //danh sách class mà JVM quản lí
        //.exe, .dll xả 1 đống class điều khiển trình duyệt vào trong JVM lúc run-time
        //và gọi nhóm class này là webdriver.chrome.driver -> hằng số qui ước sẵn r
        //code selenuim qua class webdriver, chromedriver sẽ xài ở dưới đây
        //biết cách chơi vs các class của .exe vừa r, vì chúng đag cùng ở trong mays ảo
        
        myBrowser = new ChromeDriver(opt);
        
        //4.viết code dùng selenium nói ch vs người song sinh - driver
        //driver biết cách nói ch vs trình duyệt thật đã new
        //trình duyệt ss thông qua ng em đưa hết data(trang web trong ram)
        //cho mk dưới dạng cây DOM - document object model
        //trang HTML trả về trong Ram của trình duyệt đc xem là 1 cây các object
        //node/tage đc xem là  1 object thc nhóm webElement
        
        
        myBrowser.get("https://google.com"); //duyệt trang trên object trình duyệt vừa new
        myBrowser.manage().window().maximize();
    }


    public static void searchGoogle() throws InterruptedException{
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
  
        
        //1. khai báo biến đại diện cho trình duyệt sẽ đc mở/new
        WebDriver myBrowser; //biến object thc thư viên selenuim
                             //thg  này sẽ trở đến cái trình  duyệt khi được new
                             //mỗi lần new là 1 trình duyệt đc mở ra 1 vung ram đc cấp
                             //1 object trình duyệt đc new trong HEAP
        //2. Khai báo ng ae song sinh, gã sẽ điều khiển trình duyệt
        // nó luôn đc phát hành song song vs phiên bản trình duyệt mà bá tánh xài
        //tg thích version vs trình duyệt dang xài. bắt bc
        //web driver là tên gọi ng ae song sinh là  file .exe/.dll
        String driverPath = "chromedriver.exe";
        
        //3. new Trình duyệt (mở) gắn kêt vs ng em song sinh
        System.setProperty("webdriver.chrome.driver", driverPath);
        //giải thích: báo vs máy ảo Java rằng có 1 thg .exe muốn tham gia vào
        //danh sách class mà JVM quản lí
        //.exe, .dll xả 1 đống class điều khiển trình duyệt vào trong JVM lúc run-time
        //và gọi nhóm class này là webdriver.chrome.driver -> hằng số qui ước sẵn r
        //code selenuim qua class webdriver, chromedriver sẽ xài ở dưới đây
        //biết cách chơi vs các class của .exe vừa r, vì chúng đag cùng ở trong mays ảo
        
        myBrowser = new ChromeDriver(opt);
        
        //4.viết code dùng selenium nói ch vs người song sinh - driver
        //driver biết cách nói ch vs trình duyệt thật đã new
        //trình duyệt ss thông qua ng em đưa hết data(trang web trong ram)
        //cho mk dưới dạng cây DOM - document object model
        //trang HTML trả về trong Ram của trình duyệt đc xem là 1 cây các object
        //node/tage đc xem là  1 object thc nhóm webElement
        
        
        myBrowser.get("https://google.com"); //duyệt trang trên object trình duyệt vừa new
        myBrowser.manage().window().maximize();
        
        Thread.sleep(3000); //áp nghỉ 3s r chạy tiếp
        myBrowser.quit();
        
        //ta sẽ tìm các ta và hành xử trên các thẻ. các thẻ ày
        //nằm trong object bự là my Browser (là field/đặc tính của object bự)
        WebElement searchBox = myBrowser.findElement(By.name("q"));
        searchBox.sendKeys("GÉT GÔ");
        searchBox.submit();
    }
}
