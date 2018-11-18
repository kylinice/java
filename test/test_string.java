package test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test_string {
    public static void main(String[] args) {
        String a = "a";
        a += "a";
        System.out.println(a.hashCode());
        System.out.println();
        String 中 = "string";
        System.out.println(中);
        try{
            throw new IOException();
        } catch (FileNotFoundException e) {
            System.out.println("1");
        }catch (IOException e){
            System.out.println("2");
        }catch (Exception e){
            System.out.println("3");
        }

    }
}
