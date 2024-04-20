public class ArithmeticExpression implements Expression {
    private int value;  // Example for simple integer evaluation

    public ArithmeticExpression(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}


