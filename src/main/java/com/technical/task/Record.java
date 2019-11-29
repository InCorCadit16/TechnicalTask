package com.technical.task;

 class Record {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;


    boolean hasWrongData() {
        return A.isEmpty() | B.isEmpty() |
                C.isEmpty() | D.isEmpty() |
                E.isEmpty() | F.isEmpty() |
                G.isEmpty() | H.isEmpty() |
                I.isEmpty() | J.isEmpty();
    }

    @Override
    public String toString() {
        return A + "," + B + "," + C +"," + D +"," + E +
                F + "," + G + "," + H +"," + I +"," + J;
    }

    String getA() {
        return A;
    }

    void setA(String a) {
        A = a;
    }

    String getB() {
        return B;
    }

     void setB(String b) {
        B = b;
    }

     String getC() {
        return C;
    }

     void setC(String c) {
        C = c;
    }

     String getD() {
        return D;
    }

     void setD(String d) {
        D = d;
    }

     String getE() {
        return E;
    }

     void setE(String e) {
        E = e;
    }

     String getF() {
        return F;
    }

     void setF(String f) {
        F = f;
    }

     String getG() {
        return G;
    }

     void setG(String g) {
        G = g;
    }

     String getH() {
        return H;
    }

     void setH(String h) {
        H = h;
    }

     String getI() {
        return I;
    }

     void setI(String i) {
        I = i;
    }

     String getJ() {
        return J;
    }

     void setJ(String j) {
        J = j;
    }
}
