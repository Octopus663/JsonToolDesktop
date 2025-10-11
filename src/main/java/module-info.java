module com.example.jsontooldesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jsontooldesktop to javafx.fxml;
    exports com.example.jsontooldesktop;
}