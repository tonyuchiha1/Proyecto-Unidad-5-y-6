import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun busquedaporkotlin(list: List<String>, valorAbuscar:String) {

    var tiempo = measureTimeMillis {

        val valorEncontrado = list.find { nombre ->
            nombre.contains(valorAbuscar)
        }
        println(valorEncontrado)
    }
    println("demoro  $tiempo milisegundos")
}

fun busquedaLineal(list: List<String>, valorABuscar: String): Int? {

    var tiempo = measureNanoTime {
        for ((index, valor) in list.withIndex()) {
            if (valor == valorABuscar) {

                println("POSICION ENCONTRADA: $index -> $valor")
                return index
            }
        }
    }

    println("TIEMPO BUSQUEDA LINEAL: $tiempo")



    return null

}
fun busquedaBinaria(list: List<String>, key: String): Int? {
        var n=list.size
        var rangeStart = 0
        var rangeEnd =n-1
        var midIndex=0
        while (rangeStart <= rangeEnd) {
             midIndex = (rangeEnd + rangeStart) / 2
            if (list[midIndex] == key) {
              //  println("INDEX ENCONTRADO: $midIndex")
                return midIndex
            } else if (list[midIndex] > key) {
                rangeEnd = midIndex-1
            } else {
                rangeStart = midIndex+1
            }
        }
        return -1
}
//Es el que hara que retorne aun numero entero Y ESE NUMERO ENTERO ES LA POSICION DEL NOMBRE QUE ESTAMOS BUSCANDO

fun busquedaporbinaria(list: List<String>, valorAbuscar:String):Int? {
    var valorEncontrado = 0
    var tiempo = measureTimeMillis {

        valorEncontrado = busquedaBinaria(list, valorAbuscar)!!
        if (valorEncontrado == (-1)) {
            println("No se encontro ese nombre")
        } else {
            println("INDEX ENCONTRADO: $valorEncontrado")
        }
    }
    println("demoro  $tiempo milisegundos")

    return valorEncontrado
    }



