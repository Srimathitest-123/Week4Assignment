package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assign3ActionSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.snapdeal.com/");
		WebElement mouseOver = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(mouseOver).perform();
		
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		String shoecount=driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Shoe count "+shoecount );
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		
		//Set<WebElement> unique=new LinkedHashSet<WebElement>();
		
		//Before sort price action store the values in List, then store in Set
		
		List<WebElement> Beforesort = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		Set<Integer> unique=new LinkedHashSet<Integer>();//insertion order
		String temps;
		int tempint;
		
		for(WebElement sort:Beforesort)
		{
			//System.out.println(sort.getText());
			temps=sort.getText().replaceAll("[^1-9]", "");
			tempint=Integer.parseInt(temps);
			unique.add(tempint);
			//unique.add(sort.getText().replaceAll("[^1-9]", ""));
		}

		List<Integer> getValue=new ArrayList<Integer>(unique);
		Collections.sort(getValue);
		
		for(Integer sort1:getValue)
		{
			System.out.println("Before sort"+sort1);
		}

				
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		
		List<WebElement> Listvalues = driver.findElements(By.xpath("//ul[@class='sort-value']/li"));
		String value="Low to High";
		for(WebElement e : Listvalues)
		{

			if(e.getText().equalsIgnoreCase("Price Low to High"))// doubt
				//if(e.getText().contains("Low to High"))
			{

			e.click(); 
			}
		}
		
		Thread.sleep(3000);
	
		WebElement Scrolldown=driver.findElement(By.xpath("//div[@class='lfloat marR10']/span[@class='lfloat product-price']"));	
		act.scrollToElement(Scrolldown).perform();
		
		//After sort price action store the values in List, then store in Set

		
		List<WebElement> shoevalues = driver.findElements(By.xpath("//div[@class='lfloat marR10']/span[@class='lfloat product-price']"));
		
		//Set<WebElement> unique2=new LinkedHashSet<WebElement>(shoevalues);
		Set<Integer> unique2=new LinkedHashSet<Integer>();
		int a;
		String s;
		
		for(WebElement shoeprice:shoevalues)
		{
			//System.out.println("shoe value"+ shoeprice.getText());
			s=shoeprice.getText().replaceAll("[^1-9]", "");
			a=Integer.parseInt(s);
			unique2.add(a);
			//unique2.add(shoeprice.getText().replaceAll("[^1-9]", ""));
		}
		
		List<Integer> getValue2=new ArrayList<Integer>(unique2);
		Collections.sort(getValue2);

		
		for(Integer printval:getValue2)
		{
			System.out.println("Print value after stored in set"+ printval);
		}
		
		//Check if the displayed items are sorted correctly.
		int tempcompare1;
		int tempcompare2;
		
		for(int i=0;i<getValue.size();i++)
		{
			tempcompare1=getValue.get(i);
			tempcompare2=getValue2.get(i);
			
			if(tempcompare1== tempcompare2)
			{
				System.out.println("Both price are matching"+ getValue2.get(i));
				tempcompare1=0;
				tempcompare2=0;

			}
		}
		
		//Select any price range ex:(500-700).
		
		WebElement Pricefrom=driver.findElement(By.xpath("//input[@name='fromVal']"));	
		act.scrollToElement(Pricefrom).perform();
		Pricefrom.clear();
		Pricefrom.sendKeys("500");
		
		WebElement Priceto=driver.findElement(By.xpath("//input[@name='toVal']"));	
		act.scrollToElement(Priceto).perform();
		Priceto.clear();
		Priceto.sendKeys("700");
		
		Thread.sleep(3000);
		
		//xpath not identified
		//WebElement color=driver.findElement(By.xpath("//div[@data-name='Color_s']/div/label[@for='Color_s-Assorted']"));
		WebElement color=driver.findElement(By.xpath("(//div[@data-name='Color_s']/div/label)[1]"));
		act.scrollToElement(color).perform();
		String colorname=driver.findElement(By.xpath("(//div[@data-name='Color_s']/div/label/a)[1]")).getText();
		color.click();
		
		
		String verifycolour=driver.findElement(By.xpath("(//div[@class='navFiltersPill']/a)[1]")).getText();
		
		if(colorname.equalsIgnoreCase(verifycolour))// doubt
			
		{
			System.out.println("Colour is matching");

		}
		else
		{
			System.out.println("Colour is not matching");

		}
		
		Thread.sleep(3000);
		WebElement image=driver.findElement(By.xpath("//span[@class='lfloat product-price']"));
		act.scrollToElement(image).perform();

WebElement mouseOver1 = driver.findElement(By.xpath("//img[@title='ASIAN Black Training Shoes']"));
		
		
		act.moveToElement(mouseOver1).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		String price1=driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println(price1);
		
		String Discount=driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(Discount);

		WebElement shoe=driver.findElement(By.xpath("//img[@itemprop=\"image\"]"));
		
		File src=shoe.getScreenshotAs(OutputType.FILE);

		File dst=new File("C:/Files/E_Drive/Users/Testleaf/Eclipse/snap/snapshot.png");
		FileUtils.copyFile(src, dst);
		
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();


	}

}
