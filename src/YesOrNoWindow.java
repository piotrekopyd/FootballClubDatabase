import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Stack;

public class YesOrNoWindow {
    static boolean answer;

    public static boolean close(String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);

        Label labelMessage = new Label();
        labelMessage.setText(message);


        Button yesButton = new Button("Yes");
        yesButton.setOnAction(s -> {
            answer = true;
            window.close();
        });
        Button noButton = new Button("No");
        noButton.setOnAction(s -> {
            answer = false;
            window.close();
        });

        HBox layout = new HBox(10);
        layout.getChildren().addAll(yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        VBox mainLayout = new VBox(15);
        mainLayout.getChildren().addAll(labelMessage,layout);
        mainLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(mainLayout, 300,150);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
