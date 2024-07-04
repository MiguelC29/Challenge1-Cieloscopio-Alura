# ⛅ Challenge1-Cieloscopio-Alura 🌧️
Este proyecto corresponde al primer desafío del Bootcamp de Back-end con Java de Alura Latam. Se ha desarrollado una aplicación de consola en Java llamada Cieloscopio, que consume la API del clima [**Open Weather App**](https://openweathermap.org/).

## 🔨 Funcionalidades del proyecto
- Consultar el clima de una lista de ciudades preestablecida que incluye: "Ciudad de México", "Buenos Aires", "Bogotá", "Lima", "Santiago de Chile", "Quito", "San Salvador", "Montevideo", "Caracas", "Panamá", "La Habana".
- Consultar el clima de una ciudad ingresada por el usuario.
- Consultar la predicción del clima de una ciudad para los próximos 3 días.

## 🖥️ App en Funcionamiento
  ![funcionamiento_cieloscopio](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/a2af26d8-7256-4fdd-8c6e-d2cb790efd1a)
- Capturas de los resultados mostrados <br/>
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/6d8ddf2c-06f5-4741-9651-e3403cf0281e" width="400" />
  
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/634d8f81-ae7b-4f54-a79b-1db67f24bca3" width="400" />


## 📋 Requisitos
- **Java 11** o superior.
- API Key de Open Weather App.
- Biblioteca Gson **2.10.1** o superior.

## 📁 Acceso y Ejecución del Proyecto
- **Clonación con Git:** Si tienes instalado Git, haz clic en el botón "Code", copia la URL del repositorio y en la terminal (cmd o Git Bash) ejecuta el siguiente comando:
  ```bash
  git clone https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura.git
- **Descarga como ZIP:** Si no tienes Git, puedes descargar el proyecto como archivo ZIP.
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/5fa0c407-faba-4f3d-ac90-2553c781e732" width="650" />
  
- **Ejecución:** Una vez realizada la [configuración](#%EF%B8%8F-configuración), navega a la carpeta `src` y ejecuta el archivo `Main`. Puedes hacerlo presionando el botón "Play" en tu IDE o haciendo clic derecho en `Main` y seleccionando "Run 'Main.main()'". <br/>

  ![Ejecución](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/e43b7fc6-178a-4ec4-996f-f356b7bf54ca)


## ⚙️ Configuración
### Descargar la Dependencia de Gson
- Descarga la dependencia de [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson), en este caso se utilizó la versión ``versión 2.11.0``.
  - Puedes descargar el archivo JAR desde [aquí](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0). <br/>
    <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/cb58d3bf-17ad-4e69-97f8-05335707a730" width="400"/>

### Importar la Dependencia de Gson
- Abre tu IDE y navega a `File` > `Project Structure`. <br/>

  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/f6372996-06c2-4d9d-928f-4725a46c0945" width="250"/>
- En `Project Settings`, selecciona `Modules`. <br/>

  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/c39b1ff3-b9fe-427d-81f8-26576b2bc470" width="100"/>
  
- En `Dependencies`, haz clic en el botón `+` y selecciona `JARs or Directories...`.
  
  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/f4e66f99-fb6e-4308-a173-5af1ae5c3ac7" width="600"/>
- Selecciona el archivo JAR descargado, luego haz clic en `OK`, `APPLY` y `OK`. <br/>

  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/cb41419a-9383-4a15-b7c3-39ad2245ced2" width="450"/>

### Generar API KEY
- Puedes seguir este [video](https://youtu.be/MdIfZJ08g2I?si=LSE67WgkFPlMFmQ7&t=33) para generar tu API Key o seguir estos pasos:
  * Ingresa a [Open Weather API](https://openweathermap.org/api).
  * Crea una cuenta o inicia sesión.
  * En la parte superior derecha, haz clic en tu nombre de usuario y selecciona `My API Keys`. <br/>
    ![My API Keys](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/5112e322-2886-4b05-95e4-e032665ca7b7)
  * En `Create Key`, ingresa un nombre para tu clave y haz clic en `Generate`. <br/>

    ![Generate Key](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/7cf80aa2-cc00-4ee0-8d95-7444c3f54231)
  * Una vez generada, la API Key puede tardar hasta 24 horas en activarse.

### Importar API Key
- Renombra el archivo `.env.copy` a `.env`.
- Abre el archivo `.env` y reemplaza `YOUR_API_KEY` con tu API Key.
- En la barra de búsqueda de tu IDE, busca `Modify Run Configuration`.

  ![Modify Run Configuration](https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/925d1597-47f6-44b3-bb9c-517d5f9613d9)
- En `Environmental variables`, agrega la ruta del archivo `.env` configurado en el paso anterior. Haz clic en `APPLY` y `OK`.

  <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/749984ff-b42d-4a7e-9586-d5c692d01474" width="400" />

## 💻 Realizado por
Miguel Ángel Casallas <img src="https://github.com/MiguelC29/Challenge1-Cieloscopio-Alura/assets/119911328/7e76a60b-4a2e-4272-83d9-ccf75eaec68f" width="20" />
