package Attribute;

public enum Klasse {
    AUSWAHL("Auswahl"),
    MAGE("Magier"),
    DRUID("Druide"),
    PRIEST("Priester"),
    ROGUE("Schurke"), // Korrigierte Schreibweise von "ROUGUE"
    WARRIOR("Kämpfer");

    private final String name;

    // Konstruktor
   Klasse(String name) {
        this.name = name;
    }

    // Getter-Methode für den Namen
    public String getName() {
        return this.name;
    }

    // Erzeugen eines String[] für die Avatare
    public static String[] getClassNames() {
        String[] namen = new String[Klasse.values().length];
        int count = 0;
        for (Klasse classEnum : Klasse.values()) {
            namen[count] = classEnum.getName(); // Verwende getName() anstelle von toString()
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