package services.mappers;

public class PlaneswalkerMapper {

    /**
     * Classifies a planeswalker card into a subtype.
     * Currently returns a single category — expand when planeswalker
     * loyalty ability parsing is implemented.
     */
    public static String classify(String text) {
        return "planeswalker";
    }
}