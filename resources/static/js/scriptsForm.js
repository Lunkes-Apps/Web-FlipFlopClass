$('#cadastro').submit(function() {
	var nome = document.getElementById('inputNome');
	var email = document.getElementById('inputEmail');
	var senha = document.getElementById('inputPassword');
	// var confirm = document.getElementById('senha-conf');
	//	

	var rNome = 0;
	var rEmail = 0;
	var rPass = 0;
	var rConfirm = 0;
	var rQtNome = 0;
	var rQtPass = 0;
	
	rNome = checkEmpty(nome);
	console.log("nome passou " + rNome);
	rEmail = checkEmpty(email);
	console.log("email passou " + rEmail);
	// checkEmpty(senha);
	// checkEmpty(confirm);

	// alert("teste de cadastro");

	rPass = checkPassword();
	console.log("password passou " + rPass);

	rConfirm = validateEmail(email.value);

	console.log("email confirm passou " + rConfirm);
	
	
	rQtNome = checkQuantNome(nome.value);
	
	console.log("qtdade nome passou " + rQtNome);
	
	rQtPass = checkQtPass(senha.value);
	console.log("qtdade password passou " + rQtPass);
	
	var total = rNome + rEmail + rPass + rConfirm + rQtNome + rQtPass;
	console.log("total passou " + total);

	if (total == 6) {
		apagarAlerta('alerta');
		return true;
	} else {
		return false;
	}

});

function checkEmpty(campo) {

	var label = campo.placeholder;

	var string = campo.value;

	if (string == "") {

		if (checkIfExist('alerta-' + label)) {
			//mostrarAlerta('alerta-' + label);
			// var div = document.getElementById(label + '-div');
			// div.className += ' has-error';
			// var span = document.getElementById('span-' + label);
			// span.className += ' glyphicon-remove';

		} else {
						
			inserirMensagem(label,'deve ser preenchido.');
						
		}

		return 0;
	} else {

		var div = document.getElementById(label + '-div');
		div.className = 'form-group has-feedback';

		var span = document.getElementById('span-' + label);

		span.className = 'glyphicon form-control-feedback';

		if (checkIfExist('alerta-' + label)) {
			apagarAlerta('alerta-' + label);
		}

		return 1;
	}

}

function mostrarAlerta(id) {
	var alerta = document.getElementById(id);
	alerta.style.display = 'block';

}

function apagarAlerta(id) {
	var alerta = document.getElementById(id).remove();	
}

function checkIfExist(id) {

	var element = document.getElementById(id);

	if (element == null) {
		return false;
	}

	return true;
}

function checkPassword() {

	var pass = document.getElementById('inputPassword').value;
	var conf = document.getElementById('inputConfirm').value;

	if (pass == conf && pass!="" && conf!="") {
		if (checkIfExist('alerta-Password')) {
			apagarAlerta('alerta-Password');
		}

		var div = document.getElementById('Password-div');
		div.className = 'form-group has-feedback';

		var span = document.getElementById('span-Password');

		span.className = 'glyphicon form-control-feedback';

		var div2 = document.getElementById('Confirm-div');
		div2.className = 'form-group has-feedback';

		var span2 = document.getElementById('span-Confirm');

		span2.className = 'glyphicon form-control-feedback';

		return 1;
	} else {
		if (checkIfExist('alerta-Password')) {
			inserirMensagem('Password','Confirmação do password não está igual');

		} else {
			inserirMensagem('Password','Confirmação do password não está igual');
			var div = document.getElementById('Password-div');
			div.className += ' has-error';

			var span = document.getElementById('span-Password');

			span.className += ' glyphicon-remove';

			var div2 = document.getElementById('Confirm-div');
			div2.className += ' has-error';

			var span2 = document.getElementById('span-Confirm');

			span2.className += ' glyphicon-remove';

		}
		return 0;
	}

}

function validateEmail(email) {
	var re = /\S+@\S+\.\S+/;

	if (re.test(email)) {
		return 1;
	} else {
		
		inserirMensagem('Email','não é válido.');		
		return 0;
	}

}


function inserirMensagem(idBase,mensagem){
	
	
	if(checkIfExist('alerta-'+idBase)){
			
		apagarAlerta('alerta-'+idBase);	
        console.log('passou existindo');
         		
		var par = document.createElement('p');
		par.id = 'alerta-' + idBase;
		var texto = document
				.createTextNode(idBase + ': ' + mensagem);
		par.appendChild(texto);

		var alerta = document.getElementById("alerta");
		alerta.appendChild(par);
		alerta.style.display = 'block';

		var div = document.getElementById(idBase + '-div');
		div.className += ' has-error';

		var span = document.getElementById('span-' + idBase);

		span.className += ' glyphicon-remove';		

		
		
	}else{
		console.log('passou nao existindo');
		var par = document.createElement('p');
		par.id = 'alerta-' + idBase;
		var texto = document
				.createTextNode(idBase + ': ' + mensagem);
		par.appendChild(texto);

		var alerta = document.getElementById("alerta");
		alerta.appendChild(par);
		alerta.style.display = 'block';

		var div = document.getElementById(idBase + '-div');
		div.className += ' has-error';

		var span = document.getElementById('span-' + idBase);

		span.className += ' glyphicon-remove';		
	}		
	
}

function checkQuantNome(nome){
	
	if(nome.length < 100 && nome.length > 5){
		return 1;
	}else{
		
		inserirMensagem('Nome','deve ter entre 5 e 100 letras.');
		
		return 0;
	}
	
}


function checkQtPass(pass){
	
	if(pass.length > 7  ){
						
		return 1;
	}else{
		
		inserirMensagem('Password','não pode ter menos de 8 caracteres');
		
		return 0;
	}
}