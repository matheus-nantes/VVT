package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;

public class frontend extends Application {
    /**
     *
     */
	
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App com Labels e Botões");

        // Crie os labels
        Label label1 = new Label("Nascimento");
        Label label2 = new Label("Categoria");
        Label label3 = new Label("Letalidade");
        Label label4 = new Label("Habitat");
        
        label1.getStyleClass().add("label");
        label2.getStyleClass().add("label");
        label3.getStyleClass().add("label");
        label4.getStyleClass().add("label");



        Button button1 = new Button("Ovíparo");
        Button button2 = new Button("Vivíparo");
        VBox vNascimento = new VBox(10);
        vNascimento.getChildren().addAll(label1, button1, button2);
        
        
        Button buttonAlta = new Button("Alta");
        Button buttonModerada = new Button("Moderada");
        Button buttonBaixa = new Button("Baixa");
        VBox vLetalidade = new VBox(10);
        vLetalidade.getChildren().addAll(label3, buttonAlta, buttonModerada, buttonBaixa);
        
                 
        Button buttonAnfibio = new Button("Anfibio");
        Button buttonAracnideo = new Button("Aracnideo");
        Button buttonAve = new Button("Ave");
        Button buttonCnidario = new Button("Cnidario");
        Button buttonEquinodermo = new Button("Equinodermo");
        Button buttonInseto = new Button("Inseto");
        Button buttonMamifero = new Button("Mamifero");
        Button buttonMolusco = new Button("Molusco");
        Button buttonPeixe = new Button("Peixe");
        Button buttonReptil = new Button("Reptil");
        VBox vCategoria = new VBox(10);
        vCategoria.getChildren().addAll(label2, buttonAnfibio,buttonAracnideo, buttonAve, buttonCnidario, buttonEquinodermo,buttonInseto,buttonMamifero,buttonMolusco,buttonPeixe,buttonReptil);

                   
        Button buttonAlagados = new Button("Alagados");
        Button buttonAntartida = new Button("Antartida");
        Button buttonArtico = new Button("Artico");
        Button buttonCampos = new Button("Campos");
        Button buttonDeserto = new Button("Deserto");
        Button buttonDiversos = new Button("Diversos");
        Button buttonFlorestas = new Button("Florestas");
        Button buttonMontanhas = new Button("Montanhas");
        Button buttonOceano = new Button("Oceano");
        Button buttonRecife = new Button("Recife");
        Button buttonSavana = new Button("Savana");
        Button buttonTropical = new Button("Tropical");
        VBox vHabitat = new VBox(10);
        vHabitat.getChildren().addAll(label4,buttonAlagados,buttonAntartida, buttonArtico, buttonCampos, buttonDeserto, buttonDiversos, buttonFlorestas, buttonMontanhas, buttonOceano, buttonRecife, buttonSavana, buttonTropical);
        

        // HBox: Contêiner horizontal
        HBox hbox = new HBox(5); // Espaçamento de 10px entre os elementos
        hbox.getStyleClass().add("hbox");
        hbox.getChildren().addAll(vNascimento, vLetalidade,vCategoria, vHabitat);


        // BorderPane: Contêiner com regiões (top, bottom, left, right, center)
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);

        // Crie a cena com o layout BorderPane
        Scene scene = new Scene(borderPane, 800, 600);

        // Adicione o arquivo CSS à cena
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        
        adjustFontSize(scene, new Label[]{label1, label2, label3, label4}, new Button[] {button1, button2, buttonAlagados,buttonAlta,buttonAnfibio,buttonAntartida,buttonAracnideo,buttonArtico,buttonAve,buttonBaixa,buttonCampos,buttonCnidario,buttonDeserto,buttonDiversos,buttonEquinodermo,buttonFlorestas,buttonInseto,buttonMamifero,buttonModerada,buttonMolusco,buttonMontanhas,buttonOceano,buttonPeixe,buttonRecife,buttonReptil,buttonSavana,buttonTropical});

        // Defina a cena no palco (stage)
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void adjustFontSize(Scene scene, Label[] labels, Button[] buttons) {
        DoubleBinding fontSizeBinding = Bindings.createDoubleBinding(() -> {
            double fontSize = scene.getWidth() / 25;
            if (fontSize < 10) {
                fontSize = 10;
            }
            else if(fontSize > 20) {
            	fontSize = 20;
            }
            System.out.println(scene.getWidth());
            return fontSize;
        }, scene.widthProperty());

        StringBinding fontSizeString = Bindings.createStringBinding(() -> {
            double fontSize = fontSizeBinding.get();
            return "-fx-font-size: " + fontSize + "px;";
        }, fontSizeBinding);

        for (Label label : labels) {
            label.styleProperty().bind(fontSizeString);
        }

        for (Button button : buttons) {
            button.styleProperty().bind(fontSizeString);
        }
    }

}
