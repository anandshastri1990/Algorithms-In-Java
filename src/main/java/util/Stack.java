package util;

import java.util.ArrayList;

public class Stack {

    private ArrayList<Object> objects = new ArrayList<>();

    public void push(Object o) {
        objects.add(o);
    }

    public Object pop() {
        Object o = objects.get(objects.size() - 1);
        objects.remove(o);

        return o;
    }

    public Object peek() {
        return objects.get(objects.size() - 1);
    }

    public boolean empty() {
        return objects.size() == 0;
    }

    public Object search(Object o) {
        Object result = null;
        if (objects.contains(o)) {
            for (Object object : objects) {
                if (object == o) {
                    result = object;
                }
            }
        }

        return result;
    }
}
