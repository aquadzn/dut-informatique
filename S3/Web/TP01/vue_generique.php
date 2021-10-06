<?php

class VueGenerique {

    public function __construct() {
        ob_start();
    }

    public function getAffichage(): string {
        return ob_get_clean();
    }
}
