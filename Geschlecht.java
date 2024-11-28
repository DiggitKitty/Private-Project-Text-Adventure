package Attribute;

public enum Geschlecht {
    AUSWAHL("Auswahl"),
    FEMALE("Weiblich"),
    MALE("Männlich"),
    OTHER("Divers");

    private final String name;

    // Konstruktor
    Geschlecht(String name) {
        this.name = name;
    }

    // Getter-Methode für den Namen
    public String getName() {
        return this.name;
    }

    // Erzeugen eines String[] für die Avatare
    public static String[] getGenderNames() {
        String[] namen = new String[Geschlecht.values().length];
        int count = 0;
        for (Geschlecht gender : Geschlecht.values()) {
            namen[count] = gender.getName(); // Verwende getName() anstelle von toString()
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