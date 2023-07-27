package br.com.gabrielferreira.service;
import java.io.*;
import java.nio.charset.StandardCharsets;
import static br.com.gabrielferreira.utils.LogUtils.*;

public class ArquivoService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    public void gerarArquivoEscrita(String texto, String saida){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saida, StandardCharsets.UTF_8))){
            bufferedWriter.write(texto);
            gerarLogInfo("Arquivo gerado com sucesso !!");
        } catch (Exception e){
            gerarLogWarn("Ocorreu um erro ao gerar o arquivo : {}", e);
        }
    }

    public String lerArquivo(String entrada){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(entrada, StandardCharsets.UTF_8))){

            String lerArquivo;
            StringBuilder stringBuilder = new StringBuilder();

            while ((lerArquivo = bufferedReader.readLine()) != null){
                stringBuilder.append(lerArquivo).append("\n");
            }

            return stringBuilder.toString().trim();

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro ao ler o arquivo : {}", e);
        }

        return null;
    }
}
