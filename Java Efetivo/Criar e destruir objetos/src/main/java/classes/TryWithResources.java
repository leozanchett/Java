package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResources {
    static String firstLineOfFile(String path) throws IOException{
        BufferedReader br = new BufferedReader(Reader.nullReader());
        try {
            return br.readLine();
        }finally {
            br.close();
        }
    }

    // try-with-resources - a melhor maneira de fechar os recursos !
    static String firstLineOfFile2(String path) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }
    

}
