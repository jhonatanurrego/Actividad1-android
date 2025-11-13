package com.ecommerce.miaplicacion


sealed class AppsScreen(val route: String){
    object inicio: AppsScreen("incio")
    object detalle: AppsScreen("detalle")

}
