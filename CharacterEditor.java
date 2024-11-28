package character_editor;

import javax.swing.*;
import Attribute.Geschlecht;
import Attribute.Klasse;
import Attribute.Rasse;
import Main.Main; // Importiere Main, um die showStoryWindow-Methode zu verwenden

public class CharacterEditor {
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Character Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Name Eingabefeld
        JTextField nameField = new JTextField("Name");
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        // Geschlecht Auswahl
        JComboBox<Geschlecht> genderComboBox = new JComboBox<>(Geschlecht.values());
        panel.add(new JLabel("Geschlecht:"));
        panel.add(genderComboBox);

        // Rasse Auswahl
        JComboBox<Rasse> raceComboBox = new JComboBox<>(Rasse.values());
        panel.add(new JLabel("Rasse:"));
        panel.add(raceComboBox);

        // Klasse Auswahl
        JComboBox<Klasse> classComboBox = new JComboBox<>(Klasse.values());
        panel.add(new JLabel("Klasse:"));
        panel.add(classComboBox);

        // Speichern Button
        JButton saveButton = new JButton("Speichern");
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            Geschlecht gender = (Geschlecht) genderComboBox.getSelectedItem();
            Rasse race = (Rasse) raceComboBox.getSelectedItem();
            Klasse characterClass = (Klasse) classComboBox.getSelectedItem();

            System.out.println("Charakter erstellt: " + name + ", " + gender + ", " + race + ", " + characterClass);

            // Zeige das Story-Fenster an
            Main.showStoryWindow(name, gender, race, characterClass);
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}