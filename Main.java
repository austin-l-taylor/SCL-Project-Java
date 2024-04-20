public class Main {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("set x = 10\n display x");
            Parser parser = new Parser(lexer);
            Block program = parser.parseProgram();
            program.execute();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}