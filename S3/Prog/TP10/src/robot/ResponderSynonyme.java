package robot;

import java.util.*;
import java.util.stream.Collectors;

public class ResponderSynonyme implements Responder {

    private final Map<String, String> responseMap;
    private final List<String> defaultResponses;
    private final Map<String, String> synonymes;
    private final Random r = new Random();

    public ResponderSynonyme() {
        this.responseMap = new HashMap<>();
        this.fillResponseMap();
        this.defaultResponses = new ArrayList<>();
        this.fillDefaultResponses();
        this.synonymes = new HashMap<>();
        this.fillSynonymes();

        System.out.println("Vérification contraintes: " + representantsSontDansResponseMap() + " - " + synonymesAbsentsDeResponseMap() + "\n");
    }

    public void fillResponseMap() {
        this.responseMap.put("plante", "Eh bien, ca ne plante pas sur notre systeme. Cela doit etre lie a votre systeme. Dites-m'en plus au sujet de votre configuration.");
        this.responseMap.put("lent", "Je pense que c'est lie a votre materiel. La mise a niveau de votre processeur devrait resoudre tous vos problemes de performances. Avez-vous un probleme avecnotre software?");
        this.responseMap.put("performances", "Les performances etaient assez bonnes lors de nos tests. D'autres procedures s'executent-elles en arriere-plan ?");
        this.responseMap.put("bug", "Vous savez, tous les logiciels ont des bogues. Mais nos ingenieurs logiciels travaillent pour les resoudre. Pouvez-vous decrire le probleme en details ?");
        this.responseMap.put("windows", "Ceci est un bogue connu lie au systeme d'exploitation Windows. Veuillez le signaler a Microsoft. Nous ne pouvons rien faire a cela.");
        this.responseMap.put("macintosh", "Ceci est un bogue connu lie au systeme d'exploitation Mac. Veuillez le signaler a Apple. Nous ne pouvons rien faire a cela.");
        this.responseMap.put("cher", "Le prix de notre produit est assez concurrentiel. Avez-vous etudie et vraiment compare les fonctionnalites que nous proposons ?");
        this.responseMap.put("installation", "L'installation est assez simple. Nous avons beaucoup d'assistants qui font le travail pour vous. Avez-vous lu les instructions d'installation ?");
        this.responseMap.put("memoire", "Si vous lisez attentivement la configuration requise, vous verrez que la memoire specifiee doit etre de 1,5 Go. Vous devriez mettre a jour votre memoire. Vouliez-vous savoir autre chose ?");
        this.responseMap.put("linux", "Nous prenons tres au serieux la prise en charge de Linux. Certains problemes subsistent. La plupart sont lies a une incompatibilite des versions glibc. Pouvez-vous etre un peu plus precis ?");
        this.responseMap.put("eclipse", "Ceci est un bogue connu d'Eclipse. Vous devriez faire une mise a jour.");
    }

    public void fillDefaultResponses() {
        this.defaultResponses.add("Cela semble etrange. Pourriez-vous decrire ce probleme plus precisement ?");
        this.defaultResponses.add("Aucun autre client ne s'est jamais plaint de cela. Quelle est votre configuration systeme ?");
        this.defaultResponses.add("Cela est interessant. Dites-m'en plus...");
        this.defaultResponses.add("J'ai besoin d'un peu plus d'informations a ce sujet");
        this.defaultResponses.add("Avez-vous verife que vous n'avez pas de conflit de dll ?");
        this.defaultResponses.add("Ceci est explique dans le manuel. Avez-vous lu le manuel ?");
        this.defaultResponses.add("Votre description est un peu confuse. Y a-t-il un expert pres de vous qui pourrait decrire ceci plus precisement ?");
        this.defaultResponses.add("Ce n'est pas un bogue, c'est une fonctionnalite !");
        this.defaultResponses.add("Pourriez-vous preciser ?");
    }

    public void fillSynonymes() {
        this.synonymes.put("bogue", "bug");
        this.synonymes.put("planter", "plante");
    }

    public String pickDefaultResponse() {
        return this.defaultResponses.get(r.nextInt(this.defaultResponses.size()));
    }

    public boolean representantsSontDansResponseMap() {
        return this.synonymes.values().stream()
                .allMatch(s -> this.responseMap.containsKey(s));
    }

    public boolean synonymesAbsentsDeResponseMap() {
       return this.synonymes.keySet().stream()
               .noneMatch(s -> this.responseMap.containsKey(s));
    }

    @Override
    public String generateResponse(Collection<String> question) {
        System.out.println(question);
        for (String mot : question) {
            if (this.synonymes.containsKey(mot)) {
                if (this.responseMap.containsKey(this.synonymes.get(mot))) {
                    return this.responseMap.get(this.synonymes.get(mot));
                }
            }
            else {
                if (this.responseMap.containsKey(mot)) {
                    return this.responseMap.get(mot);
                }
            }
        }
        return pickDefaultResponse();
    }
}
