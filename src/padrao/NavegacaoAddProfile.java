package padrao;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sun.security.jca.GetInstance;


	public class NavegacaoAddProfile {
	
		
		static WebDriver driver;
		public static boolean navegacaoAddProf(WebDriver driver, String usuario, String senha, String plataforma, String sistema_op, 
				String versao_op, String cometarios_adicionais, String caminhoEvidencia){
			
			Calendar data = Calendar.getInstance();
			int h = data.get(Calendar.HOUR_OF_DAY);
            int m = data.get(Calendar.MINUTE);
            int s = data.get(Calendar.SECOND);
			
		
			String tituloPagina = "Adicionar-Perfil-" + h + m + s;
			
				
			try {
				// localiza o elemento pelo xpath
				WebElement userName = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input"));
				// informa o valor a ser inserido no campo.
				userName.sendKeys(usuario);

				WebElement password = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/input"));
				password.sendKeys(senha);

				WebElement pressRemember = driver
						.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[4]/td[2]/input"));
				// passa a ação que deve ser executada.
				pressRemember.click();

				WebElement pressSecurityCon = driver
						.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[5]/td[2]/input"));
				pressSecurityCon.click();

				WebElement pressButton = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input"));
				pressButton.click();
				
				//Aqui acaba a parte de login
				
				WebElement pressLinkManage = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[7]"));
				pressLinkManage.click();
				
				WebElement pressLinkManageProfile = driver.findElement(By.xpath("/html/body/div[2]/p/span[3]/a"));
				pressLinkManageProfile.click();
				
				//Add profile
				
				WebElement fillPlataform = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input"));
				fillPlataform.sendKeys("x86");
				
							
				WebElement fillOperatingSystem = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/input"));
				fillOperatingSystem.sendKeys(sistema_op);
				
				WebElement fillOsVersion = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[4]/td[2]/input"));
				fillOsVersion.sendKeys(versao_op);
				
				WebElement fillObservacoes = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[5]/td[2]/textarea"));
				fillObservacoes.sendKeys(cometarios_adicionais);
				
				WebElement buttonAddProf = driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td[2]/input"));
				buttonAddProf.click();
				
						
				 NavegacaoLogin.gravaTela(caminhoEvidencia, tituloPagina);

				return true;
			} catch (Exception e) {

				return false;
			}

		}
		
			public static void gravaTela(String caminhoEvidencia, String tituloPagina) 
					throws IOException, AWTException {

				String format = "jpg";
				
				
				try {
					Robot robot = new Robot(); 

					Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
					ImageIO.write(screenFullImage, format, new File(caminhoEvidencia + "\\" + tituloPagina +"."
					+ format));
					 System.out.println("A full screenshot saved!");
		        } catch (AWTException | IOException ex) {
		            System.err.println(ex);
		        }

			}

		}




