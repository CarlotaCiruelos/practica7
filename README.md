# practica7
En esta práctica he realizado un API-Rest con SpringBoot
## Capas de las llamadas: 
### Index.html: 
Dos formularios que llaman a dos endpoints diferentes para hacer dos gets a la API. 
Si todo ha ido correctamente se devuelve un body con los datos que se pasan a formato json y sino, devulve un array vacío. 
Dependiendo de la vuelta se mostrará un resultado por pantalla. 
### Controller: 
Llega al endpoint que ha llamado el formulario y llama a service con los párametros pasados en la llamada
### Service: 
Con un RestTemplate se hace una llamada a la API y con un try, comprobamos que no se produce ninguna NullPointException, al intentar pasar los datos a nuestra clase. 
Si hay un error, este método devolverá una lista vacía. 
