public class VariableScope {

    public int Vulnerable;
    private int Secure;
    
    //Constructor (don't know what I want yet)
    public VariableScope () {
        Vulnerable = 0;
        Secure = 0;
    }
    
    //Constructor (where I know what I want)
    public VariableScope(int v, int s) {
           
    }
    
    //Modifier
    public void setSecure(int s) {
        
    }
    
    //Accessor
    public int getSecure() {
        return s;   
    }
    
    
    //Accessor
    public String toString() {
        return "Vulnerable = " + Vulnerable + ", Secure = " + Secure;   
    }
    

}