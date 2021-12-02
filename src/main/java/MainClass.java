import Exeptions.MyArrayDataException;
import Exeptions.MyArraySizeException;

public class MainClass {
    public static void main(String[] args) {

        String[][] testArray = new String[4][4];
        testArray[0][0] = "5";
        testArray[0][1] = "2";
        testArray[0][2] = "3";
        testArray[0][3] = "6";
        testArray[1][0] = "1";
        testArray[1][1] = "-4";
        testArray[1][2] = "-9";
        testArray[1][3] = "6";
        testArray[2][0] = "-5";
        testArray[2][1] = "4";
        testArray[2][2] = "8";
        testArray[2][3] = "-7";
        testArray[3][0] = "11";
        testArray[3][1] = "1";
        testArray[3][2] = "22";
        testArray[3][3] = "-10";
        try {

            arraySum(testArray,validateTwoDimArray(testArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
    private static boolean validateTwoDimArray(String[][] testArray) {
        int dimSize = testArray.length;

        for (String[] nestedArr : testArray)
            if (nestedArr.length != dimSize) {
                return false;
            }

            return true;

    }
    public static void arraySum(String[][] tempArray,boolean validateTwoDimArray) throws MyArraySizeException, MyArrayDataException {

                if(!validateTwoDimArray){
                    throw new MyArraySizeException("Массив не соответствет требованиям, длина массива должна быть равна 4 на 4");

        }

        int sumCells = 0;
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray.length; j++) {
                try {
                    sumCells += Integer.parseInt(tempArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке: " + i + ", " + j);
                }
            }
        }
        System.out.println(sumCells);
        {
        }

    }
}