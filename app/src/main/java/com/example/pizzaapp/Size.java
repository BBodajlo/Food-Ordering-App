package com.example.pizzaapp;

/**
 * Enum for the different sizes a pizza can take on
 * @author Blake Bodajlo, Stanley Jiang
 */
public enum Size {
    Small, Medium, Large;




    /**
     * Get the size of the pizza based off string inputs.
     * @param s The inputted string
     */
    public static Size convertSize(String s)
    {
        System.out.println(s);
        if(s.equalsIgnoreCase("small")){
            return Size.Small;
        }
        else if(s.equalsIgnoreCase("medium")){
            return Size.Medium;
        }
        else {
            return Size.Large;
        }


    }
}
