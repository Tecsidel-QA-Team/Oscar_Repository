package HostPlazaBackOffice;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PalmillasConfiguration.Settingsfields_File;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class BOPlaza_Liquidacion extends Settingsfields_File {
		private static Statement stmt;
		private static String transSearch;
		private static ResultSet rs;
		public static int i;
		private static String queryString;
		private static ArrayList<String> transactionsHIds = new ArrayList<String>();
		private static ArrayList<String> transactionsPIds = new ArrayList<String>();	
		private static String Hour1;
		private static String Min1;
		private static String Sec1;

		@Before
		public void setUp() throws Exception{
    		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
    			/*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
    			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true
    			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
    				//ChromeOptions opts =  new ChromeOptions(); poner esta opción cuando se vaya a subir a Git
    				//opts.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); poner esta opción cuando se vaya a subir a Git
    				driver = new ChromeDriver();//opts); poner esta opción cuando se vaya a subir al Git
    				//driver.manage().window().maximize();	
    				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			}
		
		@After
		public void tearDown() throws Exception{			  
			    driver.quit();
			    String verificationErrorString = verificationErrors.toString();
			    if (!"".equals(verificationErrorString)) {
			      fail(verificationErrorString);
			    }
			  
		}
		

		
		@Test		
		public void Liquidacion() throws Exception{		
			Actions action = new Actions(driver);
			borrarArchivosTemp("E:\\workspace\\Oscar_Repository\\BOPlaza_Liquidacion\\attachments\\");
			try{
				driver.get(BoPlazaUrl);
				Thread.sleep(1000);
				takeScreenShot("E:\\Selenium\\","loginPlazaPalPage"+timet+".jpg");
				takeScreenShot("E:\\workspace\\Oscar_Repository\\BOPlaza_Liquidacion\\attachments\\","loginPlazaPalPage.jpg");				
				loginPage("00001","00001");
				takeScreenShot("E:\\Selenium\\","homePlazaPage"+timet+".jpeg");
				takeScreenShot("E:\\workspace\\Oscar_Repository\\BOPlaza_Liquidacion\\attachments\\","homePlazaPage.jpeg");	
				Thread.sleep(2000);					
				String PlazaVersion = driver.findElement(By.id("ctl00_statusRight")).getText();;
				action.clickAndHold(driver.findElement(By.linkText("Gestión de supervisor"))).build().perform();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Liquidación")).click();
				Thread.sleep(2000);
				takeScreenShot("E:\\Selenium\\","LiquidacionPage"+timet+".jpeg");
				takeScreenShot("E:\\workspace\\Oscar_Repository\\BOPlaza_Liquidacion\\attachments\\","LiquidacionPage.jpeg");
				selectDropDown("ctl00_ContentZone_companyPlazaLane_cmb_plaza_cmb_dropdown");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_txt_Seal_box_data")).sendKeys(ranNumbr(1,1000)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_txt_seal_shared_box_data")).sendKeys(ranNumbr(1,100)+"");
				Thread.sleep(300);
				selectDropDown("ctl00_ContentZone_cmb_shiftGroup_cmb_dropdown");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01N20000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01N20000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01N10000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01N10000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01N5000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01N5000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01N2000_1")).sendKeys(ranNumbr(1,6)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01N2000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01N1000_1")).sendKeys(ranNumbr(1,8)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01N1000_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01N500_1")).sendKeys(ranNumbr(1,10)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01N500_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01C100_1")).sendKeys(ranNumbr(1,30)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01C100_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01N100_1")).sendKeys(ranNumbr(1,20)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01N100_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01C50_1")).sendKeys(ranNumbr(1,100)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01C50_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01C25_1")).sendKeys(ranNumbr(1,200)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01C25_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01C10_1")).sendKeys(ranNumbr(1,300)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01C10_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01C5_1")).sendKeys(ranNumbr(1,500)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01C5_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberCASH01C1_1")).sendKeys(ranNumbr(1,1000)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberSharedCASH01C1_1")).sendKeys(ranNumbr(1,4)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberVO0101")).sendKeys(ranNumbr(1,5)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberVO010102")).sendKeys(ranNumbr(1,5)+"");
				Thread.sleep(100);
				driver.findElement(By.id("ctl00_ContentZone_NumberVO01010210")).sendKeys(ranNumbr(1,5)+"");
				Thread.sleep(500);
				elementClick("ctl00_ContentZone_BtnCalculate");
				Thread.sleep(1000);
				takeScreenShot("E:\\Selenium\\","DataFilled"+timet+".jpeg");
				takeScreenShot("E:\\workspace\\Oscar_Repository\\BOPlaza_Liquidacion\\attachments\\","DataFilled.jpeg");
				elementClick("ctl00_ButtonsZone_BtnSubmit_IB_Label");
				Thread.sleep(5000);
				if (isAlertPresent()){
					driver.switchTo().alert().accept();
				}
				Thread.sleep(5000);
				String title = driver.findElement(By.id("ctl00_SectionZone_LblTitle")).getText();
				if (title.equals("Liquidación final de supervisión")){
					String errorLabel = driver.findElement(By.id("ctl00_LblError")).getText();
					if (errorLabel.contains("Nº Bolsa: El valor introducido ya existe") || errorLabel.contains("La operación ha fallado por un error desconocido") || errorLabel.contains("Sello inválido") || errorLabel.contains("Plaza inválida")){
						takeScreenShot("E:\\Selenium\\","lidquidacionErr"+timet+".jpeg");
						takeScreenShot("E:\\workspace\\Oscar_Repository\\BOPlaza_Liquidacion\\attachments\\","lidquidacionErr.jpeg");
						fail("No se puede crear liquidación debido a un error: "+errorLabel);
						return;
					}
					
				}
				
				
			}catch (Exception e){
				System.out.println(e.getMessage());
				fail();
			}
				
		}
		
		public static boolean isAlertPresent() throws Exception
		{
			driver.switchTo().alert();
			return true;
		}
		
		
	
}
