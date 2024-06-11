package jpaswing.projectspotiy.ui;

public class DisplayItem {
    private String displayText;
    private Object originalObject;

    public DisplayItem(String displayText, Object originalObject) {
        this.displayText = displayText;
        this.originalObject = originalObject;
    }
    public DisplayItem(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    public Object getOriginalObject() {
        return originalObject;
    }

    @Override
    public String toString() {
        return displayText;
    }
}
