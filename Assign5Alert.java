package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign5Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
		Alert Prompt=driver.switchTo().alert();
		Prompt.sendKeys("test");
		Prompt.dismiss();
		String textvalue=driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(textvalue);
		driver.close();

		
	}

}
