module com.example.oris2ndsemproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oris2ndsemproj to javafx.fxml;
//    exports com.example.oris2ndsemproj;
    exports com.example.oris2ndsemproj.application;
    opens com.example.oris2ndsemproj.application to javafx.fxml;
}