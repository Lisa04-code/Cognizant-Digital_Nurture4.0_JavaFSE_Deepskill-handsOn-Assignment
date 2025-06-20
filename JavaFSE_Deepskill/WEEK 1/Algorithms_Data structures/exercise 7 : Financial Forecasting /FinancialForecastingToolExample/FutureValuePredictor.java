public class FutureValuePredictor{
    public static double calculateFutureValue(double currentValue,double growthRate,int remainingYears){
        if(remainingYears <= 0){
            return currentValue;
        }
        double nextYearValue = currentValue*(1+growthRate);
        return calculateFutureValue(nextYearValue, growthRate, remainingYears-1);
    }
    public static double calculateFutureValueOptimized(double currentValue,double growthRate,int remainingYears,double accumulatedValue){
        if(remainingYears <= 0){
            return accumulatedValue;
        }
        return calculateFutureValueOptimized(currentValue, growthRate, remainingYears-1, accumulatedValue*(1+growthRate));
    }
}