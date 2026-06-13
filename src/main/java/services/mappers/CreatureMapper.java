package services.mappers;

public class CreatureMapper {

    /**
     * Classifies a Creature card.
     *
     * The {@code type} parameter is the full type line from the DB
     * (e.g. "Legendary Creature — Dragon"). Legendary is a supertype
     * found there, NOT in the rules text body — previous implementation
     * checked {@code text.contains("Legendary")} which silently missed
     * every legendary creature whose rules text didn't happen to say the word.
     *
     * CardMapper must be updated to pass {@code type} here.
     */
    public static String classify(String type, String text, String keywords) {

        // Tokens are identified by their DB layout / token flag
        if (text.contains("token"))                 return "token";

        // Legendary supertype lives in the type line, not in rules text
        if (type.contains("Legendary"))             return "legendary";

        // Vehicles are artifact creatures you crew
        if (keywords.contains("Crew"))              return "vehicle";

        // Adventure creatures have a spell half
        if (text.contains("Adventure"))             return "adventure";

        return "creature";
    }
}