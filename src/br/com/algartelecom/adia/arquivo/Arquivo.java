package br.com.algartelecom.adia.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.mastersaf.to.Servico_MastersafTO;
import br.com.algartelecom.adia.util.FormataData;

public class Arquivo {
	
	public static void geraArquivo(String path, List<String> conteudoArquivo, String extensao) {
		try {
			
			//TODO: Alterar para pegar o caminho de geração do arquivo da tabela de parametros
			String basePath = "C:\\projetos\\CLOUD-2.0\\"+ path + extensao;
			
			OutputStream os = new FileOutputStream(basePath);
			
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			for (String linhaArquivo : conteudoArquivo) {
				bw.append(linhaArquivo);
				bw.newLine();
			}
			
			bw.close();
			osw.close();
			os.close();
			
		} catch (IOException e) {
			//TODO: Arrumar o tratamento de exceções desse projeto
			e.printStackTrace();
		}
		
	}
	
	public static List<String> lerArquivo(String path) throws IOException{
		
		List<String> conteudoArquivo = new ArrayList<String>();
		File file = new File(path);
		
		if (file.isDirectory()){
			String[] nomesArquivos = file.list();
			for (int i = 0; i <= nomesArquivos.length -1; i++){
				if (nomesArquivos[i].startsWith("ODIN_302_FAT")){
					FileReader fr = new FileReader(new File("C:\\projetos\\CLOUD-2.0\\Integracoes\\Gesplan\\Repositorio\\FATURAMENTO\\" + nomesArquivos[i]));
					BufferedReader br = new BufferedReader( fr );

					while( br.ready() ){
					//lê a proxima linha
					String linha = br.readLine();
					//faz algo com a linha
					conteudoArquivo.add(linha);
					}
				}
			}
			return conteudoArquivo;
		}
		
		
		return conteudoArquivo;
		
	}

}
