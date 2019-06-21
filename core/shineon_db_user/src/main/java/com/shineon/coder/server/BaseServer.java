package com.shineon.coder.server;

import java.util.List;

public interface BaseServer<T> {

    T getItem(int id);

    List listItem();

    int insertItem(T t);

    int deleteItem(int id);

    void updateItem(T t);
}
