package Attribute;

public enum Rasse {
    AUSWAHL ("Auswahl"),
    DROW("Drow"),
    ELF("Elf"),
    HIGH_ELF("Hoch Elf"),
    ORC("Ork"),
    HUMAN("Mensch"),
    TIEFLING("Tiefling"),
    DWARF("Zwerg");

    private final String name;

    // Konstruktor
    Rasse(String name) {
        this.name = name;
    }

    // Getter-Methode für den Namen
    public String getRaceName() {
        return this.name;
    }

    // Erzeugen eines String[] für die Avatare
    public static String[] getGenderNames() {
        String[] namen = new String[Rasse.values().length];
        int count = 0;
        for (Rasse race : Rasse.values()) {
            namen[count] = race.getRaceName(); // Verwende getName() anstelle von toString()
            count++;
        }
        return namen;
    }

    // Überschreiben der toString-Methode, um den Namen anzuzeigen
    @Override
    public String toString() {
        return this.name;
    }
}