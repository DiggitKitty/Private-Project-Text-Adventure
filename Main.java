package Main;

import javax.swing.*;
import Attribute.Geschlecht;
import Attribute.Klasse;
import Attribute.Rasse;
import character_editor.CharacterEditor;

public class Main {
    public static void main(String[] args) {
        // Erstelle eine Instanz des CharacterEditors und zeige das Fenster
        CharacterEditor editor = new CharacterEditor();
        editor.createAndShowGUI();
    }

    // Diese Methode wird aufgerufen, nachdem der Charakter erstellt wurde
    public static void showStoryWindow(String name, Geschlecht gender, Rasse race, Klasse characterClass) {
        JFrame storyFrame = new JFrame("Die Geschichte");
        storyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        storyFrame.setSize(1200, 800);

        JTextArea storyArea = new JTextArea();
        storyArea.setEditable(false);
        Geschichte geschichte = new Geschichte();
        storyArea.setText(createStory(name, gender, race, characterClass) + "\n" + geschichte.start());

        // Zustandsvariable für die Geschichte
        final int[] storyState = {0};

        JButton continueButton = new JButton("Weiter");
        continueButton.addActionListener(e -> {
            switch (storyState[0]) {
                case 0:
                    // Erste Entscheidung
                    int choice = JOptionPane.showOptionDialog(
                            storyFrame,
                            "Was möchtest du tun?",
                            "Entscheidung",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"In den Wald eintauchen", "Nach Baldurs Gate reisen"},
                            "In den Wald eintauchen"
                    );

                    if (choice == JOptionPane.YES_OPTION) {
                        storyArea.append("\n" + geschichte.waldEintauchen());
                        storyArea.append("\nDu genießt die Ruhe in diesem Wald, doch auch die Dunkelheit die immer intensiver zu werden scheint, " +
                                "\ndu holst deine Fackel raus um besser dein Umfeld wahrnehmen zu können.");
                        storyState[0] = 1; // Update Zustand
                    } else if (choice == JOptionPane.NO_OPTION) {
                        storyArea.append("\n" + geschichte.baldursGate());
                        storyArea.append("\nIn der Stadt angekommen, wirst du von Hektik und vielem Gerede hier und da umringt, " +
                                "\ndoch niemand scheint dich wahrzunehmen.");
                        storyState[0] = 2; // Update Zustand
                    }
                    break;

                case 1:
                    // Entscheidung nach dem Eintauchen in den Wald
                    int nextChoice = JOptionPane.showOptionDialog(
                            storyFrame,
                            "Was möchtest du als nächstes tun?",
                            "Entscheidung",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"Geheime Pfad erforschen", "Zurück zur Stadt"},
                            "Geheime Pfad erforschen"
                    );

                    if (nextChoice == JOptionPane.YES_OPTION) {
                        storyArea.append("\n" + geschichte.geheimePfadErforschen());
                        storyArea.append("\nDu dringst tiefer in den Tempel vor und findest eine verwitterte Statue der Göttin Shah. Eine dunkle Gottheit," +
                                "\njedoch wunderschön und beängstigend zugleich. Du hast das Gefühl Sie blickt tief in deine Seele.");
                    } else {
                        storyArea.append("\nDu entscheidest dich, zur Stadt zurückzukehren.");
                        storyArea.append("\nDie Stadt bietet dir Schutz und neue Möglichkeiten.");
                        storyState[0] = 2; // Zurück zur Stadt
                    }
                    break;

                case 2:
                    // Entscheidung in Baldurs Gate
                    int cityChoice = JOptionPane.showOptionDialog(
                            storyFrame,
                            "Was möchtest du als nächstes tun?",
                            "Entscheidung",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"Auftrag annehmen", "In der Stadt rumschlendern", "Zurück zum Wald"},
                            "Auftrag annehmen"
                    );

                    if (cityChoice == JOptionPane.YES_OPTION) {
                        storyArea.append("\n" + geschichte.auftragAnnehmen());
                        storyArea.append("\nDer Auftrag führt dich in gefährliche Gefilde, aber der Lohn ist verlockend.");
                        storyArea.append("\n\nDu ahnst jedoch noch nicht, auf was du dich da eingelassen hast...");
                        storyState[0] = 3; // Update Zustand
                    } else if (cityChoice == JOptionPane.NO_OPTION) {
                        storyArea.append("\n" + geschichte.stadtRumschlendern());
                        storyState[0] = 4; // Update Zustand für Rumschlendern
                    } else {
                        storyArea.append("\nDu entscheidest dich, zum Wald zurückzukehren.");
                        storyArea.append("\nDer Wald bietet dir Ruhe und die Möglichkeit, deine Gedanken zu sammeln.");
                        storyState[0] = 1; // Zurück zum Wald
                    }
                    break;

                case 3:
                    // Neue Entscheidung oder Fortsetzung der Geschichte
                    storyArea.append("\n\nEin neues Abenteuer beginnt...\n");
                    // Weitere Logik für die Fortsetzung der Geschichte
                    storyState[0] = 0; // Zurücksetzen oder Fortschreiten
                    break;

                case 4:
                    // Fortsetzung nach dem Rumschlendern in der Stadt
                    storyArea.append("\nWährend du weiter durch die Stadt gehst, bemerkst du eine Aushangtafel mit neuen Aufträgen und Gesuchen.");
                    int exploreChoice = JOptionPane.showOptionDialog(
                            storyFrame,
                            "Möchtest du eines der Abenteuer annehmen oder die Stadt weiter erkunden?",
                            "Entscheidung",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new String[]{"Abenteuer annehmen", "Weiter erkunden"},
                            "Abenteuer annehmen"
                    );

                    if (exploreChoice == JOptionPane.YES_OPTION) {
                        storyArea.append("\nDu entscheidest dich, einen der Aufträge anzunehmen und reißt den Zettel mit dem größten Lohn ab." +
                                "\nAuf diesem steht: Sammle 10 Nirnwurze in den umliegenden Wäldern, doch Achtung diese blühen nur an Flüssen, " +
                                "\ndie Flüsse von Baldurs Gate werden von Monstern heimgesucht. Seid also mutig und kühn.");
                        storyArea.append("\n\nEnde des Kapitels. Drücke 'Weiter' für die nächste Entscheidung.");
                        storyState[0] = 3; // Update Zustand
                    } else {
                        storyArea.append("\nDu erkundest weiter die Stadt und entdeckst interessante Orte und Menschen. Hier und da schnappst du ein Gerücht auf..." +
                                "\nVielleicht ist ja doch der ein oder andere interessante Auftrag dabei. Du begibst dich erst einmal in eine Taverne und buchst ein Zimmer für ein paar Tage.");
                        storyArea.append("\n\nEnde des Kapitels. Drücke 'Weiter' für die nächste Entscheidung.");
                        storyState[0] = 2; // Zurück zur Stadt
                    }
                    break;

                default:
                    break;
            }
        });

        JPanel storyPanel = new JPanel();
        storyPanel.setLayout(new BoxLayout(storyPanel, BoxLayout.Y_AXIS));
        storyPanel.add(new JScrollPane(storyArea));
        storyPanel.add(continueButton);

        storyFrame.add(storyPanel);
        storyFrame.setVisible(true);
    }

    private static String createStory(String name, Geschlecht gender, Rasse race, Klasse characterClass) {
        return "Es ist nachts und eine dunkel gekleidete Person, der Rasse " + race.toString() + " namens " + name + " schleicht durch die Lande.\n" +
                "Diese Person scheint dem Geschlecht " + gender.toString() + " zugehörig zu sein. Die Kampfkünste sind der Klasse eines " + characterClass.toString() + ".\n" +
                "Die Geschichte um diese Person beginnt in den Wäldern um Baldurs Gate.\n";
    }
}