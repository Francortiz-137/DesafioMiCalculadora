<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculadora</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body class="bg-custom text-light">
<main>
    <h1 class="text-center">Calculadora</h1>
    <br/>
    <form class="container" method="POST" action="calcular">
        <div class="mb-3">
            <label for="numero1" class="form-label">Numero1</label>
            <input type="number" class="form-control bg-custom text-light" id="numero1" name="numero1" placeholder="Numero 1">
        </div>
        <div class="mb-3">
            <label for="numero2" class="form-label">Numero2</label>
            <input type="number" class="form-control bg-custom text-light" id="numero2" name="numero2" placeholder="Numero 2">
        </div>
        <div class="mb-3 form-check p-0">
            <select class="form-select bg-custom text-light"  name="operacion" aria-label="Default select example">
                <option value="sumar">Suma</option>
                <option value="restar">Resta</option>
                <option value="multiplicar">Multiplicacion</option>
                <option value="dividir">Division</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary btn-color w-100">Calcular</button>
    </form>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>