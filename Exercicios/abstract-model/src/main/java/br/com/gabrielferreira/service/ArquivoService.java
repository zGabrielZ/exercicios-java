package br.com.gabrielferreira.service;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ArquivoService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    public void gerarArquivoEscrita(String texto, String saida){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saida, StandardCharsets.UTF_8))){
            bufferedWriter.write(texto);
            log.info("Arquivo gerado com sucesso !!");
        } catch (Exception e){
            log.warn("Ocorreu um erro ao gerar o arquivo : {}", e.getMessage());
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
            log.warn("Ocorreu erro ao ler o arquivo : {}", e.getMessage());
        }

        return null;
    }
}
