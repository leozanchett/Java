package classes;

import java.io.*;

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
        try(
            BufferedReader br = new BufferedReader(new FileReader(path))
        ){
            return br.readLine();
        }
    }

    // try-with-resources em diversos recursos - rápido e fácil
    static void copy(String src, String dst) throws IOException{
        try(
            InputStream in =  new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)
        ){
            byte[] buf = new byte[100];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }

    // try-with-resources com a clásula catch
    static String FirstLineoFFFile(String path, String defaultVaul){
        try(
            BufferedReader br = new BufferedReader(new FileReader(path)
        )){
            return br.readLine();
        } catch (FileNotFoundException e) {
            return defaultVaul;
        } catch (IOException e) {
            return defaultVaul;
        }
    }

}
