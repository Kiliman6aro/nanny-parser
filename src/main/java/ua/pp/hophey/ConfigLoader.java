package ua.pp.hophey;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoader {
    // Статическое поле для хранения конфигураций
    private static final Properties properties = new Properties();

    // Статический блок инициализации для загрузки конфигурационного файла
    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Приватный конструктор для предотвращения создания экземпляров
    private ConfigLoader() {
        // Prevent instantiation
    }

    // Статический метод для получения значения свойства по ключу
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Пример метода для получения значения с дефолтным значением
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
