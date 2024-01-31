package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assign1Actionmazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String price=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Mobile price "+price );
		
		String customerrating=driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("Mobile price "+customerrating );
		
		driver.findElement(By.xpath("(//div[@class='puisg-col-inner'])[1]")).click();
		
		//to get all the windows opened here(Ctrl+2+L)
				Set<String> WindowHandles = driver.getWindowHandles();
				System.out.println(WindowHandles);

				//convert set into the list
				
				List<String> allwindow=new ArrayList<String>(WindowHandles);// 
				
				//syntax
				driver.switchTo().window(allwindow.get(1));
				System.out.println("Child window name "+driver.getTitle());
		
		//take snapshot
		File src=driver.getScreenshotAs(OutputType.FILE);

		File dst=new File("C:/Files/E_Drive/Users/Testleaf/Eclipse/snap/snapshot.png");
		FileUtils.copyFile(src, dst);
		
		//total
		String total=driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']/span[@class='a-color-price']")).getText();
		
		String Totalreplace = total.replaceAll("[^1-9]", "");
		System.out.println("Before Add to cart" + Totalreplace);
		
		////span[@id='submit.add-to-cart']/span/input[@value='Add to Cart']
		
		
		Thread.sleep(3000);
		////Doubt in click
		
		driver.findElement(By.xpath("(//input[@value='Add to Cart'])[2]")).click();
		
		//WebElement Scrolldown=driver.findElement(By.xpath("(//span[@id='submit.add-to-cart-announce'])[2]"));	
		//Actions act=new Actions(driver);
		//act.scrollToElement(Scrolldown).perform();
		//Scrolldown.click();
		
		//WebElement copy= driver.findElement(By.xpath("(//span[@id='submit.add-to-cart-announce'])[2]"));
	    //driver.executeScript("arguments[0].click()", Scrolldown);//important: Javascript executer is used
		
		
		
		String subtotal=driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("After Add to cart" + subtotal);

		
		String subtotalreplace = subtotal.replaceAll("[^1-9]", "");
		System.out.println("Before Add to cart" + subtotalreplace);
		
		
		if(Totalreplace.equals(subtotalreplace))
		{
			System.out.println("total correctly printed");
		}
		else
		{
			System.out.println("total is not correct");

		}
	
	
	}

}
