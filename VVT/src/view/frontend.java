package view;

import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXMLLoader;

public class frontend extends Application {
    /**
     *
     */
	
	Circle[] nos = new Circle[31];
    Line[] arestas = new Line[30];
    Label[] nomes = new Label[16];
    Label[] respostas = new Label[30];
    Label[] questoes = new Label[4];
    Boolean carnivoro = null, venenoso = null, patas = null, aquatico = null;
    RadioButton carnivoroS, carnivoroN, venenosoS, venenosoN, patasS, patasN, aquaticoS, aquaticoN;
    Button selecionar;
    Label warning;
	
    /**
     *
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GFC - Animais");


        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        Parent  root = null; 
       //Carregar janela 
        try {
          root = loader.load();
          primaryStage.setScene(new Scene(root, 1920,1000));
          primaryStage.sizeToScene();
          primaryStage.show();
        } catch (IOException e) {
          System.err.println("Error reading file: " + e.getMessage());
        }
        Scene scene = primaryStage.getScene();
        
        //ATRIBUIÇÃO DE TODOS ELEMENTOS GRÁFICOS
        for(int i = 0; i < 30; i++) {
        	if(i < 4)
        		questoes[i] = (Label) scene.lookup("#q"+i);
        	nos[i] = (Circle) scene.lookup("#n"+i);
        	arestas[i] = (Line) scene.lookup("#a"+i);
        	respostas[i] = (Label) scene.lookup("#r"+i);
        	if(i > 14)
        		nomes[i-15] = (Label) scene.lookup("#l"+i);
        } 
        nos[30] = (Circle) scene.lookup("#n30");
        nomes[15] = (Label) scene.lookup("#l30");
        
        carnivoroS = (RadioButton) scene.lookup("#carnivoroS");
        carnivoroN = (RadioButton) scene.lookup("#carnivoroN");
        
        venenosoS = (RadioButton) scene.lookup("#venenosoS");
        venenosoN = (RadioButton) scene.lookup("#venenosoN");
        
        patasS = (RadioButton) scene.lookup("#pataS");
        patasN = (RadioButton) scene.lookup("#pataN");
        
        aquaticoS = (RadioButton) scene.lookup("#aquaticoS");
        aquaticoN = (RadioButton) scene.lookup("#aquaticoN");

        carnivoroS.setOnAction(event -> carnivoro = true);
        carnivoroN.setOnAction(event -> carnivoro = false);
        
        venenosoS.setOnAction(event -> venenoso = true);
        venenosoN.setOnAction(event -> venenoso = false);
        
        patasS.setOnAction(event -> patas = true);
        patasN.setOnAction(event -> patas = false);
        
        aquaticoS.setOnAction(event -> aquatico = true);
        aquaticoN.setOnAction(event -> aquatico = false);
       
        selecionar = (Button) scene.lookup("#btnSelecionar");
        warning = (Label) scene.lookup("#warning");
        
        //Executar código e retornar graficamente as decisões
        selecionar.setOnAction(event ->{
        	if(carnivoro == null || venenoso == null || patas == null || aquatico == null)
        		warning.setVisible(true);
        	else {
        		warning.setVisible(false);
        		
        		//limpa cominho
        		for(int i = 0; i < 15; i++) 
	        	   nos[i].setFill(javafx.scene.paint.Paint.valueOf("#514442"));
        		for(int i = 0; i <arestas.length; i++)
        			arestas[i].setStroke(javafx.scene.paint.Paint.valueOf("#514442"));
        		
        		AnimalFrontend animal = new AnimalFrontend();
            	int indice = getIndice(animal.retornarAnimal(carnivoro, venenoso, patas, aquatico));
            	int[] caminho = getCaminho(indice+15);
            	
            	
            	Circle[] nosCaminho = new Circle[5];
            	
            	Line[] arestasCaminho = new Line[4];
            	
            	Label[] respostasCaminho = new Label[4];
            	
            	for(int i = 0; i < caminho.length - 1;i++) {
            		nosCaminho[i] = nos[caminho[i]];
            		arestasCaminho[i] = arestas[caminho[i+1]-1];
            		respostasCaminho[i] = respostas[caminho[i+1]-1];
            	}
            	nosCaminho[4] = nos[caminho[4]];
            	animar(nosCaminho, arestasCaminho, respostasCaminho, nomes[caminho[4]-15]);
        	}
        });
        
    }
    
    public int getIndice(String nome) {
    	String[] nomes = new String[16];
    	nomes[0] = "Lesma";
    	nomes[1] = "Peixe Boi";
    	nomes[2] = "Boi";
    	nomes[3] = "Camarão";
    	nomes[4] = "Taturana";
    	nomes[5] = "Anêmona";
    	nomes[6] = "Sapo";
    	nomes[7] = "Tritão";
    	nomes[8] = "Python";
    	nomes[9] = "Moreia";
    	nomes[10] = "Tigre";
    	nomes[11] = "Polvo";
    	nomes[12] = "Naja";
    	nomes[13] = "Enguia";
    	nomes[14] = "Dragão de Komodo";
    	nomes[15] = "Carangueijo Ferradura";

    	for(int i = 0; i < 16; i++){
    		if(nome == nomes[i])
    			return i;
    	}
    	return -1;
    }
    
    public int[] getCaminho(int indice) {
    	
    	int caminho[] = new int[5];
    	caminho[4] = indice;
    	for(int i = 3; i >= 0; i--) {
    		caminho[i] = (indice+1)/2 -1;
    		indice = caminho[i];
    	}
    	
    	return caminho;
    }
    
    private void animar(Circle[] nos, Line[] arestas,Label[] respostas, Label nome) {
        
        Timeline animacao = new Timeline();
        int i;

        for (i = 0; i < nos.length; i++) {
        	if(i < 4)
        		animaNo(nos[i],questoes[i], animacao, i * 2);
        	else
        		animaNo(nos[i],null, animacao, i * 2);
        	
            if (i < arestas.length) {
            	animaAresta(arestas[i], respostas[i], animacao, i * 2 + 1);
            }
            else
            	nome.setVisible(true);
        }
        
        Timeline lineTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.9), (event) -> {
                	FadeTransition ft = new FadeTransition(Duration.seconds(1),nome);
                	ft.setFromValue(0);
                	ft.setToValue(1);
                	ft.play();
                })
            );
        
        Timeline limpaCaminho = new Timeline(//caso haja sobreposição de animações
                new KeyFrame(Duration.seconds(0.9), (event) -> {
                	int cont;
                	
                	//limpa arestas
                	for(int j = 0; j < this.arestas.length; j++) {//percorre todo o vetor com todas as arestas
                		cont = 0;
                		for(int k = 0; k < arestas.length; k++) 
                			if(this.arestas[j] != arestas[k])
                				cont++;
                			else
                				this.arestas[j].setStroke(javafx.scene.paint.Color.valueOf("#aef055"));  
                		
                		if(cont == 4) 
                			this.arestas[j].setStroke(javafx.scene.paint.Color.valueOf("#514442"));  
                		
                	}
                	//limpa nos
                	for(int j = 0; j < this.nos.length -16; j++) {//percorre todo o vetor com todas as arestas
                		cont = 0;
                		for(int k = 0; k < nos.length -1; k++) 
                			if(this.nos[j] != nos[k])
                				cont++;
                			else
                				this.nos[j].setFill(javafx.scene.paint.Color.valueOf("#aef055"));  
              
                		if(cont == 4) 
                			this.nos[j].setFill(javafx.scene.paint.Color.valueOf("#514442"));  
                	}
                })
            );
        
        
        animacao.getKeyFrames().add(new KeyFrame(Duration.seconds(i * 2 - 1), (event) -> lineTimeline.play()));
        animacao.getKeyFrames().add(new KeyFrame(Duration.seconds(i * 2),  (event) -> limpaCaminho.play()));
        animacao.play();
    }
    
    private void animaNo(Circle no, Label questao,Timeline timeline, int delay) {
        Timeline circleTimeline = new Timeline(
            new KeyFrame(Duration.seconds(0.9), (event) -> {
            	if(questao != null) {
	    			FadeTransition fadt = new FadeTransition(Duration.seconds(1), questao);
	    			fadt.setFromValue(0);
	    			fadt.setToValue(1);
	            	fadt.play();
    			}
            	
            	FillTransition ft = new FillTransition(Duration.seconds(0.5),no);
            
            	no.setVisible(true);
    			ft.setFromValue(javafx.scene.paint.Color.valueOf("#514442"));
    			ft.setToValue(javafx.scene.paint.Color.valueOf("#aef055"));
    			ft.play();
    			
            	
            })
        );
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(delay), (event) -> circleTimeline.play()));        
    }
    
    private void animaAresta(Line aresta, Label resposta, Timeline timeline, int delay) {
        Timeline lineTimeline = new Timeline(
            new KeyFrame(Duration.seconds(0.9), (event) -> {
            	StrokeTransition st = new StrokeTransition(Duration.seconds(1),aresta);
            	aresta.setVisible(true);
            	st.setFromValue(javafx.scene.paint.Color.valueOf("#514442"));
            	st.setToValue(javafx.scene.paint.Color.valueOf("#aef055"));
            	st.play();
            	
            	if(resposta != null) {
	            	FadeTransition ft = new FadeTransition(Duration.seconds(1), resposta);
	            	ft.setFromValue(0);
	            	ft.setToValue(1);
	            	ft.play();
	            	resposta.setVisible(true);
	            }
            })
        );
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(delay), (event) -> lineTimeline.play()));
    }


    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
}
