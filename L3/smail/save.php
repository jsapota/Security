<?php
if(isset($_POST['submit'])){
$name = $_POST["username"];
$pass = $_POST["password"];
$fp = fopen("data.txt", "a");
$savestring = $name . "," . $pass . "n";
fwrite($fp, $savestring);
fclose($fp);
Echo "You data has been saved in a text file!";
}
?>
