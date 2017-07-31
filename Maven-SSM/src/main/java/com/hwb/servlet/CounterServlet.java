package com.hwb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;

/**
 * Created by He on 2017/7/31.
 */
public class CounterServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public CounterServlet() {
        super();
    }
    public static void writeFile(String filename,int count){

        try{
            PrintWriter out=new PrintWriter(new FileWriter(filename));
            out.println(count);
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static int readFile(String filename) {
        File f = new File(filename);
        int count = 0;
        if(!f.exists()){
            writeFile(filename, 0);
        }
        try{
            BufferedReader in = new BufferedReader(new FileReader(f));
            try{
                count = Integer.parseInt(in.readLine());
            }catch(NumberFormatException e){
                e.printStackTrace();
            }catch(IOException  e){
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }


    public void init() throws ServletException {
        // Put your code here
    }
}
