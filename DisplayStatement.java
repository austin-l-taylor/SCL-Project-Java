public class DisplayStatement implements Statement {
    private Expression expression;

    public DisplayStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        System.out.println(expression.evaluate());
    }
}
