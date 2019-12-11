package service;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mcorekci
 * this class stores foods, books and medical products which will be exempt 
 * for basic sales taxes. 
 * It's better to use a database to stores this items in our behaviour instead of a class
 */
public class ExemptData {
    public static List<String> foodList= Arrays.asList("chocolate","bread");
    public static List<String> bookList= Arrays.asList("book","roman");
    public static List<String> medicalProdList= Arrays.asList("headache pills","eye lotion");
    
    public static boolean isInExemptList(String name) {
        for(String f : ExemptData.foodList){
            if(name.contains(f))
                return true;
        }
        for(String b : ExemptData.bookList){
            if(name.contains(b))
                return true;
        }
        for (String m : ExemptData.medicalProdList) {
            if(name.contains(m))
                return true;
        }
        return false;
    }   
}