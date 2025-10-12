module com.example.jsontooldesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.sql;

    opens com.example.jsontooldesktop.model to org.hibernate.orm.core, javafx.base;

    // Цей рядок відкриває наші контролери для JavaFX
    opens com.example.jsontooldesktop to javafx.fxml;

    exports com.example.jsontooldesktop;
}