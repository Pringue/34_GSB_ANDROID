<?php
    header('Content-Type: text/html; charset=utf-8');
 
    require_once 'cnx.php';

    $compte = null; 
    $nom = null;
    $mdp = null;
    if (isset($_GET['nom'])) {
        $nom = $_GET['nom'];
    }
    if (isset($_GET['mdp'])) {
        $mdp = $_GET['mdp'];
    }
    $compte = getCompte($nom, $mdp);
    
    echo json_encode($compte);
?>