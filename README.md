# Info
Cuando un jugador ejecuta /strikes add <nombre_facción>, se agrega un strike a esa facción.
Cuando un jugador ejecuta /strikes remove <nombre_facción>, se elimina un strike de esa facción.
Los strikes de cada facción se almacenan en un Map<String, Integer> donde la clave es el nombre de la facción y el valor es la cantidad de strikes.
Este es solo un esquema básico. Puedes expandir este plugin agregando más funcionalidades según tus necesidades, como guardar los datos de los strikes en un archivo o base de datos, implementar un límite máximo de strikes antes de tomar acciones adicionales, agregar mensajes de confirmación, etc.
Recuerda registrar este plugin en tu servidor de Minecraft y otorgar los permisos necesarios para que los jugadores puedan ejecutar el comando /strikes. Además, asegúrate de manejar los errores y excepciones adecuadamente para un funcionamiento robusto del plugin.
