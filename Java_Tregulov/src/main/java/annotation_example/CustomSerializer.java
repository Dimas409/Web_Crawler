package annotation_example;

import java.io.*;

public class CustomSerializer implements Serializable {
    private String data;

    public CustomSerializer(String data) {
        this.data = data;
    }

    // Метод для записи объекта в поток байтов (сериализация)
    private void writeObject(ObjectOutput out) throws IOException {
        // Запишем данные объекта в поток в нашем собственном формате
        out.writeUTF("CUSTOM_PREFIX_" + data);
    }

    // Метод для восстановления объекта из потока байтов (десериализация)
    private void readObject(ObjectInput in) throws IOException, ClassNotFoundException {
        // Прочтем данные из потока в нашем собственном формате и удалим префикс
        String rawData = in.readUTF();
        if (rawData.startsWith("CUSTOM_PREFIX_")) {
            data = rawData.substring("CUSTOM_PREFIX_".length());
        } else {
            throw new IOException("Invalid data format");
        }
    }

    public String getData() {
        return data;
    }
    public static void main(String[] args) {
        // Создаем объект CustomSerializer
        CustomSerializer customObject = new CustomSerializer("Hello, World!");

        // Сериализуем объект в байтовый массив
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(customObject);
            byte[] bytes = byteArrayOutputStream.toByteArray();

            // Восстанавливаем объект из байтового массива
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                 ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

                CustomSerializer restoredObject = (CustomSerializer) objectInputStream.readObject();
                System.out.println("Restored Data: " + restoredObject.getData());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
