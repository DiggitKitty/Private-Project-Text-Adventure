package character_editor;

import javax.swing.*;
import Attribute.Gender;
import Attribute.Class;
import Attribute.Race;



public class CharacterEditor {
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Character Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Name Eingabefeld
        JTextField nameField = new JTextField("Name");
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        // Geschlecht Auswahl
        JComboBox<Gender> genderComboBox = new JComboBox<>(Gender.values());
        panel.add(new JLabel("Gender:"));
        panel.add(genderComboBox);

        // Rasse Auswahl
        JComboBox<Race> raceComboBox = new JComboBox<>(Race.values());
        panel.add(new JLabel("Race:"));
        panel.add(raceComboBox);

        // Klasse Auswahl
        JComboBox<Class> classComboBox = new JComboBox<>(Class.values());
        panel.add(new JLabel("Classe:"));
        panel.add(classComboBox);

        // Speichern Button
        JButton saveButton = new JButton("Speichern");
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            Gender gender = (Gender) genderComboBox.getSelectedItem();
            Race race = (Race) raceComboBox.getSelectedItem();
            Class characterClass = (Class) classComboBox.getSelectedItem();

            // Hier kannst du die Logik zum Speichern oder Weiterverarbeiten der Daten einfügen
            System.out.println("Charakter erstellt: " + name + ", " + gender + ", " + race + ", " + characterClass);
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
