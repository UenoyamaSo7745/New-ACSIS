# ACSIS - Mágicas Medicinas 💊

## Descripción
ACBD es una aplicación móvil Android diseñada para ayudarte a recordar y gestionar tus medicamentos de manera fácil y divertida, con una temática inspirada en el anime Konosuba.

## Características 🎮

- **Dashboard**: Visualiza tu próxima dosis y medicamentos activos
- **Gestión de Medicamentos**: Agrega, edita y elimina medicamentos
- **Recordatorios**: Configura recordatorios automáticos para tus medicamentos
- **Historial**: Mantén un registro de dosis tomadas y faltantes
- **Perfil**: Gestiona tu información personal y emergencias
- **Notificaciones**: Recibe notificaciones en tiempo real

## Tecnologías Utilizadas 🛠️

- **Lenguaje**: Kotlin
- **IDE**: Android Studio Panda 4
- **Base de Datos**: Room Database
- **Arquitectura**: MVVM (Model-View-ViewModel)
- **UI**: Material Design 3
- **Navegación**: Navigation Component
- **Async**: Coroutines & Flow

## Estructura del Proyecto 📁

```
app/src/main/
├── java/com/acsis/medicamentos/
│   ├── ui/
│   │   ├── activity/        # Activities
│   │   ├── fragment/        # Fragments
│   │   └── adapter/         # Adapters
│   ├── data/
│   │   ├── entity/          # Modelos de BD
│   │   ├── dao/             # Data Access Objects
│   │   └── database/        # Room Database
│   ├── repository/          # Repositorios
│   ├── service/             # Servicios
│   └── util/                # Utilidades
├── res/
│   ├── layout/              # XML Layouts
│   ├── drawable/            # Recursos gráficos
│   ├── values/              # Strings, colores, estilos
│   ├── navigation/          # Gráficos de navegación
│   └── menu/                # Menús
└── AndroidManifest.xml      # Configuración de la app
```

## Pantallas Principales 📱

### 1. Splash
- Pantalla de bienvenida con branding de la app
- Transición automática a Login

### 2. Login
- Autenticación de usuarios
- Enlace a registro

### 3. Registro
- Formulario para crear nueva cuenta
- Validaciones de campos

### 4. Dashboard
- Próxima dosis
- Medicamentos activos
- Botón para agregar medicamento

### 5. Mis Pastillas
- Lista de medicamentos registrados
- Edición y eliminación

### 6. Historial
- Resumen semanal de dosis
- Calendario de medicamentos
- Próximo recordatorio

### 7. Perfil
- Información del usuario
- Contacto de emergencia
- Ajustes
- Cerrar sesión

## Cómo Empezar 🚀

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/UenoyamaSo7745/New-ACSIS.git
   ```

2. **Abrir en Android Studio**
   - Abre Android Studio Panda 4
   - Selecciona "Open an existing project"
   - Navega a la carpeta del proyecto

3. **Sincronizar Gradle**
   - Android Studio sincronizará automáticamente
   - Espera a que se descarguen todas las dependencias

4. **Ejecutar la app**
   - Selecciona un emulador o dispositivo físico
   - Click en "Run" o presiona Shift + F10

## Dependencias Principales 📦

```gradle
// AndroidX
androidx.core:core-ktx
androidx.appcompat:appcompat
androidx.constraintlayout:constraintlayout
androidx.lifecycle:lifecycle-runtime-ktx
androidx.lifecycle:lifecycle-viewmodel-ktx
androidx.fragment:fragment-ktx

// Material Design
com.google.android.material:material

// Room Database
androidx.room:room-runtime
androidx.room:room-ktx

// WorkManager
androidx.work:work-runtime-ktx

// Coroutines
org.jetbrains.kotlinx:kotlinx-coroutines-android
org.jetbrains.kotlinx:kotlinx-coroutines-core

// Retrofit (opcional para API)
com.squareup.retrofit2:retrofit
com.squareup.retrofit2:converter-gson
```

## Flujo de Autenticación 🔐

1. Usuario inicia sesión o se registra
2. Credenciales se almacenan en Room Database
3. ID de usuario se guarda en SharedPreferences
4. Acceso a Dashboard y otras pantallas
5. Cierre de sesión limpia SharedPreferences

## Sistema de Recordatorios ⏰

- Utiliza AlarmManager para programar recordatorios
- Notificaciones en tiempo real
- Servicio en segundo plano para gestionar alarmas
- Soporte para múltiples recordatorios por medicamento

## Tema Konosuba 🎨

La app utiliza una paleta de colores inspirada en Konosuba:

- **Rojo/Naranja**: Color primario (temático de magos)
- **Aqua/Turquesa**: Color secundario (referencia a Aqua)
- **Dorado**: Acentos (magia arcana)
- **Púrpura**: Elementos decorativos

## Autor 👨‍💻

Desarrollado por: UenoyamaSo7745

## Licencia 📄

Este proyecto es privado. Todos los derechos reservados.

## Contribuciones 🤝

Para contribuir:
1. Haz un fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Soporte 💬

Para preguntas o problemas, crea un issue en el repositorio.

---

**Hecho con ❤️ y magia arcana** ✨
