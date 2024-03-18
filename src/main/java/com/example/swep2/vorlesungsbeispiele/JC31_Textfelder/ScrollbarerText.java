package com.example.swep2.vorlesungsbeispiele.JC31_Textfelder;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ScrollbarerText extends Application {

	private TextArea textArea;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		textArea = new TextArea();
		textArea.setText("Mit 82 Studenten und einem angemieteten Gebäude startete" + 
				   " die Hochschule Kempten 1978 in den Vorlesungsbetrieb. " + 
				   "Die Presse berichtete über den Amtsantritt von Papst Johannes"+
				   " Paul II., die erste Atlantiküberquerung in einem Ballon oder" +
				   " über den letzten in Deutschland produzierten VW-Käfer. Im " + 
				   "Allgäu war es die neugegründete Hochschule, die mit ihrem "+ 
				   "ehrgeizigen Ausbauziel von 1.000 Studenten für Aufsehen sorgte.\n"+
                   "\nHeute sind rund 5.000 Studierende in derzeit 19 Studiengängen "+
                   "eingeschrieben. 120 Professoren bewerkstelligen den Großteil der"+
                   " Vorlesungen, unterstützt von ca. 200 Lehrbeauftragten aus der "+
                   "freien Wirtschaft. Ausgehend vom provisorischen Anfangsbau ist "+
                   "in der Bahnhofstraße ein 42.000 qm großer Hochschulcampus mit "+
                   "modernen Lehrgebäuden, Laboren, Bibliothek und Mensa entstanden.");
		textArea.setStyle("-fx-font-size: 18;");
		textArea.setPrefSize(600, 200);
		textArea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		textArea.setWrapText(true);
		
		//Größenänderung des Fensters bewirkt Größenänderung der textArea:
//		Scene textareascene = new Scene(textArea);

		//oder wenn man die Größenänderung des Fensters nicht auf die Pane durchreichen will:
		Group root = new Group();
		root.getChildren().add(textArea);
		Scene textareascene = new Scene(root);
		
		stage.setTitle("TextArea");
		stage.setScene(textareascene);
		stage.show();
		
	}
}
