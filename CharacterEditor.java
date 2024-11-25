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

            showStoryWindow(name, gender, race, characterClass);
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
}
// Methode zum Anzeigen der Geschichte
private void showStoryWindow(String name, Gender gender, Race race, Class characterClass) {
    JFrame storyFrame = new JFrame("Deine Geschichte");
    storyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    storyFrame.setSize(400, 300);

    JTextArea storyArea = new JTextArea();
    storyArea.setEditable(false);
    storyArea.setText(createStory(name, gender, race, characterClass));

    storyFrame.add(new JScrollPane(storyArea));
    storyFrame.setVisible(true);
}

// Methode zur Erstellung der Geschichte
private String createStory(String name, Gender gender, Race race, Class characterClass) {
    return "Es ist nachts und eine dunkel gekleidete Person, der Rasse " + race.toString().toLowerCase() + " namens " + name + " schleicht durch die Lande.\n" +
            "Diese Person scheint dem Geschlecht " + gender.toString().toLowerCase() + " zugehörig zu sein. Die Kampfkünste sind der Klasse eines " + characterClass.toString().toLowerCase() + ".\n" +
            "Die Geschichte um diese Person beginnt in den Wäldern um Baldurs Gate.";
}
}