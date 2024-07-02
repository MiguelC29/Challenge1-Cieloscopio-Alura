# Challenge1-Cieloscopio-Alura
El siguiente proyecto corresponde al primer desafío del Bootcamp de Back-end con Java de Alura Latam, en el que se desarrolló una aplicación Java de consola llamada Cieloscopio, en donde se consume una API del clima llamada [**Open Weather App**](https://openweathermap.org/)

🏁 El proyecto casi finalizado 🏁 <br/>
❗ 🚧 Se esta trabajando para implementar datos sobre las predicciones del clima 🚧

## 🔨 Funcionalidades del proyecto
- `Funcionalidad 1`: puede consultar el clima de una lista de ciudades preestablecida
- `Funcionalidad 2`: puede consultar el clima de una ciudad de tu preferencia ingresandola por medio del teclado

## 📁 Acceso al proyecto
- Si tiene instalado git solo es darle click al botón code, luego copiar la url y por último ir a la carpeta donde desea que se descargue el proyecto abrir un cmd o git bash e ingresar el siguiente comando ``git clone URL_PROYECTO``.
- Si por el contrario no tiene instalado git, puede descargarlo como archivo ZIP <br/>
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/5fa0c407-faba-4f3d-ac90-2553c781e732" width="600" />

## 🛠️ Abre y ejecuta el proyecto
- En su IDE de preferencia que puede ser Intellij IDEA, Neatbeans, Eclipse, etc, abrá el proyecto.
- Configure la dependencia [Gson](/#descargar-la-dependencia-de-gson)
- Configure la API KEY, primero si aún no la tiene [genere la API kEY](/#generar-api-key)

## Configuración
### Descargar la dependencia de Gson
- Debe descargar la dependencia de [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson) en mi caso use la ``versión 2.11.0``
  * Para ello puede ingresar al siguiente [enlace](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0) y seleccionar JAR <br />
    <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/cb58d3bf-17ad-4e69-97f8-05335707a730" width="400"/>
#### Importar la dependencia de Gson
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

## Requisitos
- ``Java 11`` o superior
- API KEY de la API: Open Weather App
- Biblioteca Gson ``2.10.1`` o superior

## App en Funcionamiento
- [gif]
- [image]

## 💻 Realizado por 👨‍🦱
Miguel Angel Casallas
