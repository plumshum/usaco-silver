/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo-flex-5
 */
import java.util.*;
import java.io.*;
public class moocast {
    static int n;
    static List<Wt> cows;
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("mooncast.in"));
        n = in.nextInt();
        cows = new ArrayList<>();
        for(int i = 0; i < n; i++){
           cows.add(new Wt(in.nextInt(), in.nextInt(),in.nextInt())); 
        }
        in.close();
        
        for(int i = 0; i < cows.size(); i++){
            for(int j = 1; j < cows.size(); j++){
                //i prob shoudve made a diff function
                
                if(i == j) continue;
                if( ( ((cows.get(i).x - cows.get(j).x) *(cows.get(i).x-cows.get(j).x)) + ((cows.get(i).y - cows.get(j).y)*(cows.get(i).y - cows.get(j).y))) <= (cows.get(i).power * cows.get(i).power)){
                    //true: is transmissble 
                    cows.get(i).neighbors.add(cows.get(j));
                    //System.out.println("On cow: " + cows.get(i).x + " " + cows.get(i).y);
               // System.out.println("On cow: " + cows.get(j).x + " " + cows.get(j).y);
                }
                if( ((cows.get(j).x - cows.get(i).x) *(cows.get(j).x-cows.get(i).x) + (cows.get(j).y - cows.get(i).y)*(cows.get(j).y - cows.get(i).y)) <= (cows.get(j).power * cows.get(i).power)){
                    //true: is transmissble 
                    cows.get(j).neighbors.add(cows.get(i));
                   // System.out.println("On cow: " + cows.get(i).x + " " + cows.get(i).y);
                //System.out.println("On cow: " + cows.get(j).x + " " + cows.get(j).y);
                }
            }
        }
       // for(Wt i : cows){
        //    for(Wt x : i.neighbors) System.out.println("X: " + x.x + " Y: " + x.y);
         //   System.out.println("Next Cow");
      //  }
        
        int result = 0;
        //you can do recursion or double loop i suppose
        for(int i = 0; i < cows.size(); i++){
            ArrayList<Wt> visited = new ArrayList<>(); //screwed up and on time crunch so made this
            result = Math.max(result, dfs(cows.get(i), visited));
        }
        PrintWriter out = new PrintWriter(new File("moocast.out"));
        out.println(result);
        System.out.println(result);
        out.close();
    }
    static class Wt{
        int x, y, power;
        Wt(int x, int y, int p){
            this.x = x;
            this.y = y;
            power = p;
        }
        ArrayList<Wt> neighbors = new ArrayList<>();
        
    }
    static int dfs(Wt cow, ArrayList<Wt> visited){
        if(visited.contains(cow)){
            return 0;
        }
        int ret = 1; ///make sure you make it equal to one at first! not zero bc you wont be increasing anything with zero lol
        visited.add(cow);
        for(Wt x: cow.neighbors){
            ret += dfs(x, visited); //don't return here nothing gonna be added
        }
       // System.out.println("ret equals to " + ret);
        return ret;
    }
}
    

/*
            Scanner in = new Scanner(new File("mooncast.in"));
        int n = in.nextInt();
        int[][] b = new int[n][3]; //x,y,p of a walkie talkie
        ArrayList<>[] = new ArrayList[n];
        for(int i = 0; i <n; i++){
            b[i] = new int[] {in.nextInt(), in.nextInt(), in.nextInt()};
            
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                int[] p1 = new int[] {b[1][0], b[i][1]}, p2 = new int[] {b[j][0], b[j][1]};
                //function line here
            }
        }
        int ret = 0;
        for(int i = 0; i < n; i++){
            boolean[] v = new boolean[n];
            ret = Math.max(ret, dfs(i,v));
        }
        
        in.close();
        PrintWriter out = new PrintWriter("mooncast.out");
        out.println(ret);
        out.close();
        System.out.println(ret);
    }
    
    static double d(int[] a, int[] b){ //This is Pyth Th
        //return Math.sqrt((a[0] - b[0])*)
        return 6.0;
    }
    
    static int dfs(int curr, boolean[]v){
        if(v[curr]) return 0; 
        v[curr] = true;
        int ret = 1;
        for(int neigh:a[curr]){
           ret += dfs(neigh,v);
        }
        return ret; 
    }
    */