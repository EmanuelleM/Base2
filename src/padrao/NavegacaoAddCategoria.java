package padrao;

import java.awt.AWTException;
import java.awt.HeadlessException;
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

public class NavegacaoAddCategoria {

	public static boolean navegacaoCategoria(WebDriver driver, String usuario, String senha, String categoria, String evidenciaTeste) {

		Calendar data = Calendar.getInstance();
		int h = data.get(Calendar.HOUR_OF_DAY);
        int m = data.get(Calendar.MINUTE);
        int s = data.get(Calendar.SECOND);
		
		String tituloPagina = "Adiciona-categoria - " + h + m + s;
		

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
			
			WebElement pressManageLink = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[7]"));
			pressManageLink.click();
			
			WebElement pressManageProject = driver.findElement(By.xpath("/html/body/div[2]/p/span[1]/a"));
			pressManageProject.click();
			
			
			WebElement fillNameCategory = driver.findElement(By.xpath("/html/body/a/div/table/tbody/tr[7]/td/form/input[3]"));
			fillNameCategory.sendKeys(categoria);
			
			WebElement pressButtonAdd = driver.findElement(By.xpath("/html/body/a/div/table/tbody/tr[7]/td/form/input[4]"));
			pressButtonAdd.click();
			
			

			 NavegacaoLogin.gravaTela(evidenciaTeste, tituloPagina);

			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public static void gravaTela(String evidenciaTeste, String tituloPagina) throws IOException, AWTException {

		String format = "jpg";
		
		
		try {
			Robot robot = new Robot(); 

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, format, new File(evidenciaTeste + "\\" + tituloPagina +"." + format));
			 System.out.println("Screenshot salva!");
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }

	}
}
