package browsertest;//Create a New Java Project with the Name amazon-test create browserfactory.BaseTest and browsertest.TestSuite
//and add all jars.
//Automate Following Test.
//1. Open the url https://www.amazon.co.uk/
//2. Type "Dell Laptop" in the search box and press enter or click on search
//   Button.
//3. Click on the checkbox brand Dell on the left side.
//4. Verify that the  30(May be different) products are displayed on the page.
//5. Print all product names in the console.
//6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
//Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
//7. Varify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
//Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silve
//5. Close the Browser.

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl ="https://www.amazon.co.uk/";

@Before
    public void setUp(){
    //1. Open the url https://www.amazon.co.uk/
        openBrowser(baseUrl);
    }

@Test
    public void verifyUserCanBrowseProductsSuccessfully() throws InterruptedException {
        Thread.sleep(7000);
        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        clickOnElement(By.xpath("//span[@id='nav-search-submit-text']//input[@id='nav-search-submit-button']"));
        //3. Click on the checkbox brand Dell on the left side.
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        //4. Verify that the  30(May be different) products are displayed on the page.
        List<WebElement> displayedProductList = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Total items :"+displayedProductList.size());
        //5. Print all product names in the console.
        List<WebElement> linksElements = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Total number of links : "+ linksElements.size());
        for( WebElement link : linksElements){
            System.out.println("The links: "+ link.getText());
            System.out.println("The value of attributes : "+ link.getAttribute("class"));
            }
        //6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        //Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
        clickOnElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        //7. Varify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
        //Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver'
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Dell Inspiron 15 3520 Laptop | FHD (1920 x 1080) 120Hz Display')]")).getText();

        String expectedText = "Dell Inspiron 15 3520 Laptop | FHD (1920 x 1080) 120Hz Display | Intel Core i5-1235U | Intel UHD Graphics | 8GB 2666MHz RAM | 512GB SSD | English-UK Keyboard | Carbon black";
        Assert.assertEquals("Error", actualText,expectedText);
        }
        //5. Close the Browser.
        public void tearDown(){
                closeBrowser() ;
        }
}
