package applicationV1.controler;

import applicationV1.modele.Acteur;
import applicationV1.modele.Environnement;
import applicationV1.modele.Loup;
import applicationV1.modele.Mouton;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controler implements Initializable {

    private Environnement e;
    private static int count = 0;

    // VBOX
    @FXML
    private ToggleGroup radioButtons;
    @FXML
    private TextField nbAjout;
    @FXML
    private TextField nbTours;
    @FXML
    private Pane panneauJeu;
    // HBOX
    @FXML
    private Label tourActuel;
    @FXML
    private Label nbVivants;
    @FXML
    private Label nbLoups;
    @FXML
    private Label nbMoutons;
    @FXML
    private Slider sliderLoup;
    @FXML
    private Slider sliderMouton;

    @FXML
    void ajouter(ActionEvent event) {
        RadioButton r = (RadioButton) this.radioButtons.getSelectedToggle();
        int nb = Integer.parseInt(this.nbAjout.getText());

        Mouton.setReproduction(this.sliderMouton.getValue());
        Loup.setReproduction(this.sliderLoup.getValue());

        if (r.getText().equals("Mouton")) {
            int i;
            for(i = 0; i < nb; i++) {
                Mouton m = new Mouton(this.e);
                this.e.ajouter(m);
                creerSprite(m);
            }
            this.nbMoutons.setText(String.valueOf(Integer.parseInt(this.nbMoutons.getText()) + i));
        }
        else {
            int i;
            for(i = 0; i < nb; i++) {
                Loup l = new Loup(this.e);
                this.e.ajouter(l);
                creerSprite(l);
            }
            this.nbLoups.setText(String.valueOf(Integer.parseInt(this.nbLoups.getText()) + i));
        }
    }

    @FXML
    void faireDesTours(ActionEvent event) {
        for(int i = 0; i < Integer.parseInt(this.nbTours.getText()); i++) {
            this.e.unTour();
        }
    }

    @FXML
    void unTour(ActionEvent event) {
        this.e.unTour();
        raffraichirAffichage();
        this.tourActuel.setText(String.valueOf(this.e.getNbTours()));
        this.nbVivants.setText(String.valueOf(this.e.getActeurs().size()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.e = new Environnement(450, 250);
    }

    public void creerSprite(Acteur a) {
        Circle c;
        if (a instanceof Mouton) {
            c = new Circle(2);
            c.setFill(Color.WHITE);
        }
        else {
            c = new Circle(3);
            c.setFill(Color.RED);
        }
        c.setId(a.getId());
        c.setTranslateX(a.getX());
        c.setTranslateY(a.getY());
        this.panneauJeu.getChildren().add(c);
    }

    public void raffraichirAffichage() {
        for (Acteur a : this.e.getActeurs()) {
            Circle c = (Circle) this.panneauJeu.lookup("#" + a.getId());
            if (c == null) {
                creerSprite(a);
            }
            else {
                c.setTranslateX(a.getX());
                c.setTranslateY(a.getY());
                if (! a.estVivant()) {
                    this.panneauJeu.getChildren().remove(c);
                    if (a instanceof Mouton) {
                        this.nbMoutons.setText(String.valueOf(Integer.parseInt(this.nbMoutons.getText()) - 1));
                    }
                    else {
                        this.nbLoups.setText(String.valueOf(Integer.parseInt(this.nbLoups.getText()) - 1));
                    }
                }
            }

        }
    }
}
