package org.example;

public class Problem {
    private boolean ok;

    Problem(boolean variable) {
        this.ok = variable;
    }

    public boolean isOver() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
