public class Favorites
{
    private String favoriteThings[];
    private final int NUMBER = 3;
    
    public Favorites()
    {
        favoriteThings = new String[NUMBER];
    }
    
    public int numberOfFavorites()
    {
        return NUMBER;
    }
    
    public void setThing(int n, String s)
    {
           
    }
    
    public String toString()
    {
        String favs = "";
            
        for(int i = 0; i < NUMBER; i++)
        {
            favs = favs + " placeholder, ";   
        }
            
        return "My favorite things are "+favs;
    }
    
    

}