<?php

function connectionBDD()
{
    //connexion a la base de données
    // dsn = Data Source Name = driver MYSQL
    $dsn='mysql:dbname=id9643130_gsb;host=localhost';
    //login
    $login='id9643130_root1';
    // Mot de passe
    $motDePasse='root02';
    // Connexion au serveur MySQL
    try{
        $cnx = new PDO($dsn, $login, $motDePasse,
                array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
                PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
    }
    catch (PDOException $e){
        die('Erreur : ' . $e->getMessage());
    }
    return $cnx;
}

function getLesCategories()
{
    $cnx = connectionBDD();
    $sql = $cnx->prepare("select id, libelle from categorie");
    $sql->execute();
    $datas = $sql->fetchAll(PDO::FETCH_ASSOC);
    return $datas;
}

function getLesAntibiotiques($categ)
{
    $cnx = connectionBDD();
    $sql = $cnx->prepare("select a.* from antibiotique a inner join categorie c on a.idCateg = c.id where c.libelle = '".$categ."'");
    $sql->execute();
    $datas = $sql->fetchAll(PDO::FETCH_ASSOC);
    return $datas;
}

function getCompte($nom, $mdp)
{
    $cnx = connectionBDD();
    $sql = $cnx->prepare("select * from compte where nom = '".$nom."' and mdp = '".$mdp."'");
    $sql->execute();
    $datas = $sql->fetchAll(PDO::FETCH_ASSOC);
    return $datas;
}

?>