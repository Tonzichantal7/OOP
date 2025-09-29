package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class TexteProcessingTool extends Application {

    @Override
    public void start(Stage stage) {


        TextArea inputArea = new TextArea("Enter your text here...");
        TextField regexField = new TextField("Enter your pattern...");
        TextField replacementField = new TextField();
        replacementField.setPromptText("Enter replacement text...");

        Label resultLabel = new Label();

        Button searchButton = new Button("Search Matches");
        Button addButton = new Button("Add Entry");
        Button updateButton = new Button("Update Entry");
        Button deleteButton = new Button("Delete Entry");
        Button viewButton = new Button("View Data List");

        searchButton.setOnAction(e -> {
            String text = inputArea.getText();
            String pattern = regexField.getText();
            resultLabel.setText(RegexProcessor.searchMatches(pattern, text));
        });


        addButton.setOnAction(e -> {
            String text = inputArea.getText();
            DataManager.addEntry(text);
            resultLabel.setText("Added: " + text);
            inputArea.clear();
        });

        updateButton.setOnAction(e -> {
            String oldText = regexField.getText();
            String newText = replacementField.getText();
            if (DataManager.updateEntry(oldText, newText)) {
                resultLabel.setText("Updated: " + oldText + " → " + newText);
            } else {
                resultLabel.setText("Not found: " + oldText);
            }
        });

        deleteButton.setOnAction(e -> {
            String text = inputArea.getText();
            if (DataManager.deleteEntry(text)) {
                resultLabel.setText("Deleted: " + text);
            } else {
                resultLabel.setText("Not found: " + text);
            }
            inputArea.clear();
        });

        viewButton.setOnAction(e -> {
            resultLabel.setText(DataManager.viewEntries());
        });


        VBox root = new VBox(10,
                inputArea, regexField, replacementField,
                searchButton, addButton, updateButton, deleteButton, viewButton,
                resultLabel
        );

        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Text Processing Tool");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
