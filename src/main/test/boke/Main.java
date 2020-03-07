package boke;
import java.util.*;
import java.util.List;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
           int span = 0;
           for(int i = 0 ; i < xList.size() ; i++){
               if(x < xList.get(i) || x > xList.get(i) || y < yList.get(i) || y > yList.get(i)){
                  span = (int) (span > ( xList.get(i) - x )*( xList.get(i) - x ) + ( yList.get(i) - y )*( yList.get(i) - y) ? ( xList.get(i) - x )*( xList.get(i) - x ) + ( yList.get(i) - y )*( yList.get(i) - y) : span);

                  System.out.println("no " + Math.sqrt(span)); 
               }else{
                  System.out.println("yes 0");
               }
           }
		return null;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}