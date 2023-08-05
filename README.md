# `Automatización de pruebas App Exito en desktop`

#### Descripción

Proyecto de Automatización de pruebas web de la plataforma Exito con JAVA, Serenity BDD y Gradle.

#### Característica: Validar la compra de artículos en el carrito

> **Como** usuario incógnito de Exito

> **Yo** quiero acceder a la aplicación

> **Y** seleccionar artículos y unidades

>**Para** validar en el carrito los productos seleccionados 

#

#### Características del Proyecto

En la construcción del proyecto de automatizacion en la plataforma Exito se implementa:

- Patrón de diseño de Screemplay.
- Framework SerenityBDD.
- Gestor de paquetes Gradle 7.
- Desarrollado en java en su versión 11

#### Versionado

| Repository       | Version |
|------------------|---------|
| Serenity         | 2.5.7   |
| SerenityCucumber | 2.5.7  |
| SerenityEnsure   | 2.5.7  |
| Slf4jSimple      | 1.7.30  |
| Junit            | 4.13.1  |

#### Precondiciones

- [x] 1: Instar Java en su versión 8.x.
- [x] 1.1: Configurar variable de entorno JAVA_HOME.
- [x] 2: Instar Gradle en su versión 8.X.

#### Ejecución del proyecto

Para la ejecución del proyecto se debe implementar el siguiente comando en el terminal del directorio raíz del
proyecto:

- si no tienes Gradle o una version menor que la 7.x.x, ejecuta el siguiente comando:

```sh
./gradlew clean test 
```

- si tienes gradle instalado y configurado puedes ejecutar el siguiente comando:

```sh
gradle clean test 
```