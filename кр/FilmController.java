import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.;
import javafx.scene.control.cell.PropertyValueFactory;

public class FilmController {
    @FXML
    private TableViewFilm filmTable;
    @FXML
    private TableColumnFilm, Integer idColumn;
    @FXML
    private TableColumnFilm, String nameColumn;
    @FXML
    private TableColumnFilm, Genre genreColumn;
    @FXML
    private TableColumnFilm, Integer durationColumn;
    @FXML
    private TableColumnFilm, Integer yearColumn;

    private ObservableListFilm films;

    public void initialize() {
         Инициализация таблицы и колонок
        films = FXCollections.observableArrayList();
        filmTable.setItems(films);

        idColumn.setCellValueFactory(new PropertyValueFactory(id));
        nameColumn.setCellValueFactory(new PropertyValueFactory(name));
        genreColumn.setCellValueFactory(new PropertyValueFactory(genre));
        durationColumn.setCellValueFactory(new PropertyValueFactory(duration));
        yearColumn.setCellValueFactory(new PropertyValueFactory(year));
    }

    public void addFilm() {
         Обработка добавления фильма
         Здесь можно открыть диалоговое окно для ввода информации о новом фильме
         и добавить его в список films
    }

    public void deleteFilm() {
         Обработка удаления фильма
        Film selectedFilm = filmTable.getSelectionModel().getSelectedItem();
        if (selectedFilm != null) {
            films.remove(selectedFilm);
        }
    }

    public void editFilm() {
         Обработка редактирования фильма
        Film selectedFilm = filmTable.getSelectionModel().getSelectedItem();
        if (selectedFilm != null) {
             Здесь можно открыть диалоговое окно с предварительно заполненными данными
             выбранного фильма для редактирования
        }
    }
}
