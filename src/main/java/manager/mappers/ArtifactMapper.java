package manager.mappers;

public class ArtifactMapper {
    public static String classify(String subtypes, String text, String keywords) {
        if (keywords.contains("Equip"))             return "equipment";
        if (keywords.contains("Crew"))              return "vehicle";
        if (text.contains("sacrifice"))             return "sacrifice_artifact";

        return "artifact";
    }
}
