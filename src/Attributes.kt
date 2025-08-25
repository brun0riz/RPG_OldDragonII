// Data class serve para armazenar os dados
data class Attributes(
    // Atributos relacionados as regras do RPG
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int
) {
    // Objetos das campanhas
    companion object {
        fun rollClassic(d6: D6): Attributes {
            return Attributes(
                strength = d6.roll(3).sum(),
                dexterity = d6.roll(3).sum(),
                constitution = d6.roll(3).sum(),
                intelligence = d6.roll(3).sum(),
                wisdom = d6.roll(3).sum(),
                charisma = d6.roll(3).sum()
            )
        }

        fun rollAdventurer(d6: D6): Attributes {
            // Rolls 6 values
            val rolls = List(6) { d6.roll(3).sum() }
            println("Valores rolados: $rolls")

            // Map attributes
            val attributes = mutableMapOf<String, Int>()
            val remainingRolls = rolls.toMutableList() // lista mutável correta
            val names = listOf("strength", "dexterity", "constitution", "intelligence", "wisdom", "charisma")

            // Allows the user to choose the values
            for (name in names) {
                println("Escolha um valor para $name a partir da lista: $remainingRolls")
                var chosen: Int? = null
                while (chosen == null) {
                    val input = readLine()?.toIntOrNull()
                    if (input != null && remainingRolls.contains(input)) {
                        chosen = input
                        remainingRolls.remove(input) // remove corretamente da lista mutável
                        attributes[name] = chosen
                    } else {
                        println("Valor inválido. Tente novamente.")
                    }
                }
            }

            return Attributes(
                strength = attributes["strength"]!!,
                dexterity = attributes["dexterity"]!!,
                constitution = attributes["constitution"]!!,
                intelligence = attributes["intelligence"]!!,
                wisdom = attributes["wisdom"]!!,
                charisma = attributes["charisma"]!!
            )
        }

        fun rollHeroic(d6: D6) : Attributes{
            val rolls = mutableListOf<Int>()

            // Rolls 4 times each attribute, take the top 3, add the rest
            repeat(6){
                val dice = d6.roll(4)
                val sumTop3 = dice.sortedDescending().take(3).sum()
                rolls.add(sumTop3)
            }
            println("Valores rolados (4d6 drop lowest): $rolls")

            // Mapeia os atributos
            val attributes = mutableMapOf<String, Int>()
            val names = listOf("strength", "dexterity", "constitution", "intelligence", "wisdom", "charisma")
            val remainingRolls = rolls.toMutableList()

            // Permite ao usuário distribuir os valores
            for (name in names) {
                println("Escolha um valor para $name a partir da lista: $remainingRolls")
                var chosen: Int? = null
                while (chosen == null) {
                    val input = readLine()?.toIntOrNull()
                    if (input != null && remainingRolls.contains(input)) {
                        chosen = input
                        remainingRolls.remove(input)
                        attributes[name] = chosen
                    } else {
                        println("Valor inválido. Tente novamente.")
                    }
                }
            }

            return Attributes(
                strength = attributes["strength"]!!,
                dexterity = attributes["dexterity"]!!,
                constitution = attributes["constitution"]!!,
                intelligence = attributes["intelligence"]!!,
                wisdom = attributes["wisdom"]!!,
                charisma = attributes["charisma"]!!
            )
        }
    }
}
