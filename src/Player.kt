class Player {
    var name: String = ""
    var attributes: Attributes? = null
    var race: Race? = null
    var characterClass: CharacterClass? = null

    // Exibir as informações do jogador
    fun showPlayerProfile() {
        println("\n--- FICHA DO PERSONAGEM ---")
        println("Nome: $name")

        race?.let {
            println("Raça: ${it.name}")
            println("Habilidades Raciais: ${it.abilities.joinToString { ability -> ability.name }}")
        }

        characterClass?.let {
            var className = it.name
            if (it.specialization != null) {
                className += " (${it.specialization.name})"
            }
            println("Classe: $className")
        }

        attributes?.let {
            println("\n--- Atributos ---")
            println("Força: ${it.strength} | Destreza: ${it.dexterity} | Constituição: ${it.constitution}")
            println("Inteligência: ${it.intelligence} | Sabedoria: ${it.wisdom} | Carisma: ${it.charisma}")
        }
        println("---------------------------\n")
    }
}