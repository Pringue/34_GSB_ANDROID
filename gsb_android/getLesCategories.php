<?php
    header('Content-Type: text/html; charset=utf-8');
 
    require_once 'cnx.php';
        
    $categs = getLesCategories();

    echo json_encode($categs);
?>