package Enums;

public enum ToolsQA_enum {
    Menu_items("Book Store");
    private String name;
    ToolsQA_enum(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}