package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx2 {
    public static void main(String[] args) {

        try(RandomAccessFile file = new RandomAccessFile("test5.txt", "r");
            FileChannel channel = file.getChannel()){

            ByteBuffer buffer1 = ByteBuffer.allocate(5);
            channel.read(buffer1);
            buffer1.flip();
            System.out.println((char)buffer1.get());
            System.out.println((char)buffer1.get());
            System.out.println((char)buffer1.get());
            buffer1.rewind();// возвращает позицию на нулевую, используется если нужно повторно прочитать данные
            System.out.println((char)buffer1.get());

            System.out.println("--------------------------------");
            buffer1.compact();// используется если вы не хотите терять свои байты, но вам нужно что-то записать в буфер
            channel.read(buffer1);
            buffer1.flip();
            while(buffer1.hasRemaining()){
                System.out.println((char)buffer1.get());
            }
            System.out.println("--------------------------------");
            buffer1.clear(); // сбрасывает позицию на нулевую отметку. Подготавливает буфер к новой записи
            channel.read(buffer1);
            buffer1.flip();// переводит буфер из режима записи в режим чтения
            System.out.println((char)buffer1.get());
            buffer1.mark();// этот метод ставит метку на байте на который можно вернуться
            System.out.println((char)buffer1.get());
            System.out.println((char)buffer1.get());
            buffer1.reset();// возвращает на позицию которая отмечена методом mark()
            while (buffer1.hasRemaining()){
                System.out.println((char)buffer1.get());
            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
