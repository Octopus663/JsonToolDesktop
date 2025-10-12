package com.example.jsontooldesktop;

import com.example.jsontooldesktop.model.JSONDocument;
import com.example.jsontooldesktop.service.DocumentService;
import com.example.jsontooldesktop.service.DocumentServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DocumentEditController {

    @FXML
    private TextField nameField;
    @FXML
    private TextArea contentArea;

    private Stage dialogStage;
    private boolean saveClicked = false;
    private final DocumentService documentService = new DocumentServiceImpl();

    // Поки що нам не потрібен User, тому ставимо null. 
    // Пізніше ми реалізуємо логін і будемо передавати реального користувача.
    private final Long TEMP_USER_ID = null;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isSaveClicked() {
        return saveClicked;
    }

    @FXML
    private void handleSave() {
        if (isInputValid()) {
            try {
                // Викликаємо наш сервіс для створення документа
                // Для user поки передаємо null, оскільки у нас ще немає системи логіну
                documentService.createDocument(nameField.getText(), contentArea.getText(), null);

                saveClicked = true;
                dialogStage.close();
            } catch (Exception e) {
                showErrorAlert("Помилка збереження", "Не вдалося зберегти документ у базу даних.");
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (nameField.getText() == null || nameField.getText().isEmpty()) {
            errorMessage += "Не вказана назва документа!\n";
        }
        // Тут можна додати валідацію JSON, якщо потрібно

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            showErrorAlert("Некоректні дані", errorMessage);
            return false;
        }
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(dialogStage);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}