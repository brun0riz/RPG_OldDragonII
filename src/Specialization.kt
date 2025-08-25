    /**
 * Define a hierarquia de especializações.
 * Cada especialização pode conceder habilidades adicionais.
 */
sealed class Specialization(val name: String, val grantedAbilities: List<ClassAbility>)

// --- Especializações de Guerreiro ---
sealed class WarriorSpecialization(name: String, grantedAbilities: List<ClassAbility>) : Specialization(name, grantedAbilities)
object Barbarian : WarriorSpecialization("Bárbaro", grantedAbilities = listOf(/* Habilidades como Fúria, Vigor, etc. iriam aqui */))
object Paladin : WarriorSpecialization("Paladino", grantedAbilities = listOf(/* Habilidades como Detectar o Mal, Cura pelas Mãos, etc. iriam aqui */))

// --- Especializações de Clérigo ---
sealed class ClericSpecialization(name: String, grantedAbilities: List<ClassAbility>) : Specialization(name, grantedAbilities)
object Druid : ClericSpecialization("Druida", grantedAbilities = listOf(/* Habilidades de Forma Selvagem, etc. iriam aqui */))
// O Acadêmico troca habilidades, mas também ganha novas
object Academic : ClericSpecialization("Acadêmico", grantedAbilities = listOf(AcademicKnowledge))

// --- Especializações de Ladrão ---
sealed class ThiefSpecialization(name: String, grantedAbilities: List<ClassAbility>) : Specialization(name, grantedAbilities)
object Ranger : ThiefSpecialization("Ranger", grantedAbilities = listOf(AnimalCompanion))
object Bard : ThiefSpecialization("Bardo", grantedAbilities = listOf(/* Habilidades como Influenciar, Inspirar, etc. iriam aqui */))

// --- Especializações de Mago ---
sealed class MageSpecialization(name: String, grantedAbilities: List<ClassAbility>) : Specialization(name, grantedAbilities)
object Illusionist : MageSpecialization("Ilusionista", grantedAbilities = listOf(/* Magias exclusivas de Ilusão iriam aqui */))
object Necromancer : MageSpecialization("Necromante", grantedAbilities = listOf(/* Magias exclusivas de Necromancia iriam aqui */))