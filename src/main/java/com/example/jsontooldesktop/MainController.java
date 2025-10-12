package com.example.jsontooldesktop;

import com.example.jsontooldesktop.model.JSONDocument;
import com.example.jsontooldesktop.service.DocumentService;
import com.example.jsontooldesktop.service.DocumentServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class MainController {

    // Зв'язуємо елементи з FXML-файлу з полями в Java-класі
    @FXML
    private TableView<JSONDocument> documentsTable;
    @FXML
    private TableColumn<JSONDocument, Long> idColumn;
    @FXML
    private TableColumn<JSONDocument, String> nameColumn;
    @FXML
    private TableColumn<JSONDocument, LocalDateTime> modifiedAtColumn;

    private final DocumentService documentService = new DocumentServiceImpl();

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifiedAtColumn.setCellValueFactory(new PropertyValueFactory<>("modifiedAt"));

        loadDocuments();
    }

    private void loadDocuments() {
        List<JSONDocument> documents = documentService.getAllDocuments();
        ObservableList<JSONDocument> observableDocuments = FXCollections.observableArrayList(documents);
        documentsTable.setItems(observableDocuments);
    }

    @FXML
    private void handleCreateButton() {
        boolean saveClicked = showDocumentEditDialog();
        if (saveClicked) {
            // Оновлюємо таблицю, якщо документ був успішно збережений
            loadDocuments();
        }
    }

    private boolean showDocumentEditDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("document-edit-view.fxml"));

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Створити новий документ");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            // Встановлюємо власника вікна (головне вікно)
            dialogStage.initOwner(documentsTable.getScene().getWindow());

            Scene scene = new Scene(loader.load());
            dialogStage.setScene(scene);

            DocumentEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Показуємо вікно і чекаємо, поки користувач його не закриє
            dialogStage.showAndWait();

            return controller.isSaveClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}