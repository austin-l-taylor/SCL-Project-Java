
import java.util.ArrayList;
import java.util.List;

public class Block implements Statement {
    private List<Statement> statements = new ArrayList<>();

    public void addStatement(Statement statement) {
        statements.add(statement);
    }

    @Override
    public void execute() {
        for (Statement stmt : statements) {
            stmt.execute();
        }
    }
}
