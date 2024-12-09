import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
public class App{  
    public static void main( String[] args ) throws IOException{  
                Document doc = Jsoup.connect("https://www.amazon.com/Soothing-Comfort-Deodorant-Anti-Chafing-Defense/dp/B07S1BNNYD/?_encoding=UTF8&pd_rd_w=UtI2a&content-id=amzn1.sym.aeef70de-9e3e-4007-ae27-5dbb7b4a72f6&pf_rd_p=aeef70de-9e3e-4007-ae27-5dbb7b4a72f6&pf_rd_r=PHQWMG2SRM34MDD37QZJ&pd_rd_wg=6JJf8&pd_rd_r=6bd97857-683d-4f17-a761-37a84a437ed2&ref_=pd_hp_d_btf_crs_zg_bs_3375251").get();  
                String title = doc.title();  
                System.out.println("title is: " + title);  
    }  
}  