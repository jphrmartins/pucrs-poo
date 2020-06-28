package entities.menu;

public class MenuRange {
    private int startRange;
    private int endRange;

    public MenuRange(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }
}
