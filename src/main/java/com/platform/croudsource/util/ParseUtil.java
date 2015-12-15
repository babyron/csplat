package com.platform.croudsource.util;

/**
 * Created by ron on 2015/12/15.
 */
public class ParseUtil {

    public static String doubleToStr(double d[][]){
        StringBuilder sb = new StringBuilder();
        int length = d.length;
        int h = d[0].length;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < h; j++){
                if(i == length - 1 && j == h - 1){
                    break;
                }
                else{
                    sb.append(d[i][j] + " ");
                }
            }
        }
        sb.append(d[length - 1][h - 1]);
        return sb.toString();
    }

    public static double[][] ssToD(String s){
        String ss[] = s.trim().split(" ");
        double dd[][] = new double[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                dd[i][j] = Double.parseDouble(ss[i * 8 + j]);
            }
        }
        return dd;
    }

    public static String doubleToStr(double d[]){
        StringBuilder sb = new StringBuilder();
        int length = d.length;
        for(int i = 0; i < length - 1; i++){
            sb.append(d[i]);
            sb.append(" ");
        }
        sb.append(d[length - 1]);
        return sb.toString();
    }

    public static double[] strToDou(String s){
        String ss[] = s.trim().split(" ");
        double d[] = new double[ss.length];
        for(int i = 0; i < ss.length; i++){
            d[i] = Double.parseDouble(ss[i]);
        }

        return d;
    }



}
