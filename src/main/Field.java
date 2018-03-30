package main;

public class Field {
    private int x;
    private int y;
    private boolean numberField;
    private boolean filled;
    private int[] numbers;
    private int probability;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        this.numberField = false;
    }
    public Field(int x, int y, int[] numbers) {
        this.x = x;
        this.y = y;
        this.numberField = true;
        this.numbers = numbers;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public void setNumberField(boolean numberField) {
        this.numberField = numberField;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isNumberField() {
        return numberField;
    }

    public boolean isFilled() {
        return filled;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
