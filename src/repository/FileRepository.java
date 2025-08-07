package src.repository;

import java.io.*;

public class FileRepository {
    public void createFile() {
        File fileFormulario = new File("formulario.txt");
        try(FileWriter fw = new FileWriter(fileFormulario, true);
        BufferedWriter bw = new BufferedWriter(fw)) {
            fw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet?(Cachorro/Gato)\n3 - Qual o sexo do animal?\n4 - Qual o endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() {
        File fileFormulario = new File("formulario.txt");
        try(FileReader fr = new FileReader(fileFormulario);
        BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
