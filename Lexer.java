import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;
    private List<Token> tokens;
    private int position;

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
        this.position = 0;
        tokenize();
    }

    private void tokenize() {
        int length = input.length();
        for (int i = 0; i < length; ) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                StringBuilder number = new StringBuilder();
                while (i < length && Character.isDigit(input.charAt(i))) {
                    number.append(input.charAt(i));
                    i++;
                }
                tokens.add(new Token(TokenType.INT, number.toString()));
            } else if (Character.isLetter(currentChar)) {
                StringBuilder identifier = new StringBuilder();
                while (i < length && Character.isLetterOrDigit(input.charAt(i))) {
                    identifier.append(input.charAt(i));
                    i++;
                }
                String id = identifier.toString();
                // Check if the identifier is a keyword
                switch (id) {
                    case "if":
                        tokens.add(new Token(TokenType.IF, id));
                        break;
                    case "then":
                        tokens.add(new Token(TokenType.THEN, id));
                        break;
                    default:
                        tokens.add(new Token(TokenType.IDENTIFIER, id));
                        break;
                }
            } else if (currentChar == '+') {
                tokens.add(new Token(TokenType.PLUS, "+"));
                i++;
            } else if (currentChar == '-') {
                tokens.add(new Token(TokenType.MINUS, "-"));
                i++;
            } else if (currentChar == '*') {
                tokens.add(new Token(TokenType.MULTIPLY, "*"));
                i++;
            } else if (currentChar == '/') {
                tokens.add(new Token(TokenType.DIVIDE, "/"));
                i++;
            } else if (currentChar == '(') {
                tokens.add(new Token(TokenType.LEFT_PAREN, "("));
                i++;
            } else if (currentChar == ')') {
                tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
                i++;
            } else {
                // Ignore whitespace
                if (Character.isWhitespace(currentChar)) {
                    i++;
                } else {
                    // Handle unexpected character
                    System.err.println("Unexpected character: " + currentChar);
                    i++;
                }
            }
        }
        // Add an end of stream token
        tokens.add(new Token(TokenType.EOS, "EOS"));
    }

    public Token nextToken() {
        if (position >= tokens.size()) {
            return new Token(TokenType.EOS, "EOS"); // End of Stream token
        }
        return tokens.get(position++);
    }
}
