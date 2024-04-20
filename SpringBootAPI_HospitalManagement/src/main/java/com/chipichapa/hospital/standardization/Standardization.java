package com.chipichapa.hospital.standardization;


/**
 This class is used to standardize name or other string variable when we use request methods
 in controller
 **/
public class Standardization {

    //Constructor
    public Standardization(){}
    /**
     This method standardize the spaces in a string.
     Some object's name (like sickness) contains special capital letters
     ,so they just need to be standardized for spacing.
     It's used in class sicknessController. (and may be more class).
     **
     @param str : a string (can be sickName,...)
     *
     @return a new string after standardize;
     Example: str = "   pulmonary  tuberculosis  "
     return "pulmonary tuberculosis".
     */
    public String StandardSpace(String str)
    {
        str = str.trim();
        str = str.replaceAll("\\s+"," ");
        return str;
    }

    /**
     This method standardize a name.
     1/Capitalize the first letter of the first name, middle name (if applicable), and last name.
     2/Separate the first name, middle name (if applicable), and last name with only one space.
     3/No space before and after name;
     **
     @param name: a name (can be name of a person,...)
     *
     @return a new string after standardize;
     Example: str = "  jOHn michael   sMiTH    "
     return "John Michael Smith".
     */
    public String StandardName(String name)
    {
        name = name.trim();
        name = name.replaceAll("\\s+"," ");
        String[] words = name.toLowerCase().split(" ");
        StringBuilder builder = new StringBuilder();
        for( String item : words)
        {
            char[] character = item.toCharArray();
            character[0] = Character.toUpperCase(character[0]);
            builder.append(character);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
