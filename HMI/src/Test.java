import java.util.ArrayList;

public class Test {

    private ArrayList<String> shit;
    private String a = "hoer";

    public String getA() {
        return a;
    }

    public Test(){
        shit = new ArrayList<>();

    }

    public void voegToe(String s){
        shit.add(s);
    }

    public void print(){
        for(int i=0; i<shit.size(); i++) {
            String a = shit.get(i);
            System.out.println(a);
        }

    }


}
