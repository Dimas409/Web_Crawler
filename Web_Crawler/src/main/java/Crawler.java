
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;

public class Crawler {
    public static void main(String[] args) {
        String url = "https://timeweb.com";
        crawl(1, url, new ArrayList<>());

    }
    private static void crawl(int level, String url, ArrayList<String> visited){
        if(level <= 10) {
            System.out.println(level);
            Document doc = request(url, visited);
            if(doc != null){
                for(Element link: doc.select("a[href]")){
                    String next_link = link.absUrl("href");
                    if(!visited.contains(next_link)){
                        System.out.println(level);
                        crawl(++level, next_link, visited);
                    }
                }
            }
        }
    }

    private static Document request (String url, ArrayList<String> v) {
        try {
            Connection con = Jsoup.connect(url);
            Document doc = con.get();
            if(con.response().statusCode() == 200){
                System.out.println("Link: " + url);
                System.out.println(doc.title());
                v.add(url);
            }
            return null;
        }catch (IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
