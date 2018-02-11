import java.util.*;

class Faculty{

    public Faculty(String name){
        this.name = name;
        this.courses = new ArrayList<Course>();
    }

    public List<Course> courses;

    private String name;

    public String getName(){
        return this.name;
    }
    public void setName(String value){
        this.name = value;
    }
}