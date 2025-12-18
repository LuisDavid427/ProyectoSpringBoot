async function enviarDatos() {
    // Objeto que coincide con UsuarioModel.java
    const usuario = {
        nombres: document.getElementById('nom').value,
        apellidos: document.getElementById('ape').value,
        cedula: document.getElementById('ced').value,
        fecha_nacimiento: document.getElementById('fec').value
    };

    try {
        const response = await fetch('http://localhost:8080/api/guardar', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            alert("¡Éxito! Usuario guardado en PostgreSQL.");
            limpiarCampos();
        } else {
            const dataError = await response.json();
            // Mostramos el error en la pantalla roja
            lanzarPantallaError(dataError.error || "Error de validación en los datos.");
        }
    } catch (err) {
        lanzarPantallaError("Servidor Spring Boot fuera de línea.");
    }
}

function lanzarPantallaError(msg) {
    document.getElementById('texto-error').innerText = msg;
    document.getElementById('pantalla-error').style.display = 'block';
    document.getElementById('capa-oscura').style.display = 'block';
}

function cerrarError() {
    document.getElementById('pantalla-error').style.display = 'none';
    document.getElementById('capa-oscura').style.display = 'none';
}

function limpiarCampos() {
    document.querySelectorAll('input').forEach(i => i.value = "");
}