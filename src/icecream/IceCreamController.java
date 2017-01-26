package icecream;

import icecream.beans.Card;
import icecream.utils.HttpUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import icecream.beans.IceCream;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author Arturh
 */
public class IceCreamController implements Initializable {
    
    @FXML
    private HBox iceContent;
    
    @FXML
    private Label storeNameLabel;
    
    @FXML
    private TextField selectedIceCreamTF;
    
    @FXML
    private ComboBox<String> sizeCB;
    
    private IceCream currentIceCream;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        String ip = "http://192.168.0.3:8080";
        
        HttpUtil http = new HttpUtil();
        
        String storeName = this.getAttributeObject(
                http, ip + "/name", "store", "name"
        );
        
        JSONArray arrIceCreams = this.getJSONArray(
                http, ip + "/icecream", "icecreams"
        );
        
        JSONArray size = this.getJSONArray(
                http, ip + "/consult/size", "tamanio"
        );
        
        try {
            
            for (int i = 0; i < size.length(); i++) {
                
                this.sizeCB.getItems().add(
                        size.getJSONObject(i).getString("Tamanio")
                );
                
            }
        
            for (int i = 0; i < arrIceCreams.length(); i++) {
                
                JSONObject object = arrIceCreams.getJSONObject(i);
                
                IceCream iceCream = new IceCream(
                        object.getString("Sabor"), 
                        object.getString("Tamanio"), 
                        Double.parseDouble(object.getString("Precio")),
                        object.getString("Decoracion")
                );
                
                Card card = new Card(iceCream);
                
                card.getDescription().setOnAction((ActionEvent event) -> {
                    
                    Parent parent = ((Button) event.getSource()).getParent();
                    
                    Card cardItem = (Card) parent;
                    
                    IceCream $iceCream = cardItem.getIceCream();
                    
                    this.selectedIceCreamTF.setText($iceCream.toString());
                    
                    this.currentIceCream = $iceCream;
                    
                });
                
                iceContent.getChildren().add(card);
                
            }
            
        } catch (JSONException ex) {
            
        }
        
        storeNameLabel.setText(storeName);
        
    }
    
    @FXML
    private void $finalize() {
        
        new Alert(
                Alert.AlertType.INFORMATION,
                "Helado: " + this.currentIceCream +
                "\nTamaño: " + this.sizeCB.getValue()
        ).showAndWait();
        
    }
    
    private String getAttributeObject(HttpUtil http, String url, String object, String attribute) {
        
        try {
            
            JSONObject json = new JSONObject(http.get(url));
            
            return json.getJSONObject(object).getString(attribute);
            
        } catch (JSONException ex) {
            
        }
        
        return null;
    }
    
    private JSONArray getJSONArray(HttpUtil http, String url, String arrObject) {
        
        try {
            
            JSONObject json = new JSONObject(http.get(url));
            
            return json.getJSONArray(arrObject);
            
        } catch (JSONException ex) {
            
            ex.printStackTrace();
            
            return null;
            
        }
        
    }
    
}