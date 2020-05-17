import java.util.StringTokenizer;

public class StudInfo{
  
    private String rollNumber = "";
    private int[] rNoComps = new int[4];
    private String dept = "";
  
    public StudInfo(String rollNumber){
        this.rollNumber = rollNumber;
        splitString();
    }
  
    private void splitString(){
        StringTokenizer strTok = new StringTokenizer(rollNumber, "-");
        int i = 0;
        while(strTok.hasMoreTokens()){
            rNoComps[i] = Integer.parseInt(strTok.nextToken());
            i++;
        }
    }
    
    public String getDepartment(){
        switch(rNoComps[2]){
            case 736:
                dept = "Mechanical Engineering";
                break;
            case 737:
                dept = "Information Technology";
                break;
            case 733:
                dept = "Computer Science and Engineering";
                break;
            case 732:
                dept = "Civil Engineering";
                break;
            case 735:
                dept = "Electronics and Communications";
                break;
            case 734:
                dept = "Electrical and Electronics";
                break;
            default :
                dept = "Wrong input";
        }        
        return dept;        
    }
}