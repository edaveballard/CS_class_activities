public class VariableScopeRunner {

    public static void main (String[] args) {
        
        VariableScope zeroes = new VariableScope();
        
        VariableScope ones = new VariableScope(1,1);
        
        VariableScope onethree = new VariableScope(3);
        
        //print contents of zeroes
        
        System.out.println(zeroes.toString());
        
        //print contents of ones
        
        System.out.println(ones.toString());
        
        
        /*
        //change values in zeroes to 5 and 4
        
        zeroes.Vulnerable = 5;
        
        zeroes.Secure = 4;
        
        //print contents of zeroes
        
        System.out.println(zeroes.toString());
        
        
        //now check and see if we can print each value individually
        
        System.out.println(zeroes.Vulnerable + " " + zeroes.Secure);
        */
        
        
        
    }

}