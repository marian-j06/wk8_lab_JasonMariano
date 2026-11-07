package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {

		// ROOT: BorderPane 
		BorderPane root = new BorderPane();

        // TOP: HBox (title)
        Label title = new Label("College Student Registration");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        HBox header = new HBox(title);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(15));
        header.setStyle("-fx-background-color: orange;");

		// LEFT: VBox (navigation buttons)
		Button dashboardButton = new Button("Dashboard");
		Button registrationButton = new Button("Registration");
		Button coursesButton = new Button("Courses");
		Button helpButton = new Button("Help");

		VBox navigation = new VBox(12, dashboardButton, registrationButton, coursesButton, helpButton);
		navigation.setPadding(new Insets(15));
		navigation.setStyle("-fx-background-color: lightgray;");

		// Form title 
		Label formTitle = new Label("Registration Form");
		formTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

		// GridPane (student fields) 
		TextField idField = new TextField();
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		TextField programField = new TextField();

		GridPane form = new GridPane();
		form.setHgap(12);
		form.setVgap(14);
		form.setPadding(new Insets(10));

		// form.add(node, column, row)
		form.add(new Label("Student ID:"), 0, 0);
		form.add(idField, 1, 0);
		form.add(new Label("Full Name:"), 0, 1);
		form.add(nameField, 1, 1);
		form.add(new Label("Email:"), 0, 2);
		form.add(emailField, 1, 2);
		form.add(new Label("Program:"), 0, 3);
		form.add(programField, 1, 3);

		// Register and Clear Button
		Button registerButton = new Button("Register");
		Button clearButton = new Button("Clear");

		HBox actions = new HBox(10, registerButton, clearButton);
		actions.setAlignment(Pos.CENTER_LEFT);
		actions.setPadding(new Insets(10, 0, 0, 0));

		// CENTER: Status message
		Label statusLabel = new Label("");

		// CENTER: VBox holding everything above 
		VBox mainContent = new VBox(15, formTitle, form, actions, statusLabel);
		mainContent.setPadding(new Insets(20));

		// Place the panes in the BorderPane 
		root.setTop(header);
		root.setLeft(navigation);
		root.setCenter(mainContent);

		// BUTTON EVENTS
		registerButton.setOnAction(event -> {
			String id = idField.getText().trim();
			String name = nameField.getText().trim();
			String email = emailField.getText().trim();
			String program = programField.getText().trim();

			if (id.isEmpty() || name.isEmpty() || email.isEmpty() || program.isEmpty()) {
				statusLabel.setText("Error: Please fill in all fields.");
				statusLabel.setStyle("-fx-text-fill: red;");
			} else {
				statusLabel.setText("Registration accepted for " + name);
				statusLabel.setStyle("-fx-text-fill: green;");
			}
		});

		clearButton.setOnAction(event -> {
			idField.clear();
			nameField.clear();
			emailField.clear();
			programField.clear();
			statusLabel.setText("");
		});

		Scene scene = new Scene(root, 850, 520);
		stage.setTitle("College Student Registration");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}