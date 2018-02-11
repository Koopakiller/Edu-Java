class Course{

    public Course(String title, String docent){
        this.title = title;
        this.docent = docent;
    }

    private String title;

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String value){
        this.title = value;
    }

    private String docent;

    public String getDocent(){
        return this.docent;
    }
    public void setDocent(String value){
        this.docent = value;
    }
}