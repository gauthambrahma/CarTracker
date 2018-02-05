package carTrackerAPI.Entites;

public enum AlertMessages {
    RULE1("Engine RMP is greater than red line RPM", "HIGH"),
    RULE2("Fuel volume less than 10%", "MEDIUM"),
    RULE3("Check tire pressure", "LOW"),
    RULE4("Replace Engine Coolant", "LOW"),
    RULE5("Check Engine", "LOW");

    private String rule;
    private String priority;

    AlertMessages(String rule, String priority) {
        this.rule = rule;
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public String getRule() {
        return rule;
    }
}
