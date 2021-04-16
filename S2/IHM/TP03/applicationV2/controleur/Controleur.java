package applicationV2.controleur;
import java.net.URL;
import java.util.ResourceBundle;
import applicationV2.modele.Acteur;
import applicationV2.modele.Environnement;
import applicationV2.modele.Loup;
import applicationV2.modele.Mouton;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controleur implements Initializable{
	private Environnement env;
	private IntegerProperty nbToursProperty;
	private IntegerProperty nbVivantsProperty;
	private IntegerProperty nbLoupsProperty;
	private IntegerProperty nbMoutonsProperty;
	private StringProperty jourNuitProperty;

	// VBOX
	@FXML
	private Label jourNuit;
	@FXML
	private Pane panneauJeu;
	@FXML
	private ToggleGroup groupeRadio;
	@FXML
	private RadioButton ajoutLoup;
	@FXML
	private RadioButton ajoutMouton;
	@FXML
	private TextField nbIndividus;
	@FXML
	private TextField saisieNbTours;
	@FXML
	private Slider sliderLoups;
	@FXML
	private Slider sliderMoutons;

	// HBOX
	@FXML
	private Label nbTours;
	@FXML
	private Label nbVivants;
	@FXML
	private Label nbMoutons;
	@FXML
	private Label nbLoups;

	@FXML
	void reset(ActionEvent event) {
		this.env.getActeurs().clear();
		this.panneauJeu.getChildren().clear();
		this.env.setNbTours(0);

	}

	@FXML
	void ajouter(ActionEvent event) {
		//System.out.println("clic ajouter");
		RadioButton selectedToggleButton =(RadioButton) groupeRadio.getSelectedToggle();
		int nb= Integer.parseInt(this.nbIndividus.getText());
		Acteur a;
		if(selectedToggleButton.equals(ajoutLoup)) {
			for(int i=0; i<nb;i++){
				a=new Loup(this.env);
				this.env.ajouter(a);
			}
		}
		else{
			for(int i=0; i<nb;i++){
				a=new Mouton(this.env);
				this.env.ajouter(a);
			}
		}

	}

	@FXML
	void faireDesTours(ActionEvent event) {
		//System.out.println("clic Lancer");
		int nt= Integer.parseInt(this.saisieNbTours.getText());
		for(int i=0;i<nt;i++){
			this.env.unTour();
			this.nbToursProperty.setValue(this.env.getNbTours());
			rafraichirPanneauJeu();
		}
	}

	@FXML
	void unTour(ActionEvent event) {
		//System.out.println("clic unTour");
		this.env.unTour();
		this.nbToursProperty.setValue(this.env.getNbTours());
		this.jourNuitProperty.setValue(this.env.getJourNuit());
		// this.rafraichirPanneauJeu();
	}

	private void creerSprite(Acteur a) {
		//System.out.println("ajouter sprite");
		Circle r;
		Tooltip t = new Tooltip();
		if( a instanceof Loup){
			r= new Circle(3);
			r.setFill(Color.RED);
			this.nbLoupsProperty.setValue(this.nbLoupsProperty.getValue() + 1);
			t.setText("Loup - ");
			t.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		}
		else{
			r= new Circle(2);
			r.setFill(Color.WHITE);
			this.nbMoutonsProperty.setValue(this.nbMoutonsProperty.getValue() + 1);
			t.setText("Mouton - ");
			t.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		}
		// ils ont le meme identifiant
		r.setId(a.getId());
		r.setOnMouseClicked(e-> System.out.println("clic sur acteur"+ e.getSource()));

		r.translateXProperty().bind(a.xProperty());
		r.translateYProperty().bind(a.yProperty());

		t.setText(t.getText() + "x: " + r.getTranslateX() + "y: " + r.getTranslateY());
		Tooltip.install(r, t);

		panneauJeu.getChildren().add(r);
		this.nbVivantsProperty.setValue(this.nbVivantsProperty.getValue() + 1);
	}

	public void rafraichirPanneauJeu(){
		for(Acteur a : this.env.getActeurs()){
			Circle c = (Circle) this.panneauJeu.lookup("#"+a.getId());
			// si c'est un nouveau né
			if(c==null){
				creerSprite(a);
			}
			else {
				c.setTranslateX(a.getX());
				c.setTranslateY(a.getY());
			}
		}
		// pour enlever les morts, il faut parcourir les sprites...
		for (int i = this.panneauJeu.getChildren().size()-1; i>=0;i--){
			Node c = this.panneauJeu.getChildren().get(i) ;
			Acteur a = this.env.getActeur(c.getId());
			if(a == null) {
				this.panneauJeu.getChildren().remove(c);
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.env = new Environnement(300,300);
		this.panneauJeu.setMaxWidth(305); // 5== largeur de l'image ou du rectangle.
		this.panneauJeu.setMaxHeight(305);

		// Naissances et morts
		this.env.getActeurs().addListener((ListChangeListener<Acteur>) c -> {
			while (c.next()) {
				for(Acteur a : c.getAddedSubList()) {
					creerSprite(a);
				}
				for(Acteur a : c.getRemoved()) {
					Node n = panneauJeu.lookup("#" + a.getId());
					panneauJeu.getChildren().remove(n);
				}
			}
		});

		this.nbToursProperty = new SimpleIntegerProperty(0);
		this.nbVivantsProperty = new SimpleIntegerProperty(0);
		this.nbLoupsProperty = new SimpleIntegerProperty(0);
		this.nbMoutonsProperty = new SimpleIntegerProperty(0);

		this.jourNuitProperty = new SimpleStringProperty("jour");

		this.nbToursProperty.addListener((obs, old, nouv) -> this.nbTours.setText(nouv.toString()));
		this.nbVivantsProperty.addListener((obs, old, nouv) -> this.nbVivants.setText(nouv.toString()));
		this.nbLoupsProperty.addListener((obs, old, nouv) -> this.nbLoups.setText(nouv.toString()));
		this.nbMoutonsProperty.addListener((obs, old, nouv) -> this.nbMoutons.setText(nouv.toString()));

		this.sliderLoups.valueProperty().addListener((obs,old,nouv) -> Loup.setReproduction((double)nouv));
		this.sliderMoutons.valueProperty().addListener((obs,old,nouv) -> Mouton.setReproduction((double)nouv));

		this.jourNuitProperty.addListener((obs, old, nouv) -> this.jourNuit.setText(nouv));

		// ecoute de la liste des acteurs pour prendre en compte les morts et les vivants
		// this.env.getActeurs().addListener(new MonObservateurActeurs(this.panneauJeu, this.labelVivants, this.labelnbLoups,this.labelnbMoutons));
		// this.env.init();
	}
}
