<?php
    header('Content-Type: text/html; charset=utf-8');
 
    require_once 'cnx.php';

    $antibios = null; 
    $categ = null;
    if (isset($_GET['categorie'])) {
        $categ = $_GET['categorie'];
    }
    $antibios = getLesAntibiotiques($categ);

    echo json_encode($antibios);
?>