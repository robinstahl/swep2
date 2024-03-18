package com.example.swep2.vorlesungsbeispiele.JC30_Label;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelDemo extends Application {

	public static void main(String[] args) {
		launch(args);	}

	@Override
	public void start(Stage stage) throws Exception {
		//gib alle installierten Schriftarten aus
		for (String family : Font.getFamilies()) {
			System.out.println(family);
			for (String fontname : Font.getFontNames(family)) {
				System.out.println("--> " + fontname);
			}
		}

		Group root = new Group(); // die braucht man hier nur für das "Vorabberechnen" der size
		StackPane pane = new StackPane();


		// Wir holen uns ein Image
		//Image img = new Image(getClass().getResourceAsStream("tea.png"));
		// man kann auch eine gewünschte Größe für das Image angeben
		Image img = new Image(getClass().getResourceAsStream("tea.png"),40,40,true,true);
	
		// Wir setzen das Image in einen Node
		ImageView imgView = new ImageView();
		imgView.setImage(img);
		
		// Wir erstellen ein Label mit einem Text und unserem Image
		Label label = new Label("Time to have a break!", imgView);
		//label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		// Das Image ist standardmäßig links vom Text.
		// man kann aber auch andere Ausrichtungen einstellen:
		//label.setContentDisplay(ContentDisplay.BOTTOM); //Image unter Text
		//label.setContentDisplay(ContentDisplay.TOP); //Image über Text
		//label.setContentDisplay(ContentDisplay.CENTER);//Image und Text überlagern sich zentriert
		//label.setContentDisplay(ContentDisplay.RIGHT); // Image rechts vom Text
		//label.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);//kein Text
		//label.setContentDisplay(ContentDisplay.TEXT_ONLY);//kein Image
		//label.setGraphicTextGap(200.0);

		//Generische Schriftarten (abh. vom System): 
	    //'serif' (e.g., Times)
	    //'sans-serif' (e.g., Helvetica)
	    //'cursive' (e.g., Zapf-Chancery)
	    //'fantasy' (e.g., Western)
	    //'monospace' (e.g., Courier)
//		label.setFont(Font.font("sans-serif", FontWeight.BOLD, FontPosture.ITALIC, 20));
//		label.setFont(Font.font("serif", FontWeight.BOLD, 20));
//		label.setFont(Font.font("monospace", FontWeight.NORMAL, 20));
		 
		//Physische Schriftarten: Alle installierten TrueType-Schriftartenfamilien
		//label.setStyle("-fx-font: 24px 'System'; -fx-font-weight: bold; -fx-font-style: italic;");
		label.setStyle("-fx-font: oblique bold 24px 'Serto Batnan';");
		//Tooltip anzeigen
		label.setTooltip(new Tooltip("Wenn's mal wieder länger dauert..."));
		
		//Label auf die Pane setzen
		pane.getChildren().add(label);

		// Border anbringen
		// hier ein paar Alternativen:

//		BorderStroke borderstroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, BorderStroke.DEFAULT_WIDTHS);
//		Border schwarzeLinie = new Border(borderstroke);
//		label.setBorder(schwarzeLinie);

//		CornerRadii cr = new CornerRadii(5,20,15,30, false);
//		BorderStroke borderstroke = new BorderStroke(Color.RED, BorderStrokeStyle.DASHED, cr, BorderStroke.THICK);
//		Border schwarzeLinie = new Border(borderstroke);
//		label.setBorder(schwarzeLinie);
		
		//in Kombination mit CSS sind komplexere Rahmen möglich:
		label.setStyle(label.getStyle()+("-fx-base: lightgrey;" + 
				"-fx-border-base: gray;\n" + 
				"    -fx-border-shadow: white;\n" + 
				"    -fx-light-border: derive(-fx-border-base, 25%);\n" + 
				"    -fx-border-color: -fx-light-border -fx-border-base -fx-border-base -fx-light-border;\n" + 
				"    -fx-border-insets: 0 1 1 0;\n" + 
				"    -fx-background-color: -fx-border-shadow, -fx-background;\n" + 
				"    -fx-background-insets: 1 0 0 1, 2;\n" + 
				"    -fx-padding: 20;"));

		
		root.getChildren().add(pane);
		Scene labelscene = new Scene(root);
		stage.setScene(labelscene);
		stage.setTitle("Labeldemo");

		//für die Beispiele mit Border:
		root.applyCss();//apply all style attributes to all nodes in group
		root.layout();  // compute size of all nodes (and their position)
		pane.setPrefSize(label.getWidth()+40, label.getHeight()+40); //enlarge pane to see the border better

		stage.show();
		
	}

}
