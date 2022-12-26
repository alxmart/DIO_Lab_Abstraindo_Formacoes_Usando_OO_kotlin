data class Usuario(val nome: String, val cod: Int)

data class ConteudoEducacional(val nome: String)

data class Formacao(

    val nome: String,
    val conteudos: List<ConteudoEducacional>
) {
    val matriculados = mutableListOf<Usuario>()

    infix fun matricular(usuario: Usuario) {
        matriculados.add(usuario)
    }

    fun listarConteudosEduc() {
        for (conteudo in conteudos)
            println(conteudo.nome)
    }

    fun listarMatriculados() {
        //for (inscrito in matriculados)
        for (matriculado in matriculados)
            println(matriculado.nome)
    }

}

fun main() {

    val homer = Usuario("Homer Simpson", 1)
    val flanders = Usuario("Ned Flanders", 2)
    val nelson = Usuario("Nelson Muntz", 3)
    val moe = Usuario("Moe Szyslak", 4)

    val listaConteudosKotlinExp: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("O Poder das Funções em Kotlin"),
        ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin")
    )
    val kotlinExperience = Formacao("Kotlin Experience", listaConteudosKotlinExp)

    kotlinExperience?.let {
        kotlinExperience.matricular(homer)
        kotlinExperience.matricular(flanders)
        kotlinExperience.matricular(nelson)
        kotlinExperience.matricular(moe)
    }

    println("Formacao:")
    println("---------")
    println("${kotlinExperience.nome}")
    println()

    println("Conteúdos Educacionais:")
    println("-----------------------")
    kotlinExperience.listarConteudosEduc()
    println()

    println("Matriculados:")
    println("-------------")
    kotlinExperience.listarMatriculados()

}