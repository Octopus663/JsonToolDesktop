module com.example.jsontooldesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.sql;

    opens com.example.jsontooldesktop to javafx.fxml;

    exports com.example.jsontooldesktop;
}