package br.com.gabrielferreira.service;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ArquivoService implements Serializable {

    @Serial
    private static final long serialVersionUID = 537563925647530667L;

    //: FIXME SUBSTITUIR O SYSOUT PARA LOG NESTE METODO
    public void gerarArquivoEscrita(String texto, String saida){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saida, StandardCharsets.UTF_8))){
            bufferedWriter.write(texto);
            System.out.println("Arquivo gerado com sucesso !!");
        } catch (Exception e){
            System.out.println("Ocorreu um erro ao gerar o arquivo : " + e.getMessage());
            e.printStackTrace();
        }
    }

    //: FIXME SUBSTITUIR O SYSOUT PARA LOG NESTE METODO
    public String lerArquivo(String entrada){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(entrada, StandardCharsets.UTF_8))){

            String lerArquivo;
            StringBuilder stringBuilder = new StringBuilder();

            while ((lerArquivo = bufferedReader.readLine()) != null){
                stringBuilder.append(lerArquivo).append("\n");
            }

            return stringBuilder.toString().trim();

        } catch (Exception e){
            System.out.println("Ocorreu erro ao ler o arquivo : " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
