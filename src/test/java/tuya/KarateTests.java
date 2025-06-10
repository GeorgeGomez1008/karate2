package tuya;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KarateTests {
    @Test
    void testParallel() {
Results results = Runner.path("classpath:tuya/gopass/features")
                .tags("@smoke")
                .outputCucumberJson(true)
                .reportDir("build/karate-reports")
                .parallel(1);
        generarReporte(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

private static void generarReporte(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        if (jsonFiles.isEmpty()) {
            System.err.println("No se encontraron archivos JSON en " + karateOutputPath);
            return;
        }
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        String karateEnv = System.getProperty("karate.env", "default");
        Configuration config = new Configuration(new File("target"), "backendTest - Karate");
        config.addClassifications("Environment", karateEnv);

        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}