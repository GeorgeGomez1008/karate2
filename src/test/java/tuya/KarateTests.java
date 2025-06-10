package tuya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

// import com.intuit.karate.junit5.Karate;
// import com.intuit.karate.junit5.Karate.Test;

class KarateTests {
    @Test
    void testParallel() {
        Results results = Runner.path("classpath")
            .tags("@TestsApisTuya")
            .outputCucumberJson(true)
            .parallel(1);
        generarReporte(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
        // return Karate.run("classpath:tuya/gopass/features/sing-up.feature").relativeTo(getClass());
    }

    private static void generarReporte(String karateOutputPath) {
        //Get the results JSON files
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        //Capture the -Dkarate.env environment variable
        String karateEnv = System.getProperty("karate.env", "default");

        //Report Configuration
        Configuration config = new Configuration(new File("target"), "backendTest - Karate");
        config.addClassifications("Environment", karateEnv);

        //Generate the report
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}