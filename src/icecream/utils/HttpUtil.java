package icecream.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author Arturh
 */
public class HttpUtil {

    public HttpUtil() {
        
    }
    
    public String get(String url) {

        String toSend = "";
        
        try {
            
            URL $url = new URL(url);
            HttpURLConnection con = (HttpURLConnection) $url.openConnection();
            
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'GET' request to URL : " + $url);
            System.out.println("Response Code : " + responseCode);
            
            Object[] toArray = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            ).lines().toArray();
            
            for (Object object : toArray) toSend += object.toString() + "\n";
            
        } catch (MalformedURLException | ProtocolException ex) {
            
        } catch (IOException ex) {
            
        }
        
        return toSend;
        
    }
    
}
