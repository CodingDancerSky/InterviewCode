package fastestRoute;

public class Elevator {
int ID;
int start;
int end;
double time;
boolean stop;

  public Elevator() {
    
  }
  
  public Elevator(int ID, int s, int e) {
    this.ID= ID;
    start = s;
    end = e;
  }
}
