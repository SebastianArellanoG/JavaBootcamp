$(document).ready(function () {
  $('#enviarCorreo').click(function () {
    alert('El correo fue enviado correctamente...');
  });
});

document
  .querySelectorAll('[data-bs-toggle="tooltip"]')
  .forEach((tooltip) => {
    new bootstrap.Tooltip(tooltip);
  });

$(document).ready(function () {
  $('.borderbottom').on('dblclick', function () {
    $(this).css('color', 'red');
  });
});

$(document).ready(function () {
  $('#titletoggle').click(function () {
    $('.card').toggle();
  });
});
