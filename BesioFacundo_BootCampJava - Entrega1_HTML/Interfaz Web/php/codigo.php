<?php
$estado = $_POST['estado'];
$comentarios = $_POST['comentarios'];
$email = $_POST['email'];
$nombre = $_POST['nombre'];
$opcion = $_POST['opcion'];
$to = "mail_prueba@gmail.com";
$email_subject = "Mail desde el formulario";
$email_body = '|El nombre es<br>'.$nombre 'El mail es<br>'. $email . ;
$headers = "From: $email\n";


mail($to,$email_subject,$email_body,$headers);
echo "El mensaje se envio correctamente";
?>