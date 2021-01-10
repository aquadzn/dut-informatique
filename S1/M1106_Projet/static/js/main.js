function afficherCategorie(evt, id) {

    var i, x, tablinks;
    x = document.getElementsByClassName("categorie");

    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    document.getElementById(id).style.display = "block";

    tablinks = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" is-active", "");
    }
    evt.currentTarget.className += " is-active";
}