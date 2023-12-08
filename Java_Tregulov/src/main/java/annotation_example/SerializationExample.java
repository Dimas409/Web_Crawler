package annotation_example;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.io.*;
import java.util.*;

class MySingleton implements Serializable {
    private static final MySingleton INSTANCE = new MySingleton();

    private MySingleton() {}

    public static MySingleton getInstance() {
        return INSTANCE;
    }

    private Object writeReplace() {
        return new SerializationProxy();
    }

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 1L;

        private Object readResolve() {
            return MySingleton.getInstance();
        }
    }
}

public class SerializationExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MySingleton originalSingleton = MySingleton.getInstance();

        // Сериализация в массив байтов
        byte[] serializedData;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(originalSingleton);
            serializedData = byteArrayOutputStream.toByteArray();
        }

        // Десериализация из массива байтов
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            MySingleton deserializedSingleton = (MySingleton) objectInputStream.readObject();
            System.out.println("Are they the same instance? " + (originalSingleton == deserializedSingleton));
        }


    }


}
