package console.weather.api.JFrame;
import console.weather.api.Weather;
import console.weather.api.dto.*;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherAppGUI extends JFrame {
    private JTextField cityField;
    private JTextArea resultArea;
    private JButton searchButton;
    private JComboBox<String> primaryOptions;
    private JComboBox<String> secondaryOptions;
    private JComboBox<String> moreInfoOptions;
    private JCheckBox airQualityCheckBox;

    private static final Map<String, String> PRIMARY_OPTIONS = new HashMap<String, String>() {{
        put("temp_c", "Температура в °C");
        put("temp_f", "Температура в °F");
        put("wind_dir", "Направление ветра");
        put("skip", "Пропустить");
    }};

    private static final Map<String, String> SECONDARY_OPTIONS = new HashMap<String, String>() {{
        put("code", "Код города");
        put("condition", "Состояние погоды");
        put("icon", "Иконка погоды");
        put("skip", "Пропустить");
    }};

    public WeatherAppGUI() {
        setTitle("Weather Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Основная панель
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Панель ввода
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(new JLabel("Введите город:"));
        cityField = new JTextField(20);
        inputPanel.add(cityField);

        searchButton = new JButton("Поиск");
        searchButton.addActionListener(new SearchAction());
        inputPanel.add(searchButton);

        // Панель опций
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 5, 5));

        primaryOptions = new JComboBox<>(PRIMARY_OPTIONS.values().toArray(new String[0]));
        optionsPanel.add(new JLabel("Выберите основную информацию:"));
        optionsPanel.add(primaryOptions);

        secondaryOptions = new JComboBox<>(SECONDARY_OPTIONS.values().toArray(new String[0]));
        optionsPanel.add(new JLabel("Выберите дополнительную информацию:"));
        optionsPanel.add(secondaryOptions);

        airQualityCheckBox = new JCheckBox("Показать качество воздуха");
        optionsPanel.add(airQualityCheckBox);

        moreInfoOptions = new JComboBox<>(new String[]{"Нет", "Да"});
        optionsPanel.add(new JLabel("Показать полную информацию о местоположении:"));
        optionsPanel.add(moreInfoOptions);

        // Область результатов
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Добавление компонентов
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(optionsPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String city = cityField.getText().trim();
            if (city.isEmpty()) {
                JOptionPane.showMessageDialog(WeatherAppGUI.this,
                        "Пожалуйста, введите название города",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Response<WeatherResponse> response = Weather.instance()
                        .current(Weather.KEY, city).execute();

                if (response.isSuccessful()) {
                    displayWeatherData(response.body());
                } else {
                    resultArea.setText("Ошибка при получении данных: " + response.message());
                }
            } catch (IOException ex) {
                resultArea.setText("Ошибка соединения: " + ex.getMessage());
            }
        }

        private void displayWeatherData(WeatherResponse weather) {
            Current current = weather.getCurrent();
            Condition condition = current.getCondition();
            Location location = weather.getLocation();
            AirQuality airQuality = current.getAirQuality();

            StringBuilder sb = new StringBuilder();
            sb.append("Погода в ").append(location.getName()).append("\n\n");

            // Основная информация
            String primarySelection = (String) primaryOptions.getSelectedItem();
            if (primarySelection.equals(PRIMARY_OPTIONS.get("temp_c"))) {
                sb.append("Температура: ").append(current.getTempC()).append("°C\n");
            } else if (primarySelection.equals(PRIMARY_OPTIONS.get("temp_f"))) {
                sb.append("Температура: ").append(current.getTempF()).append("°F\n");
            } else if (primarySelection.equals(PRIMARY_OPTIONS.get("wind_dir"))) {
                sb.append("Направление ветра: ").append(current.getWindDir()).append("\n");
            }

            // Дополнительная информация
            String secondarySelection = (String) secondaryOptions.getSelectedItem();
            if (secondarySelection.equals(SECONDARY_OPTIONS.get("code"))) {
                sb.append("Код: ").append(condition.getCode()).append("\n");
            } else if (secondarySelection.equals(SECONDARY_OPTIONS.get("condition"))) {
                sb.append("Состояние: ").append(condition.getText()).append("\n");
            } else if (secondarySelection.equals(SECONDARY_OPTIONS.get("icon"))) {
                sb.append("Иконка: ").append(condition.getIcon()).append("\n");
            }

            // Полная информация
            if (moreInfoOptions.getSelectedItem().equals("Да")) {
                sb.append("\nПолная информация:\n").append(location.toString()).append("\n");
            }

            // Качество воздуха
            if (airQualityCheckBox.isSelected()) {
                sb.append("\nКачество воздуха:\n").append(airQuality.toString()).append("\n");
            }

            resultArea.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WeatherAppGUI app = new WeatherAppGUI();
            app.setVisible(true);
        });
    }
}

