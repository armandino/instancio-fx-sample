module com.github.sheikah45.instanciofxsample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.sheikah45.instanciofxsample to javafx.fxml;
    exports com.github.sheikah45.instanciofxsample;
}