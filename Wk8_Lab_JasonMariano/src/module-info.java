module Wk8_Lab_JasonMariano {
	requires javafx.controls;

	exports application;

	opens application to javafx.graphics;
}