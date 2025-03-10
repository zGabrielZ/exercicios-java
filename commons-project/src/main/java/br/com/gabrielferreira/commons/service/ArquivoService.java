package br.com.gabrielferreira.commons.service;
import br.com.gabrielferreira.commons.exception.ErroInesperadoException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import static br.com.gabrielferreira.commons.utils.LogUtils.*;

public class ArquivoService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    public void gerarArquivoEscrita(String texto, String saida){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saida, StandardCharsets.UTF_8))){
            bufferedWriter.write(texto);
            gerarLogInfo("Arquivo gerado com sucesso !!");
        } catch (Exception e){
            gerarLogWarn("Ocorreu um erro ao gerar o arquivo : {}", e);
            throw new ErroInesperadoException("Ocorreu um erro ao gerar o arquivo");
        }
    }

    public String lerArquivo(String entrada){
        InputStream inputStream = buscarCaminho(entrada);

        if(inputStream == null){
            return lerArquivoSemInput(entrada);
        }

        return lerArquivoComInput(inputStream);
    }
    public InputStream buscarCaminho(String entrada){
        try {
            ClassLoader classLoader = ArquivoService.class.getClassLoader();
            return classLoader.getResourceAsStream(entrada);
        } catch (Exception e){
            gerarLogWarn("Ocorreu erro ao buscar arquivo. Causa : {}", e);
            throw new ErroInesperadoException("Arquivo não encontrado");
        }
    }

    private String lerArquivoSemInput(String entrada){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(entrada, StandardCharsets.UTF_8))){

            String lerArquivo;
            StringBuilder stringBuilder = new StringBuilder();

            while ((lerArquivo = bufferedReader.readLine()) != null){
                stringBuilder.append(lerArquivo).append("\n");
            }

            return stringBuilder.toString().trim();

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro ao ler o arquivo : {}", e);
            throw new ErroInesperadoException("Ocorreu um erro ler o arquivo");
        }
    }

    private String lerArquivoComInput(InputStream inputStream){
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){

            String lerArquivo;
            StringBuilder stringBuilder = new StringBuilder();

            while ((lerArquivo = bufferedReader.readLine()) != null){
                stringBuilder.append(lerArquivo).append("\n");
            }

            return stringBuilder.toString().trim();

        } catch (Exception e){
            gerarLogWarn("Ocorreu erro ao ler o arquivo : {}", e);
            throw new ErroInesperadoException("Ocorreu um erro ler o arquivo");
        }
    }
}
