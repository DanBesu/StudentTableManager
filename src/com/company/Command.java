package com.company;

public interface Command{

    public default String show() {
        return null;
    }

    public default void execute() throws Throwable {

    }
}
