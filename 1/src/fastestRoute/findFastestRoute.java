package fastestRoute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * here's a problem that the solution cannot solve the last text input.
 */
public class findFastestRoute {
  public static void main(String[] args) {
    loading l = new loading();
    
    try {
      List<int[]> lists = l.loadingFile(); 
      
      int[] s = lists.remove(0);
      int T = s[0];
      double E = s[1];
      double S = s[2];
      int N = s[3];
      
      List<Elevator> elevators = new ArrayList<Elevator>();   // store the information of elevators  
      HashMap<Integer, Elevator> map = new HashMap<Integer, Elevator>(); // start floor/id
      
      for(int[] e: lists){
        Elevator elevator = new Elevator(e[0], e[1], e[2]);         
        double stairsTime = (Math.abs(elevator.end - elevator.start)) / S;
        if(stairsTime > E){
          elevator.time = E;
        } else {
          elevator.time = stairsTime;
          elevator.stop = true;
        } 
        elevators.add(elevator);
      }
      
//      for(Elevator elevator: elevators){
//        System.out.println(elevator.ID + " //"+ elevator.start + " //" + elevator.end + " //" + elevator.time + elevator.stop);
//      }
            
      for(Elevator elevator: elevators){
        int v = elevator.start;
        if(map.containsKey(v)){
          Elevator est = map.get(v);
          if(est.ID > elevator.ID){
            map.put(v, elevator);
          }else continue;
        }
        map.put(v, elevator);
      }
      
//      for(int i: map.keySet()){
//        System.out.print("start floor: "+i);
//        Elevator e = map.get(i); 
//        System.out.println("   -Elev: "+ e.ID);
//         }
      
     List<Elevator> path = new ArrayList<Elevator>(); 
     Elevator el = map.get(0);
     path.add(el);
     int count = 0;
     while(el.end != T){
       if(count == N) break;
       Elevator n = map.get(el.end);
       path.add(n);
       el = n;
       count++;
     }
       
//     for(Elevator t: path){
//       System.out.print(t.ID + "-->");
//     }     

      String stop = "Stopped: ";
      String time = "Time:  ";
      String pathh = "Path:  ";
      double t = 0;
      
      for(Elevator e: path){
        if(e.stop)
          stop = stop + e.ID + " ";
        
        t += e.time;
        
        pathh = pathh + e.ID + " ";
      }
      
      time = time + t + "";
      if(stop.equals("Stopped: "))
        stop = stop + "None";
      
      System.out.println(stop);
      System.out.println(time);
      System.out.println(pathh);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
