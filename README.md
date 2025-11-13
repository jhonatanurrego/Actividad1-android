Navegación Entre Pantallas

Autores: Jhonatan Vasquez Urrego y Daniel López Afanador

Descripción

Este trabajo implementa la navegación entre pantallas de una aplicación Android. Se mapean las pantallas y se configura un NavHost donde la pantalla de detalles recibe tres argumentos: título, imagen y descripción.

Estructura y modelo de datos

Se creó una DataClass para representar cada elemento con los campos: imagen, título y descripción.
Se usa una lista mutable que contiene los objetos (imágenes con su título y descripción) que alimentan la UI.

Pantalla de Inicio

Incluye un Scaffold con TopBar, BottomBar y el contenido principal.
El contenido principal contiene una LazyRow que muestra 5 ítems (las imágenes).
Cada ítem en la LazyRow:
Tiene sus estilos y su ruta de imagen.
Es clickable: al pulsarlo envía los atributos (título, imagen y descripción) y navega a la pantalla de detalles.


Pantalla de Detalles

Recibe los argumentos enviados desde la pantalla de inicio: imagen, título y descripción.
Está construida también con un Scaffold que incluye TopBar y BottomBar.
Contiene un botón en la barra inferior para volver a la pantalla anterior.
El contenido de detalles es una LazyColumn que muestra:
La imagen (con estilos aplicados) y un comportamiento clickable para poder agrandar la imagen.
Un ítem separado que muestra la descripción.


Flujo de navegación (resumen)
@Composable
fun app(){
    inicio()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inicio(){

    Scaffold(
        topBar = {
            // Barra superior con título
            TopAppBar(
                title = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.flechaatras),
                            contentDescription = "d",
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                    Text(
                        "SHIRTS",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 11.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1f1f29),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            // Barra inferior vacía, reservada para futuros elementos
            BottomAppBar(
                containerColor = Color(0xFF383840),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.libro),
                            "icono",
                            modifier = Modifier
                                .padding(4.dp),
                            tint = Color.White
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.lupa),
                            "icono",
                            modifier = Modifier
                                .padding(4.dp),
                            tint = Color.White
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.corazon),
                            "icono",
                            modifier = Modifier
                                .padding(4.dp),
                            tint = Color.White
                        )
                    }
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.usuario),
                            "icono",
                            modifier = Modifier,
                            tint = Color.White
                        )
                    }
                }
            }
        },
        // Color de fondo general de la pantalla
        containerColor = Color(0xFF202028)
    ) {
        // Contenedor principal de la galería
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {


        }
    }
}
La pantalla de inicio muestra una fila horizontal con 5 imágenes.
Al hacer clic en una imagen, se envían título, imagen y descripción a través del NavHost.
La pantalla de detalles recibe esos argumentos y muestra la imagen (posible ampliación al hacer clic) y la descripción.
Desde detalles se puede regresar a la pantalla anterior usando el botón provisto en la BottomBar.
