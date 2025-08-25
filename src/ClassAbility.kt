sealed class ClassAbility(val name: String, val description: String)

// --- Habilidades de Guerreiro ---
object CanUseAllWeapons : ClassAbility("Proficiência: Todas as Armas", "Pode usar todos os tipos de armas.")
object CanUseAllArmor : ClassAbility("Proficiência: Todas as Armaduras", "Pode usar todos os tipos de armaduras.")
data class WeaponMastery(var level: Int) : ClassAbility("Maestria com Arma", "Ganha bônus de dano (+1, +2, +3) com armas que possui maestria.")
object ExtraAttack : ClassAbility("Ataque Extra", "No 6º nível, ganha um segundo ataque com arma que possua maestria.")

// --- Habilidades de Clérigo ---
object CanUseMediumArmorAndShields : ClassAbility("Proficiência: Armaduras Médias", "Pode usar armaduras leves, médias e escudos.")
object RestrictedToBludgeoningWeapons : ClassAbility("Restrição: Armas de Esmagamento", "Normalmente restrito a armas que não causem corte ou perfuração.")
object DivineSpells : ClassAbility("Magias Divinas", "Capacidade de memorizar e conjurar magias divinas diariamente.")
object TurnUndead : ClassAbility("Expulsar Mortos-Vivos", "Pode invocar poder divino para afugentar mortos-vivos uma vez por dia.")
object MiraculousHealing : ClassAbility("Cura Milagrosa", "Pode trocar uma magia memorizada por uma magia de Cura.")

// --- Habilidades de Ladrão ---
object CanUseLightArmorOnly : ClassAbility("Proficiência: Armaduras Leves", "Pode usar apenas armaduras leves.")
object CanUseSmallAndMediumWeapons : ClassAbility("Proficiência: Armas Pequenas e Médias", "Pode usar apenas armas pequenas ou médias.")
data class HearNoises(var level: Int) : ClassAbility("Ouvir Ruídos", "Capacidade de ouvir ruídos em ambientes silenciosos (chance aumenta com o nível).")
data class SneakAttack(var multiplier: Int) : ClassAbility("Ataque Furtivo", "Causa dano multiplicado (x2, x3, x4, x5) em ataques surpresa.")
object ThiefTalents : ClassAbility("Talentos de Ladrão", "Ganha pontos para distribuir entre talentos como Arrombar, Pungar, Furtividade, etc.")

// --- Habilidades de Mago ---
object CanUseSmallWeaponsOnly : ClassAbility("Proficiência: Armas Pequenas", "Pode usar apenas armas pequenas.")
object NoArmorProficiency : ClassAbility("Proficiência: Nenhuma Armadura", "Não pode usar armaduras ou escudos.")
object ArcaneSpells : ClassAbility("Magias Arcanas", "Capacidade de memorizar e conjurar magias arcanas de um grimório.")
object DetectMagic : ClassAbility("Detectar Magia", "Pode se concentrar para perceber auras mágicas.")

// --- Habilidades de Especializações (Exemplos) ---
object AcademicKnowledge : ClassAbility("Conhecimento Acadêmico", "Pode identificar monstros e suas fraquezas.")
object AnimalCompanion : ClassAbility("Companheiro Animal", "Ganha um leal companheiro animal (habilidade de Ranger).")