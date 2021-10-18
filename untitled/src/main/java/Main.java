import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    private static  final String SERVICO_DISPONIVEL = "http://www.nfe.fazenda.gov.br/portal/imagens/bola_verde_P.png";
    private static final String STATUS_SERVICO = "status serviço4";
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
        Elements tr = doc.getElementsByTag("tr");
        Elements statusServico = doc.getElementsByTag("th");
        statusServico.remove(0);
        Integer colunaStatusServico = 0;
        for (Element element: statusServico){
            colunaStatusServico += 1;
            if(element.text().toLowerCase().equals(STATUS_SERVICO)){
                break;
            }
        }
        Integer colunaImgStatusServico = 0;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for (Element element : tr) {
            Elements imgs = element.getElementsByTag("img");
            for (Element img : imgs) {
                colunaImgStatusServico += 1;
                if(colunaImgStatusServico == colunaStatusServico) {
                    colunaImgStatusServico = 0;
                    if(img.absUrl("src").equals(SERVICO_DISPONIVEL)) {
                        System.out.println(String.format("%s serviço disponível: %s", element.select("td").first().text(), formatter.format(date)));
                    }else{
                        System.out.println(img.absUrl("src"));
                        System.out.println(String.format("%s serviço indisponível", element.select("td").first().text(), formatter.format(date)));
                    }
                    System.out.println("=====================================");
                    break;
                }
            }
        }
    }

}
