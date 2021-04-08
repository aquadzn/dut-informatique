package applicationV1.controler;

import applicationV1.modele.Acteur;
import applicationV1.modele.Environnement;
import applicationV1.modele.Loup;
import applicationV1.modele.Mouton;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controler implements Initializable {

    private Environnement e;

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

    public void setTourActuel(int tourActuel) {
        this.tourActuel.setText(String.valueOf(tourActuel));
    }

    public int getNbVivants() {
        return Integer.parseInt(this.nbVivants.getText());
    }

    public void setNbVivants(int nbVivants) {
        this.nbVivants.setText(String.valueOf(nbVivants));
    }

    public int getNbLoups() {
        return Integer.parseInt(this.nbLoups.getText());
    }

    public void setNbLoups(int nbLoups) {
        this.nbLoups.setText(String.valueOf(nbLoups));
    }

    public int getNbMoutons() {
        return Integer.parseInt(this.nbMoutons.getText());
    }

    public void setNbMoutons(int nbMoutons) {
        this.nbMoutons.setText(String.valueOf(nbMoutons));
    }


    @FXML
    void ajouter(ActionEvent event) {
        RadioButton r = (RadioButton) this.radioButtons.getSelectedToggle();
        int nb = Integer.parseInt(this.nbAjout.getText());

        if (nb < 1) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Erreur de saisie");
            a.setContentText("Veuillez entrer une valeur supérieur à 0 !");
            a.showAndWait();
            return ;
        }

        Mouton.setReproduction(this.sliderMouton.getValue());
        Loup.setReproduction(this.sliderLoup.getValue());

        if (r.getText().equals("Mouton")) {
            int i;
            for(i = 0; i < nb; i++) {
                Mouton m = new Mouton(this.e);
                this.e.ajouter(m);
                creerSprite(m);
            }
            setNbMoutons(getNbMoutons() + i);
        }
        else {
            int i;
            for(i = 0; i < nb; i++) {
                Loup l = new Loup(this.e);
                this.e.ajouter(l);
                creerSprite(l);
            }
            setNbLoups(getNbLoups() + i);
        }
        setNbVivants(getNbMoutons() + getNbLoups());
    }

    @FXML
    void faireDesTours(ActionEvent event) {
        int nb = Integer.parseInt(this.nbTours.getText());

        if (nb < 1) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Erreur de saisie");
            a.setContentText("Veuillez entrer une valeur supérieur à 0 !");
            a.showAndWait();
            this.nbTours.setText("");
            return ;
        }

        for(int i = 0; i < nb; i++) {
            this.e.unTour();
        }
        this.nbTours.setText("");
    }

    @FXML
    void unTour(ActionEvent event) {
        this.e.unTour();
        raffraichirAffichage();
        this.nbAjout.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.e = new Environnement(450, 250);
    }

    public void creerSprite(Acteur a) {
        Circle c;
        Tooltip t = new Tooltip();

        if (a instanceof Mouton) {
            c = new Circle(2);
            c.setFill(Color.WHITE);
            t.setStyle("-fx-background-color: white; -fx-text-fill: black;");
        }
        else {
            c = new Circle(3);
            c.setFill(Color.RED);
            t.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        }
        c.setId(a.getId());
        c.setTranslateX(a.getX());
        c.setTranslateY(a.getY());

        t.setText(a.getId() + " - " + a.getPv() + " pv - x:"  + c.getTranslateX() + ", y:" + c.getTranslateY());
        Tooltip.install(c, t);
        this.panneauJeu.getChildren().add(c);
    }

    public void raffraichirAffichage() {
        for (Acteur a : this.e.getActeurs()) {
            // Si l'acteur existe mais n'est pas encore dans les sprites
            // alors naissance
            if (this.panneauJeu.lookup("#" + a.getId()) == null) {
                creerSprite(a);
            }
            // Si un sprite existe pour un acteur
            else {
                Node c = this.panneauJeu.lookup("#" + a.getId());

                // Si l'acteur n'existe plus mais est présent dans les sprites
                if (c == null) {
                    this.panneauJeu.getChildren().remove(c);
                }
                // Si l'acteur existe et est présent dans les sprites
                else {
                    c.setTranslateX(a.getX());
                    c.setTranslateY(a.getY());
                }
            }
        }
        setTourActuel(this.e.getNbTours());
        setNbVivants(this.e.getActeurs().size());
    }

//        for(int i = 0; i < this.panneauJeu.getChildren().size(); i++) {
//            Circle c = (Circle) this.panneauJeu.getChildren().get(i);
//            Acteur a = estDansActeurs(c.getId());
//            if (a == null) {
//                this.panneauJeu.getChildren().remove(c);
//                // Mouton
//                if (c.getFill() == Color.WHITE) {
//                    setNbMoutons(getNbMoutons() - 1);
//                }
//                else {
//                    setNbLoups(getNbLoups() - 1);
//                }
//            }
//            else {
//                c.setTranslateX(a.getX());
//                c.setTranslateY(a.getY());
//
//                Tooltip t = new Tooltip(a.getId() + " - " + a.getPv() + " pv - x:"  + c.getTranslateX() + ", y:" + c.getTranslateY());
//                if (c.getFill() == Color.WHITE) {
//                    t.setStyle("-fx-background-color: white; -fx-text-fill: black;");
//                }
//                else {
//                    t.setStyle("-fx-background-color: red; -fx-text-fill: white;");
//                }
//                Tooltip.install(c, t);
//            }
//        }
//        setTourActuel(this.e.getNbTours());
//        setNbVivants(this.e.getActeurs().size());
//    }

    public Acteur estDansActeurs(String idCercle) {
        for (Acteur a : this.e.getActeurs()) {
            if (a.getId().equals(idCercle)) {
                return a;
            }
        }
        return null;
    }
}
