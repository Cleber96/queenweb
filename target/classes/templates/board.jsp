<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
<style>
    .tablero {
        display: flex;
        flex-wrap: wrap;
        width: 800px;
        height: 800px;
    }
    .casilla {
        width: 100px;
        height: 100px;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .blanca {
        background-color: #f0d9b5;
    }
    .negra {
        background-color: #b58863;
    }
</style>
</head>
<body>
<div class="tablero" id="tablero"></div>

<script>
    const tablero = document.getElementById("tablero");
    for (let fila = 0; fila < 8; fila++) {
        for (let columna = 0; columna < 8; columna++) {
            const esBlanca = (fila + columna) % 2 === 0;
            const casilla = document.createElement("div");
            casilla.classList.add("casilla");
            casilla.classList.add(esBlanca ? "blanca" : "negra");
            tablero.appendChild(casilla);
        }
    }
</script>
</body>
</html>
