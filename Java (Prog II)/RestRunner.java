public class RestRunner {


    public static void main (String[] args) {
        //Should output 6.84
        System.out.println(RestCalc.GetTip(45.62,15));
        
        //Should output 43.79
        System.out.println(RestCalc.SplitCheck(152.3,4));
        
        //Should output 72.46
        System.out.println(RestCalc.GetBudget(250,3));
        
        //Should output 23
        //System.out.println(RestCalc.HowManyMeals(350,12.99));
        
        //Should output 6.41
        //System.out.println(RestCalc.LeftOverBudget(350,12.99));
     
    }
}