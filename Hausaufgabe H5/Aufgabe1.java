   class  AbstrClass<T, S> {
         private  T value1;
protected  S value2;
protected  AbstrClass(T value1, S value2) {
this .value1 = value1;
this .value2 = value2;
}
public  T getValue1() {
return  value1;
}
public  S getValue2() {
return  value2;
}
}

   class  Impl extends  AbstrClass<String, Double> {
protected  Integer value2;
public  Impl(String value1, int value2) {
super ("Ferdinand", (double ) value2);
this .value2 = value2 + value2;
}
public  void  incrementValue2(Integer value) {
super .value2 += value;
}
public   static   void  main(String[] args) {
Impl impl = new  Impl("Horst", 21);
System.out.println(impl.getValue1()); // Ausgabe 1
System.out.println(impl.getValue2()); // Ausgabe 2
impl.incrementValue2(42);
System.out.println(impl.value2); // Ausgabe 3
System.out.println(impl.getValue2()); // Ausgabe 4
}
}