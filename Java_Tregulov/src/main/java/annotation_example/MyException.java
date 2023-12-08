package annotation_example;

import java.io.IOException;

public class MyException<T extends IOException> {
    void foo() throws T{}
}
