import kotlin.system.measureTimeMillis
import kotlin.time.measureTime
fun imprimirlistas(lista:List<String>){
    lista.forEach{
        println(it)
    }}
fun ordenamientoKotlin(lista:List<String>):List<String>{
    return lista.sorted()
}
fun tiempoQuickSort(items:List<String>) {
    var lista : List<String>
    var tiempo = measureTimeMillis {

    lista = quicksort(items)
       }
    println("demoro  $tiempo milisegundos")

    lista.forEach{
        println(it)
}}
fun <T:Comparable<T>>quicksort(items:List<T>):List<T>{
    if (items.count() < 1) return items
    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quicksort(less) + equal + quicksort(greater)


}

fun  <T:Comparable<T>>mergesort(items:MutableList<T>):MutableList<T>{
    if (items.isEmpty()){
        return items
    }

    fun merge(left:MutableList<T>, right:MutableList<T>):MutableList<T>{
        var merged: MutableList<T> = arrayListOf<T>()
        while(!left.isEmpty() && !right.isEmpty()){
            val temp:T
            if (left.first() < right.first()) {
                temp = left.removeAt(0)
            } else {
                temp = right.removeAt(0)
            }
            merged.add(temp)
        }
        if (!left.isEmpty()) merged.addAll(left)
        if (!right.isEmpty()) merged.addAll(right)

        return merged
    }

    val pivot = items.count()/2

    var left  = mergesort(items.subList(0, pivot))
    var right = mergesort(items.subList(pivot, items.count()-1))

    return merge(left, right)
}
fun tiempoMergeSort(elementos: List<String>) {


    var lista: List<String>
    var tiempo = measureTimeMillis {

        lista = mergesort(elementos.toMutableList())
    }
    println("demoro  $tiempo milisegundos")

    lista.forEach {
        println(it)

    }
}
//metodo burbuja no se puede ocupar la lista ya que no se le puede modificar ningun dato y de tal caso no se puede intercambiar

fun burbuja(lista : ArrayList<String>):ArrayList<String>{

    for(i in 0 until lista.size -1){
        for(j in 0 until lista.size -1){
            if(lista[j]> lista[j+1]) {
                var aux = lista[j]
                lista[j]= lista[j + 1]
                lista[j + 1]= aux
            }
        }}
    return lista
}
fun tiempoBurbujaSort(items:ArrayList<String>) {

    var lista: ArrayList<String>
    var tiempo = measureTimeMillis {

        lista = burbuja(items)
    }

    println("demoro  $tiempo milisegundos")

    lista.forEach {
        println(it)

    }
}




