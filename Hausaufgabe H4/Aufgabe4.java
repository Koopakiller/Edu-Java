public class A {
    protected int i;

    protected A(int i) {
        this.i = i;
    }
}

public class B extends A {
    protected int j;

    protected B(int i, int j) {
        super(0);
        this.i = i;
        this.j = j;
    }
}

public class C extends B {
    int k;

    public C(int i, int j, int k) {
        super(i, j);
        this.k = k;
    }
}