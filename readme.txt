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
			- Boton de citas: apareceran las citas de todos los medicos registrados, solo los medicos podran consultar
			o eliminar citas que esten a su nombre, es decir que se le hayan solicitado a el. Los demas usuarios no 
			podran consultar o eliminar citas.
			- Boton de recetas: apareceran todas las recetas de todos los medicos, solo los medicos podran crear recetas a
			su nombre para un acampado especifico, consultar y eliminar sus recetas. Donde el resto de usuarios no tendran
			interacción con las recetas.
			
		- Boton Comedor:
		 
		- Boton Contabilidad: aparecera un menu con tres botones:
			- Boton de Gastos: En el aparecera un menu con cuatro botones:
				- Mostrar Gastos: Se mostrara la lista de gastos del campamento
				- Añadir Gasto: Se podra añadir un nuevo gasto, teniendo la opcion de contabilizar la cuenta (en este caso 
				no se podra eliminar y a la hora de modificar tendra limitaciones).
				- Eliminar Gasto: Podra seleccionar el gasto que se quiere eliminar mediante el numero de factura
				- Modificar Gasto: Permite modificar el gasto seleccionado mediante el numero de factura.
			
			- Boton de Ingresos: En el aparecera un menu con cuatro botones:
				- Mostrar Ingresos: Se mostrara la lista de ingresos del campamento
				- Añadir Ingresos: Se podra añadir un nuevo ingreso, teniendo la opcion de contabilizar la cuenta (en este caso 
				no se podra eliminar y a la hora de modificar tendra limitaciones).
				- Eliminar Ingreso: Podra seleccionar el ingreso que se quiere eliminar mediante el numero de factura
				- Modificar Ingreso: Permite modificar el ingreso seleccionado mediante el numero de factura.
			
			- Rendimiento: Apareceran la totalidad de ingresos y de gastos del campamento, asi como el rendimiento neto
			del ejercicio mostrando si tiene ganacias o perdidas.
		
		- Boton Gestoria: Apareceran cuatro botones:
			-Boton Limpieza: Apareceran cuatro Botones:
				- Boton Mostrar Horarios: aparecera la lista de horarios de limpieza del campamento
				- Boton Añadir Horario: se podra añadir un nuevo horario de limpieza, especificando un de los empleados de
				limpieza registrados asi como de la instalción que se vaya a limpiar.
				- Boton Modificar Horarios: se podran modificar los horarios de limpieza seleccionando su codigo.
				- Boton Eliminar: se eleminara el horario de limpieza del codigo elegido.
				
			- Boton Instalaciones: apareceran cuatro botones:
				- Boton Mostrar Instalaciones: aparecera la lista de instalaciones del campamento
				- Boton Modificar instalacion: se podran modificar las instalaciones 
				- Boton Añadir instalacion: se podra añadir una nueva instalación
				- Boton eliminar instalación: se podra eliminar una instalacion
				
			- Boton Añadir empleado: se podra crear un nuevo empleado, teniendo en cuenta que el usuario y el nombre 
			introducidos no coincidan con uno ya existente.
	
	- Tambien 	