package classes_firefox;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencsv.CSVReader;

public class AdicionarProfile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		String file = new File("./arquivos/nome_profile.csv").getCanonicalPath();
		String caminhoEvidencia = "./evidencias/profile";
		CSVReader reader = new CSVReader(new FileReader(file), ';');

		String[] tablelines = null;
		boolean primeiralinha = true;

		List<String> nomeCampos = new ArrayList<String>();
		int contLinhas = 0;

		while ((tablelines = reader.readNext()) != null) {

			if (primeiralinha) {

				for (int i = 0; i < tablelines.length; i++)

				{
					nomeCampos.add(tablelines[i]);
					System.out.println(tablelines[i]);

				}

				primeiralinha = false;
				continue;

			}

			String url = tablelines[0];
			String usuario = tablelines[1];
			String senha = tablelines[2];
			String plataforma = tablelines[3];
			String sistema_op = tablelines[4];
			String versao_sist_op = tablelines[5];
			String cometarios_adicionais = tablelines[6];

			contLinhas++;

			System.out.println(contLinhas);

			boolean resultado_exec;

			resultado_exec = acessaPagina(url);

			if (resultado_exec == true) {

				resultado_exec = padrao.NavegacaoAddProfile.navegacaoAddProf(driver, usuario, senha, plataforma,
						sistema_op, versao_sist_op, cometarios_adicionais, caminhoEvidencia);

			} else {

				System.out.println("A página não carregou =/");

			}
		}

	}

	public static boolean acessaPagina(String url) {
		driver = new FirefoxDriver();
		driver.get(url);

		try {
			driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input"));
			System.out.println("conexão realizada com sucesso");
			return true;
		} catch (Exception e) {
			System.out.println("não há conexão com a pagina solicitada");
			return false;
		}
	}

}
