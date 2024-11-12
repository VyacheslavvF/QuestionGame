package game;

import java.util.Random;

public class GeneratorOfNumbers {
    public static int[] uniqueNumbers;

    public static int[] generateUniqueRandomNumbers(int min, int max, int count) {
        uniqueNumbers = new int[count];

        Random random = new Random();

        var generatedCount = 0;

        while(generatedCount < count) {
            var randomNumber = random.nextInt(max - min + 1) + min;

            if(!isNumberInArray(uniqueNumbers, randomNumber, generatedCount)) {
                uniqueNumbers[generatedCount] = randomNumber;
                generatedCount++;
            }
        }
        return uniqueNumbers;
    }

    private static boolean isNumberInArray(int[] uniqueNumbers, int randomNumber, int generatedCount) {
        for (var i=0; i < generatedCount; i++) {
            if(uniqueNumbers[i] == randomNumber) {
                return true;
            }
        }
        return false;
    }

}