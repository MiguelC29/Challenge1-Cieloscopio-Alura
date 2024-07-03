# Challenge1-Cieloscopio-Alura
El siguiente proyecto corresponde al primer desafío del Bootcamp de Back-end con Java de Alura Latam, en el que se desarrolló una aplicación Java de consola llamada Cieloscopio, en donde se consume una API del clima llamada [**Open Weather App**](https://openweathermap.org/)

🏁 El proyecto casi finalizado 🏁 <br/>
❗ 🚧 Se esta trabajando para implementar datos sobre las predicciones del clima 🚧

## 🔨 Funcionalidades del proyecto
- `Funcionalidad 1`: puede consultar el clima de una lista de ciudades preestablecida
- `Funcionalidad 2`: puede consultar el clima de una ciudad de tu preferencia ingresandola por medio del teclado

## App en Funcionamiento
- [gif]
- [image]

## Requisitos
- ``Java 11`` o superior
- API KEY de la API: Open Weather App
- Biblioteca Gson ``2.10.1`` o superior

## 📁 Acceso y ejecución del proyecto
- Si tiene instalado git solo es darle click al botón code, luego copiar la url y por último ir a la carpeta donde desea que se descargue el proyecto abrir un cmd o git bash e ingresar el siguiente comando ``git clone URL_PROYECTO``.
- Si por el contrario no tiene instalado git, puede descargarlo como archivo ZIP <br/>
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/5fa0c407-faba-4f3d-ac90-2553c781e732" width="600" />
- Una vez realizada toda la [configuración](#configuración), solo es acceder a la carpeta src y el archivo 'Main' y darle al botón play que aparece en la parte superior
O desde el archivo Main, dar click derecho y a la opción Run 'Main.main()'
![image](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/e43b7fc6-178a-4ec4-996f-f356b7bf54ca)


## Configuración
### Descargar la dependencia de Gson
- Debe descargar la dependencia de [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson) en mi caso use la ``versión 2.11.0``
  * Para ello puede ingresar al siguiente [enlace](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0) y seleccionar JAR <br />
    <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/cb58d3bf-17ad-4e69-97f8-05335707a730" width="400"/>
### Importar la dependencia de Gson
- Debe ingresar a 'file' (Archivo) y 'project structure' (Estructura del proyecto) <br/>
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/f6372996-06c2-4d9d-928f-4725a46c0945" width="200"/>
- En 'Project Settings' (Configuración del proyecto), seleccionamos la opción Modules (Módulos) <br/>
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/c39b1ff3-b9fe-427d-81f8-26576b2bc470" width="150"/>
- En 'Dependencies' (Dependencias), le damos click al botón + y luego a 'JARs or Directories...' <br/>
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/f4e66f99-fb6e-4308-a173-5af1ae5c3ac7" width="600"/>
- Selecciona el Jar que descargó y luego 'OK', 'APPLY'(aplicar) y nuevamente 'OK'<br/>
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/cb41419a-9383-4a15-b7c3-39ad2245ced2" width="400"/>

### Generar API KEY
- Puede ver el siguiente [video](https://youtu.be/MdIfZJ08g2I?si=LSE67WgkFPlMFmQ7&t=33) del paso a paso para generar una API KEY o leer el paso a paso a continuación: 
  * Ingrese al siguiente enlace [Open Weather API](https://openweathermap.org/api)
  * Cree una cuenta o si ya tiene una cuenta inicie sesión
  * Una vez iniciada la sesión, en la parte superior derecha, donde aparece su nombre de usuario dar click, luego en la opción de 'My API Keys' <br/>
    ![image](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/5112e322-2886-4b05-95e4-e032665ca7b7)
  * En la sección de Create Key, ingresamos el nombre que le queremos dar a nuestra clave y luego le damos click a botón Generate
    ![image](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/7cf80aa2-cc00-4ee0-8d95-7444c3f54231)
  * Y listo tendremos nuestra API Key, tenga presente que la activación de la misma puede tardar hasta 24 horas

### Importar API Key
- Luego de haber descargado el proyecto, encontrara un archivo llamada .env.copy, debe renombrarlo y poner .env
- Despues abra ese archivo y donde 'YOUR_API_KEY' reemplace por su api key
- Por último el la barra de busqueda, en la pestaña de actions, ingrese lo siguiente 'modify run Configuration'<br/>
![img](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/4f8ae648-d43b-4836-a82a-c18746995d76)
 ![image](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/925d1597-47f6-44b3-bb9c-517d5f9613d9)
 <br/>
- Se le debe desplegar una ventana como la siguiente: <br/>
<img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/3749ed8a-4a2c-4759-aec3-0b5744f7480f" width="400" />
 <br/>
- Solo es donde dice 'Enviromental variables' agregar la ruta del archivo .env configurado en el anterior paso, darle apply y luego ok y listo <br/>
<img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/749984ff-b42d-4a7e-9586-d5c692d01474" width="400" />

## 💻 Realizado por 👨‍🦱
Miguel Angel Casallas
