package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assign4Webtable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
        driver.get("https://finance.yahoo.com/");
		driver.findElement(By.xpath("//a[@title='Crypto']")).click();
		
		Thread.sleep(3000);

		
		WebElement Scrolldown=driver.findElement(By.xpath("//span[text()='Results List']"));	
		Actions act=new Actions(driver);
		act.scrollToElement(Scrolldown).perform();
		        
		
		Thread.sleep(3000);
		
		//rowcount
        List<WebElement> rowcount=driver.findElements(By.xpath("//table/tbody/tr"));
        int rowsize=rowcount.size();
        System.out.println("Rowcount "+rowsize );
        
        //colcount
		List<WebElement> colcount=driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		
		int colsize=colcount.size();
        System.out.println("Colcount "+colsize );
        
       /* for(int i=1;i<=rowsize;i++)
        {
        	for(int j=1;j<=colsize;j++)
        	{
        		String Rowandcolumnvalue=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.println(Rowandcolumnvalue);
        	}
        }*/
        
        
        for(int i=1;i<=rowsize;i++)
        {
        	
        		String Rowandcolumnvalue=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
                System.out.println(Rowandcolumnvalue);
        	
        }
        


	}

}
