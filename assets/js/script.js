window.addEventListener('load', function () {
  let ramos = ['HTML', 'CSS', 'JavaScript'];
  let notasTotales = [];
  let tabla = document.getElementById('tablaNotas');

  ramos.forEach((ramo) => {
    let notas = [];
    for (let i = 1; i <= 3; i++) {
      let nota = parseFloat(
        prompt(`Ingresa la nota ${i} para ${ramo}:`)
      );
      notas.push(nota);
    }
    let promedio = notas.reduce((a, b) => a + b, 0) / notas.length;
    notasTotales.push({ ramo, notas, promedio });

    let fila = `<tr>
                        <td>${ramo}</td>
                        <td>${notas[0]}</td>
                        <td>${notas[1]}</td>
                        <td>${notas[2]}</td>
                        <td>${promedio.toFixed(1)}</td>
                    </tr>`;
    tabla.innerHTML += fila;
  });
});
