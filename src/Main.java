import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String EMPTY = " ";
    private static final String RIGHT = "  |";
    private static final String MIDDLE = " _ ";
    private static final String MIDDLE_RIGHT = " _|";
    private static final String MIDDLE_LEFT = "|_ ";
    private static final String LEFT_MIDDLE_RIGHT = "|_|";
    private static final String LEFT_RIGHT = "| |";

    private static Map initMap() {
        Map<Integer, String[]> convertMap = new HashMap<Integer, String[]>();
        convertMap.put(0, new String[]{MIDDLE, LEFT_RIGHT, LEFT_MIDDLE_RIGHT});
        convertMap.put(1, new String[]{EMPTY, RIGHT, RIGHT});
        convertMap.put(2, new String[]{MIDDLE, MIDDLE_RIGHT, MIDDLE_LEFT});
        convertMap.put(3, new String[]{MIDDLE, MIDDLE_RIGHT, MIDDLE_RIGHT});
        convertMap.put(4, new String[]{EMPTY, LEFT_MIDDLE_RIGHT, RIGHT});
        convertMap.put(5, new String[]{MIDDLE, MIDDLE_LEFT, MIDDLE_RIGHT});
        convertMap.put(6, new String[]{MIDDLE, MIDDLE_LEFT, LEFT_MIDDLE_RIGHT});
        convertMap.put(7, new String[]{MIDDLE, RIGHT, RIGHT});
        convertMap.put(8, new String[]{MIDDLE, LEFT_MIDDLE_RIGHT, LEFT_MIDDLE_RIGHT});
        convertMap.put(9, new String[]{MIDDLE, LEFT_MIDDLE_RIGHT, MIDDLE_RIGHT});
        return convertMap;
    }

    private static String[][] numberToLCDNumber(Integer number, Map convertMap) {
        char[] charNumbers = String.valueOf(number).toCharArray();
        String[][] result = new String[charNumbers.length][];
        for (int index = 0; index < charNumbers.length; index++) {
            Integer numberItem = Integer.parseInt(String.valueOf(charNumbers[index]));
            result[index] = (String[]) convertMap.get(numberItem);
        }
        return result;
    }

    private static String[] display(String[][] result) {
        String[] finalResult = new String[]{" ", " ", " "};
        for (String[] row : result) {
            for (int column = 0; column < row.length; column++) {
                if (row[column].equals(" ")) {
                    finalResult[column] += new StringBuilder().append("   ");
                } else {
                    finalResult[column] += new StringBuilder().append(row[column]);
                }
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Map map = initMap();
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            int inputNumber = keyboard.nextInt();
            String result[] = display(numberToLCDNumber(inputNumber, map));
            for (String item : result) {
                System.out.print(item + "\n");
            }
        }

    }
}
