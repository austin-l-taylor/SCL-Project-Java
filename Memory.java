import java.util.HashMap;
import java.util.Map;

public class Memory {
    private static Map<String, Integer> memory = new HashMap<>();

    public static void store(String variableName, int value) {
        memory.put(variableName, value);
    }

    public static int retrieve(String variableName) {
        return memory.getOrDefault(variableName, 0);
    }
}
