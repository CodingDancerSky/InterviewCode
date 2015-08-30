package palindromePhrases;

public class RangedString {
String s;
int start;
int end;

  RangedString(String s, int start, int end){
    this.s = s;
    this.start = start;
    this.end = end;
  }

  RangedString() {
  }
  
  int length(){
    return end - start + 1;
  }
}
