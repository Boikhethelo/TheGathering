package manager.mapper;

public class EnchantmentMapper {
    public static String classify(String subtypes, String text, String keywords) {
        // Auras attach to permanents
        if (subtypes.contains("Aura"))              return "aura";

        // Sagas have chapter abilities
        if (subtypes.contains("Saga"))              return "saga";

        // Rooms are the newer dungeon-like enchantments
        if (subtypes.contains("Room"))              return "room";

        return "enchantment";
    }
}
