import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FilmApp extends Application {
    private TableView<Film> filmTable;
    private ObservableList<Film> films;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Фильмы");

        // Создание таблицы для отображения списка фильмов
        filmTable = new TableView<>();
        films = FXCollections.observableArrayList();
        filmTable.setItems(films);

        TableColumn<Film, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        TableColumn<Film, String> nameColumn = new TableColumn<>("Наименование");
        nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
        TableColumn<Film, Genre> genreColumn = new TableColumn<>("Жанр");
        genreColumn.setCellValueFactory(data -> data.getValue().genreProperty());
        TableColumn<Film, Integer> durationColumn = new TableColumn<>("Длительность");
        durationColumn.setCellValueFactory(data -> data.getValue().durationProperty().asObject());
        TableColumn<Film, Integer> yearColumn = new TableColumn<>("Год выхода");
        yearColumn.setCellValueFactory(data -> data.getValue().yearProperty().asObject());

        filmTable.getColumns().addAll(idColumn, nameColumn, genreColumn, durationColumn, yearColumn);

        // Создание кнопок для добавления, удаления и редактирования фильмов
        Button addButton = new Button("Добавить");
        addButton.setOnAction(event -> showFilmDialog(null));

        Button deleteButton = new Button("Удалить");
        deleteButton.setOnAction(event -> {
            Film selectedFilm = filmTable.getSelectionModel().getSelectedItem();
            if (selectedFilm != null) {
                films.remove(selectedFilm);
            }
        });

        Button editButton = new Button("Редактировать");
        editButton.setOnAction(event -> {
            Film selectedFilm = filmTable.getSelectionModel().getSelectedItem();
            if (selectedFilm != null) {
                showFilmDialog(selectedFilm);
            }
        });

        // Создание панели с кнопками
        HBox buttonBar = new HBox(10);
        buttonBar.setPadding(new Insets(10));
        buttonBar.getChildren().addAll(addButton, deleteButton, editButton);

        // Создание главного макета и добавление в него компонентов
        VBox root = new VBox();
        root.getChildren().addAll(filmTable, buttonBar);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showFilmDialog(Film film) {
        // Здесь можно реализовать диалоговое окно для добавления/редактирования фильма
        // и обновление списка фильмов после добавления/редактирования
    }
}
