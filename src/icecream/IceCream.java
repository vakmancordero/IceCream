package icecream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Arturh
 */
public class IceCream extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("IceCreamFXML.fxml"));
        
        Scene scene = new Scene(root);
        
//        String path = "/css/style.css";
//        
//        scene.getStylesheets().add(
//                getClass().getResource(path).toExternalForm()
//        );
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
