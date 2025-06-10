
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.ArrayList;
// import java.util.List;
// import net.masterthought.cucumber.Configuration;
// import net.masterthought.cucumber.ReportBuilder;
// import org.json.JSONArray;
// import org.json.JSONObject;

public class GenerarReporte {
    public static void main(String[] args) {
        // File karateReportsDir = new File("build/karate-reports");
        // File outputDir = new File("build/reports/cucumber/html/cucumber-html-reports");

        // if (!karateReportsDir.exists() || karateReportsDir.listFiles().length == 0) {
        //     System.err.println("El reporte de Karate no se encontró en " + karateReportsDir.getAbsolutePath());
        //     System.exit(1);
        // }

        // outputDir.mkdirs();

        // List<String> cucumberJsonFiles = new ArrayList<>();
        // for (File file : karateReportsDir.listFiles()) {
        //     System.out.println("Found file: " + file.getName());
        //     if (file.getName().endsWith(".karate-json.txt")) {
        //         try {
        //             // Leer el contenido del archivo .karate-json.txt
        //             String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        //             JSONObject karateReport = new JSONObject(content);

        //             // Crear un archivo Cucumber JSON convertido
        //             String featureName = file.getName().replace(".karate-json.txt", "");
        //             File cucumberJsonFile = new File(karateReportsDir, featureName + ".cucumber.json");

        //             // Transformar a formato Cucumber
        //             JSONArray features = new JSONArray();
        //             JSONObject feature = new JSONObject();
        //             feature.put("uri", "file:src/test/java/features/" + featureName + ".feature");
        //             feature.put("keyword", "Feature");
        //             feature.put("name", karateReport.optString("name", "Unnamed Feature"));
        //             feature.put("line", 1); // Línea del feature (puede ajustarse)

        //             JSONArray elements = new JSONArray();
        //             JSONArray scenarioResults = karateReport.optJSONArray("scenarioResults");
        //             if (scenarioResults != null) {
        //                 for (int i = 0; i < scenarioResults.length(); i++) {
        //                     JSONObject scenario = scenarioResults.getJSONObject(i);
        //                     JSONObject element = new JSONObject();
        //                     element.put("keyword", "Scenario");
        //                     element.put("name", scenario.optString("name", "Unnamed Scenario"));
        //                     element.put("line", scenario.optInt("line", 1));
        //                     element.put("type", "scenario");

        //                     JSONArray steps = new JSONArray();
        //                     JSONArray stepResults = scenario.optJSONArray("stepResults");
        //                     if (stepResults != null) {
        //                         for (int j = 0; j < stepResults.length(); j++) {
        //                             JSONObject stepResult = stepResults.getJSONObject(j);
        //                             JSONObject step = stepResult.optJSONObject("step");
        //                             if (step != null) {
        //                                 JSONObject cucumberStep = new JSONObject();
        //                                 String keyword = step.optString("prefix", "Given");
        //                                 cucumberStep.put("keyword", keyword);
        //                                 cucumberStep.put("name", step.optString("text", "Unnamed Step"));
        //                                 cucumberStep.put("line", step.optInt("line", j + 1));

        //                                 JSONObject result = stepResult.optJSONObject("result");
        //                                 if (result != null) {
        //                                     JSONObject cucumberResult = new JSONObject();
        //                                     cucumberResult.put("status", result.optString("status", "passed"));
        //                                     cucumberResult.put("duration", result.optLong("nanos", 0));
        //                                     cucumberStep.put("result", cucumberResult);
        //                                 }

        //                                 steps.put(cucumberStep);
        //                             }
        //                         }
        //                     }
        //                     element.put("steps", steps);
        //                     elements.put(element);
        //                 }
        //             }
        //             feature.put("elements", elements);
        //             features.put(feature);

        //             // Escribir el archivo Cucumber JSON
        //             try (FileWriter writer = new FileWriter(cucumberJsonFile)) {
        //                 writer.write(features.toString(4)); // Formatear con indentación
        //                 System.out.println("Generated Cucumber JSON: " + cucumberJsonFile.getAbsolutePath());
        //             }

        //             cucumberJsonFiles.add(cucumberJsonFile.getAbsolutePath());
        //         } catch (IOException e) {
        //             e.printStackTrace();
        //             System.exit(1);
        //         }
        //     }
        // }

        // if (cucumberJsonFiles.isEmpty()) {
        //     System.err.println("No se encontraron archivos JSON válidos en " + karateReportsDir.getAbsolutePath());
        //     System.exit(1);
        // }

        // Configuration config = new Configuration(outputDir, "Karate Tests");
        // ReportBuilder reportBuilder = new ReportBuilder(cucumberJsonFiles, config);
        // reportBuilder.generateReports();
        // System.out.println("Reporte de Cucumber generado en " + outputDir.getAbsolutePath());
    }
}