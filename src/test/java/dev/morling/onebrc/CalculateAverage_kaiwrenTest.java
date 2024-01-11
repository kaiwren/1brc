package dev.morling.onebrc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class CalculateAverage_kaiwrenTest {

    @Test
    void measurements1() throws IOException {
        String measurementFilePath = getMeasurementFilePath("1");
        Map<String, CalculateAverage_kaiwren.ResultRow> stringResultRowMap = CalculateAverage_kaiwren.calculate(measurementFilePath);
        assertEquals("{Kunming=19.8/19.8/19.8}", stringResultRowMap.toString());
    }
    @Test
    void measurements2() throws IOException {
        String measurementFilePath = getMeasurementFilePath("2");
        Map<String, CalculateAverage_kaiwren.ResultRow> stringResultRowMap = CalculateAverage_kaiwren.calculate(measurementFilePath);
        assertEquals("{Bosaso=19.2/19.2/19.2, Petropavlovsk-Kamchatsky=9.5/9.5/9.5}", stringResultRowMap.toString());
    }
    @Test
    void measurements3() throws IOException {
        String measurementFilePath = getMeasurementFilePath("3");
        Map<String, CalculateAverage_kaiwren.ResultRow> stringResultRowMap = CalculateAverage_kaiwren.calculate(measurementFilePath);
        assertEquals("{Bosaso=-15.0/1.3/20.0, Petropavlovsk-Kamchatsky=-9.5/0.0/9.5}", stringResultRowMap.toString());
    }

    private static String getMeasurementFilePath(String exampleName) {
        return Paths.get(System.getProperty("user.dir"))
                .resolve(Paths.get(STR."src/test/resources/samples/measurements-\{exampleName}.txt"))
                .toString();
    }
}