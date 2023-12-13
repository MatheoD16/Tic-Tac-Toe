module fr.unknowz.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.unknowz.tictactoe to javafx.fxml;
    exports fr.unknowz.tictactoe;
    exports fr.unknowz.tictactoe.controller;
    opens fr.unknowz.tictactoe.controller to javafx.fxml;
}