package icecream.beans;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Arturh
 */
public class Card extends VBox {
    
    private Button description;
    private ImageView imageView;
    
    private IceCream iceCream;
    
    public Card(IceCream iceCream) {
        
        this.iceCream = iceCream;
        
        super.setAlignment(Pos.TOP_CENTER);
        super.setPrefHeight(160.0);
        super.setPrefWidth(178.0);
        super.setSpacing(15.0);
        
        this.imageView = new ImageView(
                new Image(getClass().getResource(
                        "/icecream/images/icecream.jpg"
                ).toExternalForm())
        );
        
        this.imageView.setFitHeight(146.0);
        this.imageView.setFitWidth(177.0);
        this.imageView.setPickOnBounds(true);
        
        this.description = new Button(iceCream.toString());
        this.description.setPrefWidth(163.0);
        this.description.setPrefHeight(37.0);
        this.description.setFont(Font.font("System", 16.0));
        this.description.setStyle(
                "-fx-background-color:" +
                    "linear-gradient(#f2f2f2, #d6d6d6),\n" +
                    "linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%)," +
                    "linear-gradient(#dddddd 0%, #f6f6f6 50%);" +
                "-fx-background-radius: 8,7,6;" +
                "-fx-background-insets: 0,1,2;" +
                "-fx-text-fill: #e47575;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 5, 0.0, 0, 1);" +
                "-fx-cursor: hand;"
        );
        
        super.getChildren().addAll(this.imageView, this.description);
        
    }

    public Button getDescription() {
        return description;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    @Override
    public String toString() {
        return this.iceCream.toString();
    }
    
}
