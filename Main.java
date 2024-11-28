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

        JButton continueButton = new JButton("Weiter");
        continueButton.addActionListener(e -> {
            // Benutzerentscheidung über Dialog
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
                // Weitere Entscheidungsmöglichkeiten hinzufügen
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
                }
            } else if (choice == JOptionPane.NO_OPTION) {
                storyArea.append("\n" + geschichte.baldursGate());
                // Weitere Entscheidungsmöglichkeiten hinzufügen
                int nextChoice = JOptionPane.showOptionDialog(
                        storyFrame,
                        "Was möchtest du als nächstes tun?",
                        "Entscheidung",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Auftrag annehmen", "Zurück zum Wald"},
                        "Auftrag annehmen"
                );

                if (nextChoice == JOptionPane.YES_OPTION) {
                    storyArea.append("\n" + geschichte.auftragAnnehmen());
                }
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


