<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .contenido {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="contenido">
        <h1>QUEEN WEB</h1>
        <h3>Registrarse</h3>
        <form action="board" method="post">
            <label for="nombre">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" required><br>
            <label for="correo">Correo electrónico:</label><br>
            <input type="email" id="correo" name="correo" required><br>
            <label for="contrasena">Contraseña:</label><br>
            <input type="password" id="contrasena" name="contrasena" required><br><br>
            <input type="submit" value="Registrarse">
        </form>
        <p>¿Ya tienes una cuenta? <a href="login">Iniciar Sesión</a></p>
    </div>
</body>
</html>
