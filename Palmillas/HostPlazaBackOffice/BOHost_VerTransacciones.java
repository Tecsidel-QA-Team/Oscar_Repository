package HostPlazaBackOffice;

import static org.junit.Assert.*;
import org.openqa.selenium.interactions.Actions;
import PalmillasConfiguration.Settingsfields_File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class BOHost_VerTransacciones extends Settingsfields_File{
	
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
			public void verTransaccionesInit() throws Exception{
				dateverTransacciones = "01/09/2017";
				verTransDate = ranNumbr(0,1); 
				verTransacciones();
				String elementsFound = driver.findElement(By.id("ctl00_ContentZone_tablePager_LblCounter")).getText();						
				String endDate = driver.findElement(By.id(dateET)).getAttribute("value");
				Thread.sleep(1500);
				System.out.println("Hay "+elementsFound.replace(elementsFound.substring(0,24),"")+" transacciones desde la fecha "+dateverTransacciones+" hasta la fehca "+endDate);
				Thread.sleep(1000);	
			}
			
			public static void verTransacciones() throws Exception {
				Actions action = new Actions(driver);
				borrarArchivosTemp("E:\\workspace\\Oscar_Repository\\BOHost_VerTranscciones\\attachments\\");
				try{
					driver.get(BoHostUrl);
					Thread.sleep(1000);
					takeScreenShot("E:\\Selenium\\","loginBOTajPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Oscar_Repository\\BOHost_VerTranscciones\\attachments\\","loginBOTajPage.jpg");	
					loginPage("00001","00001");
					takeScreenShot("E:\\Selenium\\","homeHostTajPage"+timet+".jpeg");
					takeScreenShot("E:\\workspace\\Oscar_Repository\\BOHost_VerTranscciones\\attachments\\","homeHostTajPage.jpeg");	
					Thread.sleep(2000);					
					action.clickAndHold(driver.findElement(By.linkText("Transacciones"))).build().perform();
					action.moveToElement(driver.findElement((By.linkText("Ver transacciones")))).build().perform();					
					if (verTransDate==1){
						driver.findElement(By.linkText("Transacciones de cobro")).click();
						dateFT = "ctl00_ContentZone_controlFilterTransSelection_dateSelector_dt_from_box_date";
						dateET ="ctl00_ContentZone_controlFilterTransSelection_dateSelector_dt_to_box_date";						
					}else{
						driver.findElement(By.linkText("Transacciones sin cobro")).click();
						dateFT= "ctl00_ContentZone_controlFilters_dateSelector_dt_from_box_date";
						dateET="ctl00_ContentZone_controlFilters_dateSelector_dt_to_box_date";
					}
					
					Thread.sleep(1000);					
					takeScreenShot("E:\\Selenium\\","verTransaccionesPage"+timet+".jpeg");
					takeScreenShot("E:\\workspace\\Oscar_Repository\\BOHost_VerTranscciones\\attachments\\","verTransaccionesPage.jpeg");
					Thread.sleep(500);
					driver.findElement(By.id(dateFT)).clear();
					driver.findElement(By.id(dateFT)).sendKeys(dateverTransacciones);
					Thread.sleep(1000);		
					driver.findElement(By.id("ctl00_ButtonsZone_BtnSearch_IB_Button")).click();
					Thread.sleep(2000);
					takeScreenShot("E:\\Selenium\\","verTransaccionesResults"+timet+".jpeg");
					takeScreenShot("E:\\workspace\\Oscar_Repository\\BOHost_VerTranscciones\\attachments\\","verTransaccionesRetults.jepg");
					Thread.sleep(1000);
				
				}catch(Exception e){
					System.out.println(e.getMessage());
					e.printStackTrace();
					fail();
				}
			}		
      	
	}
