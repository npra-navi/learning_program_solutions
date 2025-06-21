public class FinancialForecasting {
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double predictFutureValueMemoized(double currentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != null) {
            return memo[years];
        }
        memo[years] = predictFutureValueMemoized(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; 
        double growthRate = 0.05;     
        int years = 5;                

        double futureValue = predictFutureValue(initialValue, growthRate, years);
        System.out.println("Future Value (Recursive): " + futureValue);

        Double[] memo = new Double[years + 1];
        double futureValueMemoized = predictFutureValueMemoized(initialValue, growthRate, years, memo);
        System.out.println("Future Value (Memoized): " + futureValueMemoized);

        System.out.println("Time Complexity:");
        System.out.println("Recursive: O(n) (linear recursive calls for n years)");
        System.out.println("Memoized: O(n) (linear with memoized results preventing duplicate calculations)");
    }
}
