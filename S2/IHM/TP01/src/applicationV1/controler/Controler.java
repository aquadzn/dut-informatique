package applicationV1.controler;

import applicationV1.modele.Acteur;
import applicationV1.modele.Environnement;
import applicationV1.modele.Loup;
import applicationV1.modele.Mouton;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controler implements Initializable {

    private Environnement e;

    @FXML
    private ToggleGroup radioButtons;
    @FXML
    private TextField nbAjout;
    @FXML
    private TextField nbTours;
    @FXML
    private Pane panneauJeu;

    @FXML
    void ajouter(ActionEvent event) {
        RadioButton r = (RadioButton) this.radioButtons.getSelectedToggle();
        int nb = Integer.parseInt(this.nbAjout.getText());

        System.out.println(r.getText());
        System.out.println(nb);

        if (r.getText().equals("Mouton")) {
            for(int i = 0; i < nb; i++) {
                Mouton m = new Mouton(this.e)
                this.e.ajouter();
            }
        }
        else {
            for(int i = 0; i < nb; i++) {
                this.e.ajouter(new Loup(this.e));
            }
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.e = new Environnement(450, 250);
    }

    public void creerSprite(Acteur a) {
        if (a instanceof Mouton) {
            Circle c = new Circle(2);
            c.setFill(Color.WHITE);
            c.setTranslateX(a.getX());
            c.setTranslateY(a.getY());
            this.panneauJeu.getChildren().add(c);
        }
        else {
            Circle c = new Circle(3);
            c.setFill(Color.RED);
            c.setTranslateX(a.getX());
            c.setTranslateY(a.getY());
            this.panneauJeu.getChildren().add(c);
        }
    }
}
