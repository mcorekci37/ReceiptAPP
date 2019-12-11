package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mcorekci
 */
public class Basket {
    private List<String> goods;
    
    /*
     * gets the path of the file which contains purchased goods and their values  
     * It just stores goods as a string in a list
     */
    public Basket(String path) throws IOException{
        goods=new ArrayList<String>();
        try{
            // Open the file
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
              // Print the content on the console
                this.goods.add(strLine);
            }
            //Close the input stream
            fstream.close();
        }
        catch(IOException e){
            System.out.println("Problem encountered during opening the file. -->"+e);
        }
    }

    public List<String> getGoods() {
        return goods;
    }

    public void setGoods(List<String> goods) {
        this.goods = goods;
    }
    
    
    
}
