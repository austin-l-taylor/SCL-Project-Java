public class DisplayExpression implements Expression {
    private String displayVar;
    public DisplayExpression(String value) {
        this.displayVar = value;
    }

    @Override
    public int evaluate() {
        return Memory.retrieve(displayVar);
    }
}
