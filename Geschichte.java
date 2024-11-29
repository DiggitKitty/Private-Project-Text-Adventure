package Main;

public class Geschichte {

    public String start() {
        return "Diese Person bist du!\n" +
                "Als du durch den Wald gehst, kommst du an eine Weggabelung.\n" +
                "Was möchtest du tun?\n" +
                "1. Nach rechts und somit tiefer in den Wald eintauchen\n" +
                "2. Nach links und nach Baldurs Gate reisen";
    }

    public String waldEintauchen() {
        return "Du entscheidest dich, dieser Großstadt den Rücken zu kehren und tiefer in den dunklen Wald vorzudringen und seine Geheimnisse zu erforschen.\n" +
                "Während du tiefer in den Wald gehst, hörst du seltsame Geräusche und entdeckst einen verborgenen Pfad." +
                "Er scheint an einen besonderen Ort zu führen...";
    }

    public String baldursGate() {
        return "Du entscheidest dich für den Trubel der Großstadt und dort vielleicht den ein oder anderen lukrativen Auftrag an Land zu ziehen.\n" +
                "In Baldurs Gate angekommen, siehst du viele geschäftige Menschen und hörst von einem geheimnisvollen Auftrag, bei dem es darum geht, die Tochter eines Adligen aus einem umliegenden Räubernest zu befreien.";
    }

    public String geheimePfadErforschen() {
        return "Du erblickst einen Tempel, kannst aber nicht ausmachen, wer hier verehrt wurde. Du entscheidest dich, diesen zu betreten.";
    }

    public String auftragAnnehmen() {
        return "Du nimmst den Auftrag an, denn er scheint ziemlich lukrativ zu sein, " +
                "da der Vater eine beachtliche Menge für die Rettung seiner Tochter springen lässt.";
    }

    public String stadtRumschlendern() {
        return "Du entscheidest dich, in der Stadt zu rumschlendern.\n" +
                "Während du durch die Straßen schlenderst, entdeckst du verschiedene Geschäfte und lauscht den Gesprächen der Stadtbewohner.";
    }
}