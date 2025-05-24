/**
 * 
 */
/**
 * 
 */
module AimsProject {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
    requires java.naming;
	requires javafx.base;

    exports hust.soict.hedspi.aims.screen.customer.main;
	exports hust.soict.hedspi.aims.screen.customer.controller;

	opens hust.soict.hedspi.aims.screen.customer.controller to javafx.fxml;
	opens hust.soict.hedspi.aims.screen.customer.view to javafx.fxml;


	opens hust.soict.hedspi.aims.media to javafx.base;
}