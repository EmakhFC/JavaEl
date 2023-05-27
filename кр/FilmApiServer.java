import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class FilmApiServer {
    private static List<Film> films = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/films", new FilmsHandler());
        server.setExecutor(null);
        server.start();
    }

    static class FilmsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                // Возвращаем список фильмов в формате JSON
                String response = getFilmsJson();
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.flush();
                outputStream.close();
            } else if ("POST".equals(exchange.getRequestMethod())) {
                // Обрабатываем запрос на добавление фильма
                // Здесь можно использовать библиотеку для парсинга JSON и добавить фильм в список
                exchange.sendResponseHeaders(200, -1); // Отправляем ответ без тела
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                // Обрабатываем запрос на удаление фильма
                // Здесь можно использовать параметр запроса для определения id фильма и удалить его из списка
                exchange.sendResponseHeaders(200, -1); // Отправляем ответ без тела
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                // Обрабатываем запрос на редактирование фильма
                // Здесь можно использовать параметр запроса для определения id фильма и обновить его информацию
                exchange.sendResponseHeaders(200, -1); // Отправляем ответ без тела
            }
        }
    }

    private static String getFilmsJson() {
        // Здесь можно преобразовать список фильмов в формат JSON
        return "";
    }
}

class Film {
    private int id;
    private String name;
    private Genre genre;
    private int duration;
    private int year;

    // Реализация геттеров и сеттеров

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

enum Genre {
    ACTION,
    COMEDY,
    DRAMA,
    THRILLER
}