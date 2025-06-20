public class FinancialForecastDemo {
    public static void main(String[]args){
        double initialInvestment = 20000.00;
        double annualGrowthRate = 0.07;
        int projectionYears = 10;

        double futureValue = FutureValuePredictor.calculateFutureValue(initialInvestment, annualGrowthRate, projectionYears);
        double optimizedValue = FutureValuePredictor.calculateFutureValueOptimized(initialInvestment, annualGrowthRate, projectionYears,initialInvestment);
        System.out.println("Financial Forecasting Results");
        System.out.println("------------------------------");
        System.out.printf("Initial Investment:$%.2f%n",initialInvestment);
        System.out.printf("Annual Growth Rate:%.2f%%%n",annualGrowthRate*100);
        System.out.printf("Projection Period:%d years%n",projectionYears);
        System.out.printf("Standard Recursion Future Value:$%.2f%n",futureValue);
        System.out.printf("Optimized Recursion Future Value:$%.2f%n",optimizedValue);

        System.out.println("\nAlgorithm Analysis");
        System.out.println("--------------------");
        System.out.println("Time Complexity:O(n)-Linear time");
        System.out.println("Space Complexity:O(n)-Call stack space");
        System.out.println("Optimization Note:The optimized version uses tail recursion");
        System.out.println("which some JVMs can optimize to O(1)space complexity");
    }
}
