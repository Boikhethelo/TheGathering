package services.mappers;

public class CreatureMapper {
    public static String classify(String subtypes, String text, String keywords) {
        // Tokens are usually identified by their layout in the DB
        if (text.contains("token"))                 return "token";

        // Legendary creatures
        if (text.contains("Legendary"))             return "legendary";

        // Vehicles — artifact creatures you crew
        if (keywords.contains("Crew"))              return "vehicle";

        // Adventure creatures — split card with a spell
        if (text.contains("Adventure"))             return "adventure";

        return "creature"; // standard creature
    }
}
