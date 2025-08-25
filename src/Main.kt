fun main() {
    val player = Player()
    val d6 = D6()

    println("--- BEM-VINDO À CRIAÇÃO DE PERSONAGEM DE OLD DRAGON 2 ---")

    // Nome
    println("\nQual o nome do seu personagem?")
    player.name = readlnOrNull() ?: "Aventureiro Sem Nome"

    // Atributos
    player.attributes = rollAttributes(d6)

    // Raça
    player.race = selectRace()

    // Classe (com filtro baseado na raça)
    player.characterClass = selectClass(player.race!!)

    // Ficha Final
    println("\nParabéns! Personagem criado com sucesso!")
    player.showPlayerProfile()
}

fun selectClass(playerRace: Race): CharacterClass {
    // Mapa de todas as classes disponíveis no jogo
    val allGameClasses = mapOf(
        Warrior::class to listOf(Barbarian, Paladin),
        Cleric::class to listOf(Druid, Academic),
        Thief::class to listOf(Ranger, Bard),
        Mage::class to listOf(Illusionist, Necromancer)
    )

    // Filtra o mapa para conter apenas as classes permitidas para a raça do jogador
    val availableClasses = allGameClasses.filterKeys { it in playerRace.allowedClasses }

    while (true) {
        println("\nCom base na sua raça (${playerRace.name}), escolha sua classe:")
        val classOptions = availableClasses.keys.toList()
        classOptions.forEachIndexed { index, kClass ->
            println("${index + 1}: ${kClass.simpleName}")
        }
        print("Opção: ")
        val choice = readlnOrNull()?.toIntOrNull()

        if (choice != null && choice in 1..classOptions.size) {
            val chosenClass = classOptions[choice - 1]
            val specializations = availableClasses[chosenClass]

            var chosenSpecialization: Specialization? = null
            if (!specializations.isNullOrEmpty()) {
                chosenSpecialization = selectSpecialization(specializations)
            }

            // Cria uma instância da classe escolhida
            return when (chosenClass) {
                Warrior::class -> Warrior(chosenSpecialization as WarriorSpecialization?)
                Cleric::class -> Cleric(chosenSpecialization as ClericSpecialization?)
                Thief::class -> Thief(chosenSpecialization as ThiefSpecialization?)
                Mage::class -> Mage(chosenSpecialization as MageSpecialization?)
                else -> throw IllegalStateException("Classe desconhecida")
            }
        } else {
            println("Opção inválida. Tente novamente.")
        }
    }
}

fun selectSpecialization(specializations: List<Specialization>): Specialization? {
    while (true) {
        println("\nDeseja escolher uma especialização?")
        println("1: Sim")
        println("2: Não")
        print("Opção: ")

        when(readlnOrNull()) {
            "1" -> {
                println("\nEscolha sua especialização:")
                specializations.forEachIndexed { index, spec ->
                    println("${index + 1}: ${spec.name}")
                }
                print("Opção: ")
                val choice = readlnOrNull()?.toIntOrNull()
                if (choice != null && choice in 1..specializations.size) {
                    return specializations[choice - 1]
                } else {
                    println("Opção inválida.")
                }
            }
            "2" -> return null
            else -> println("Opção inválida.")
        }
    }
}

fun rollAttributes(d6: D6): Attributes {
    while (true) {
        println("\nEscolha o método de rolagem de atributos:")
        println("1: Clássico (3d6 para cada atributo)")
        println("2: Aventureiro (role 6 valores com 3d6 e distribua)")
        println("3: Heróico (role 6 valores com 4d6, ignore o menor, e distribua)")
        print("Opção: ")

        when (readlnOrNull()) {
            "1" -> return Attributes.rollClassic(d6)
            "2" -> return Attributes.rollAdventurer(d6)
            "3" -> return Attributes.rollHeroic(d6)
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun selectRace(): Race {
    val races = listOf(Race.Human, Race.Elf, Race.Dwarf, Race.Halfling)
    while (true) {
        println("\nEscolha a raça do seu personagem:")
        races.forEachIndexed { index, race ->
            println("${index + 1}: ${race.name}")
        }
        print("Opção: ")
        val choice = readlnOrNull()?.toIntOrNull()
        if (choice != null && choice in 1..races.size) {
            return races[choice - 1]
        } else {
            println("Opção inválida. Tente novamente.")
        }
    }
}