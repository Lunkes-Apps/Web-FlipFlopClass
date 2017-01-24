//$('#confirmapassword').on('keyup', function () {
//    if ($(this).val() == $('#password').val()) {
//        $('#password').addClass("has-success");
//        $('#confirmapassword').addClass("has-success");
//    } else {
//    	$('#password').addClass("has-error");
//        $('#confirmapassword').addClass("has-error");
//    }
//    alert("funcionou");
//    
//});



$('#confirmacaoExclusaoModal').on(
		'show.bs.modal',
		function(event) {
			var button = $(event.relatedTarget);
			var idProduto = button.data('id');
			var nomeProduto = button.data('nome');
			var modal = $(this);
			var form = modal.find('form');
			var action = form.attr('action');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + idProduto);

			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o produto <strong>'
							+ nomeProduto + '</strong>?');

		});

var offset = $('#menuBar').offset().top;
var $menuBar = $('#menuBar');
$(document).on('scroll', function() {

	if (offset <= $(window).scrollTop()) {
		$menuBar.addClass('fixar');
	} else {
		$menuBar.removeClass('fixar');
	}
});

var time;
var count = 0;
var slide = 1;
var idS1;
var idS2;
var most = 0;
var valor1 = 1;
var valor2 = 0;
var wait;

wait = setTimeout(waiting, 2000);
function timer() {

	valor1 = ocultar(idS1, valor1);
	valor2 = mostrar(idS2, valor2);

	if (valor1 == 0) {
		count = 0;

		clearInterval(time);
		wait = setTimeout(waiting, 4000);

		valor1 = 1;
		valor2 = 0;
	}

	count++;
};

function mostrar(id, valor) {
	valor += 0.25;
	document.getElementById(id).style.opacity = valor;
	return valor;
};

function ocultar(id, valor) {
	valor -= 0.25;
	document.getElementById(id).style.opacity = valor;
	return valor;
};

function waiting() {
	alternaSlide();
	time = setInterval(timer, 200);
};

var selet1;
var selet2;

var off = "images/off.png";
var on = "images/on.png";
function desliga(id) {
	document.getElementById(id).src = off;
};
function liga(id){
	document.getElementById(id).src = on;
};

function alternaSlide() {
	idS1 = 'slide' + slide;
	selet1 = 's' + slide;
	slide++;
	if (slide == 3) {
		slide = 1;
	}
	idS2 = 'slide' + slide;
	selet2 = 's' + slide;
	
	desliga(selet1);
	liga(selet2);	
};


