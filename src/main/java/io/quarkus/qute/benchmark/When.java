package io.quarkus.qute.benchmark;

import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Setup;

public class When extends BenchmarkBase {
    
    private Map<String, Object> testData;

    @Setup
    public void setup() throws Exception {
        super.setup();
        testData = new HashMap<>();
        testData.put("item", Loop.generateItem(6));
    }

    protected String getTemplateName() {
        return "when.html";
    }

    @Override
    protected Object getTestData() {
        return testData;
    }

    @Override
    protected void assertResult(String result) {
        if (!result.contains("The price is too high.")) {
            throw new AssertionError("Incorrect result: " + result);
        }
    }

}
