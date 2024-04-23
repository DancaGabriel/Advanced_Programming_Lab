package org.example;

import java.util.Objects;

public class Token {
    private int first;
    private int second;

    public Token(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return first == token.first && second == token.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
