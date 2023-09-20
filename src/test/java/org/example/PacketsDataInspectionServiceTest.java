package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacketsDataInspectionServiceTest {

    @Test
    public void test() {
        var start = LocalDateTime.parse("2023-09-17T10:00:00");
        var packages = List.of(
                new PackageData(10, 2, start.plusSeconds(1)),
                new PackageData(9, 3, start.plusSeconds(2)),
                new PackageData(5, 9, start.plusSeconds(3)),
                new PackageData(7, 6, start.plusSeconds(4)),
                new PackageData(3, 8, start.plusSeconds(5)),
                new PackageData(11, 1, start.plusSeconds(6)),
                new PackageData(3, 10, start.plusSeconds(7)),
                new PackageData(12, 0, start.plusSeconds(8))
        );

        var inspectionService = new PacketsDataInspectionService();
        var inspectionResult = inspectionService.findLongestAndWorstDataTransfer(packages);

        assertEquals(inspectionResult.getRate(), -8);
        assertEquals(inspectionResult.getFrom(), LocalDateTime.parse("2023-09-17T10:00:03"));
        assertEquals(inspectionResult.getTo(), LocalDateTime.parse("2023-09-17T10:00:05"));
    }
}
