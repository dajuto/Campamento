Para poder ejecutar el codigo deberemos:
	- Tener el git instalado
	- Importar el proyecto del gitHub
	- Ejecutar la clase main en el paquete launcher como java application
	- Aparecera un menu con dos botones uno de empleados y otro de acampados
	- Si se pulse el de empleados aparecera un boton de inicio de sesion
	- Al apretarlo, se podra iniciar sesion, para que sea comodo poner en usuario: "usuario00" y en contraseña: "12345678"
	- Aparecera un menu con 5 botones: Se podra cerrar sesion para volver a inciar sesion con otro usuario.
		- Boton Actividades: se abrira un menu que al pulsar ver lista de actividades, podremos:
			- Ver las actividades existentes
			- Añadir una nueva actividad 
			- Modificar una actividad existente
			- Eliminar un actividad existente
			
		- Boton Sanidad: Apareceran dos botones:
			- Boton de citas: apareceran las citas de todos los medicos registrados, solo los medicos podran consultar o eliminar citas que esten a su nombre, es decir que se le hayan solicitado a el. Los demas usuarios no  podran consultar o eliminar citas. Un medico, usuario: "David00" contraseña: "1"
			- Boton de recetas: apareceran todas las recetas de todos los medicos, solo los medicos podran crear recetas a su nombre para un acampado especifico, consultar y eliminar sus recetas. Donde el resto de usuarios no tendran interacción con las recetas.
			
		- Boton Comedor: aparecen cuatro botones: 
		 	-boton ver comedor: te aparece un boton el cual te da la posibilidad de ver una lista con el menu semanal.
		 	-boton ver lista menu: este boton nos ofrece mer una tabla con el menu semanal del campamento, ademas nos da la posibilidad de crear un nuevo menu para el campamento, eliminar el menu de un dia seleccionado y por ultimo consultar el menu del campamento.
			- boton crear menu: nos da la opcion de crear el emnu añadiendo un dia, desayuno, comida y cena.
			-boton eliminar: elimina el menu de un dia seleccionado
			- boton consultar: consulta el menu del dia seleccionado 
		 
		- Boton Contabilidad: aparecera un menu con tres botones:
			- Boton de Gastos: En el aparecera un menu con cuatro botones:
				- Mostrar Gastos: Se mostrara la lista de gastos del campamento
				- Añadir Gasto: Se podra añadir un nuevo gasto, teniendo la opcion de contabilizar la cuenta (en este caso no se podra eliminar y a la hora de modificar tendra limitaciones).
				- Eliminar Gasto: Podra seleccionar el gasto que se quiere eliminar mediante el numero de factura
				- Modificar Gasto: Permite modificar el gasto seleccionado mediante el numero de factura.
			
			- Boton de Ingresos: En el aparecera un menu con cuatro botones:
				- Mostrar Ingresos: Se mostrara la lista de ingresos del campamento
				- Añadir Ingresos: Se podra añadir un nuevo ingreso, teniendo la opcion de contabilizar la cuenta (en este caso no se podra eliminar y a la hora de modificar tendra limitaciones).
				- Eliminar Ingreso: Podra seleccionar el ingreso que se quiere eliminar mediante el numero de factura
				- Modificar Ingreso: Permite modificar el ingreso seleccionado mediante el numero de factura.
			
			- Rendimiento: Apareceran la totalidad de ingresos y de gastos del campamento, asi como el rendimiento neto del ejercicio mostrando si tiene ganacias o perdidas.
		
		- Boton Gestoria: Apareceran cuatro botones:
			-Boton Limpieza: Apareceran cuatro Botones:
				- Boton Mostrar Horarios: aparecera la lista de horarios de limpieza del campamento
				- Boton Añadir Horario: se podra añadir un nuevo horario de limpieza, especificando un de los empleados de limpieza registrados asi como de la instalción que se vaya a limpiar.
				- Boton Modificar Horarios: se podran modificar los horarios de limpieza seleccionando su codigo.
				- Boton Eliminar: se eleminara el horario de limpieza del codigo elegido.
				
			- Boton Instalaciones: apareceran cuatro botones:
				- Boton Mostrar Instalaciones: aparecera la lista de instalaciones del campamento
				- Boton Modificar instalacion: se podran modificar las instalaciones 
				- Boton Añadir instalacion: se podra añadir una nueva instalación
				- Boton eliminar instalación: se podra eliminar una instalacion
			
			
		- Boton Añadir empleado: se podra crear un nuevo empleado, teniendo en cuenta que el usuario y el nombre  introducidos no coincidan con uno ya existente.
	
	- Tambien se puede iniciar sesion como acampado o registarse como un nuevo acampado.
		- Boton Pedir Cita: el usuario podra pedir cita con el medico que elija y el motivo que elija, se registrara en la lista de citas pendientes del medico donde la aparecera como  "N0" atendida el nombre del usurio y el motivo.
		
		- Al registrar un nuevo acampado, si marca la casilla de enfermo se generara el formulario de pedir cita con el usuario recien registrado si no ha habido fallos en el registro con el motivo predefinido de Covid o Gripe. 
		
		- Boton Gestoria: el acampado tendra la posibilidad de modificar su perfil, o cambiar su contraseña. Ejemplo  de acampado, usuario: "alvaro01" contraseña: "12121212"
		
		- Boton lista de actividades: el boton lista de actividades mostrará a todos los acampados la misma lista de actividades disponibles del campamento, ya que todas ellas son comunes para todos ellos.
		
		- Boton contabilidad: el boton nos permite ver el estado del pago del acampado: "Importe pagado" o "Importe no pagado". De estar el importe pagado, no te permite darle al botón de pagar. De no estar pagado, te permite seleccionar el botón puesto que no se ha pagado el abono. 
		
		- Boton menu semanal: el boton nos enseña una lista a los acampados con el menu semanal del campamento 