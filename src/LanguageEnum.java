
public enum LanguageEnum {
    ENGLISH(0, "English"),
    SPANISH(1, "Spanish"),
    GERMAN(2, "German"),
    ITALIAN(3, "Italian"),
    TURKISH(4, "Turkish");

    private final int value;
    private final String name;

    LanguageEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}