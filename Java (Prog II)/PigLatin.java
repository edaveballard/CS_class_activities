public class PigLatin
{
    //Instance Variables
    private String english;
    private String pigLatin;
    
    //constants
    private final char[] VOWELS = {'a','e','i','o','u'};


    //constructors
    
    public PigLatin()
    {
        setEnglish("");
        setPigLatin("");
    }

    
    //modifier methods (setters)
    
    public void setEnglish(String en)
    {
        //store the String en as lowercase so we don't have to worry about case-sensitivity
        //also, trim any leading or trailing whitespace
        english = en.toLowerCase().trim();
    }
    
    //make another method 'setPigLatin' here to store the string pigLatin
    
    
    
    
    //accessor methods (getters)
    
    public String getEnglish()
    {
        //change this to return the English language string's value
        return "";
    }
    
    //make another method 'getPigLatin' here to retrieve the value of the string pigLatin
    
    
    
    
    
    //utility methods
    //(these are private methods: only for use within the PigLatin class to break up the problem
    
    //takes a character, returns true if it's a consonant and false if it's a vowel
    private boolean isConsonant(char c) 
    {
        for(int i = 0; i < VOWELS.length; i++)
        {
            if(c == VOWELS[i])
                return false;
        }
        return true;
    }
    
    
    //returns how many consants a word has at the beginning (since all have to be moved to the end to translate to pig latin)
    private int leadingConsonants(String word)
    {
        int count = 0;
        while(false) //replace 'false' with a condition checking whether the first letter in word is a consonant 
        {
            //fill in while loop!
            //each time you find a consonant, add one to count, then chop one letter off of the front of word
        }
        
        
        //now you have counted all of the consonants at the beginning of the word and stored that number in count
        return count;
    }
    
    
    

    //these final methods take care of the business of translating from English to Pig Latin
    
    //method that translates the English word in 'english' to Pig Latin and stores the result in 'pigLatin'
    public void translateToPigLatin()
    {
        //only do if english contains a word!
        if(!english.equals(""))
        {
            int cons = leadingConsonants(english);
            
            //get the first part of the string english (the leading consonants only)
            String first = "";
            //get the second part of the string englihs (everything after the leading consonants)
            String last = "";
            
            pigLatin = last+first+"ay";
        }
    }
    
    
    //method to check whether pigLatin is a valid-looking Pig Latin word
    public boolean verifyPigLatin()
    {
        //return false if pigLatin is shorter than 3 characters
        
        //return false if pigLatin does not end in "ay"
        
        //return false if pigLatin starts with a consonant
        
        
       return true;
    }
    
    
    
    

}