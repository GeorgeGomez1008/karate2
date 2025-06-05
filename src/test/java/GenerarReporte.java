import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.json.JSONObject;

public class GenerarReporte {
    public static void main(String[] args) {
        File karateReportsDir = new File("build/karate-reports");
        File outputDir = new File("build/reports/cucumber/html/cucumber-html-reports");

        if (!karateReportsDir.exists() || karateReportsDir.listFiles().length == 0) {
            System.err.println("El reporte de karate no se encontró en " + karateReportsDir.getAbsolutePath());
            System.exit(1);
        }

        outputDir.mkdirs();

        List<String> jsonFiles = new ArrayList<>();
        for (File file : karateReportsDir.listFiles()) {
            System.out.println("Found file: " + file.getName()); // Línea de depuración
            if (file.getName().endsWith(".txt")) {
                // Renombrar archivo a .json
                File renamedFile = new File(file.getAbsolutePath().replace(".txt", ".json"));
                file.renameTo(renamedFile);

                // Convertir el contenido al formato esperado por Cucumber
                try {
                    String content = new String(Files.readAllBytes(Paths.get(renamedFile.getAbsolutePath())));
                    System.out.println("Contenido del archivo " + renamedFile.getName() + ":");
                    System.out.println(content);

                    JSONObject jsonObject = new JSONObject(content);
                    File convertedFile = new File(renamedFile.getAbsolutePath().replace(".json", "-converted.json"));
                    try (FileWriter fileWriter = new FileWriter(convertedFile)) {
                        fileWriter.write(jsonObject.toString(4)); // Formatear JSON con indentación
                    }
                    jsonFiles.add(convertedFile.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (jsonFiles.isEmpty()) {
            System.err.println("No se encontraron archivos JSON válidos en " + karateReportsDir.getAbsolutePath());
            System.exit(1);
        }

        Configuration config = new Configuration(outputDir, "Karate Tests");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
        System.out.println("Reporte de cucumber generado en " + outputDir.getAbsolutePath());
    }
}