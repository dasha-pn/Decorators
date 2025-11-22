package lab7.lab7.decorator;

import lombok.SneakyThrows;

import java.sql.*;

public class CachedDocument implements Document {

    private static final String DB_URL = "jdbc:sqlite:cache.db";

    private final Document document;
    private final String cacheKey;

    public CachedDocument(Document document, String cacheKey) {
        this.document = document;
        this.cacheKey = cacheKey;
        initDb();
    }

    @SneakyThrows
    private void initDb() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS document_cache (" +
                            "path TEXT PRIMARY KEY, " +
                            "content TEXT NOT NULL" +
                            ")"
            );
        }
    }

    @SneakyThrows
    private String getFromCache() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT content FROM document_cache WHERE path = ?")) {

            ps.setString(1, cacheKey);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("content");
                }
            }
        }
        return null;
    }

    @SneakyThrows
    private void saveToCache(String content) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT OR REPLACE INTO document_cache(path, content) VALUES (?, ?)")) {

            ps.setString(1, cacheKey);
            ps.setString(2, content);
            ps.executeUpdate();
        }
    }

    @Override
    public String parse() {
        // 1. пробуємо взяти з кешу
        String cached = getFromCache();
        if (cached != null && !cached.isEmpty()) {
            System.out.println("Loaded text from cache for: " + cacheKey);
            return cached;
        }

        // 2. якщо в кеші нема — звертаємось до "справжнього" документа
        String result = document.parse();

        // 3. кладемо результат у кеш
        if (result != null && !result.isEmpty()) {
            saveToCache(result);
        }

        return result;
    }
}
