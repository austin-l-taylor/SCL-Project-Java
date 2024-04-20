public class AssignmentStatement implements Statement {
    private String variableName;
    private Expression expression;

    public AssignmentStatement(String variableName, Expression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void execute() {
        int value = expression.evaluate();
        Memory.store(variableName, value);  // Assuming a Memory class to store variable values
    }
}
