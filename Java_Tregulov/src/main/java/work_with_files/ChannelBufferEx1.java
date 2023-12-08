package work_with_files;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx1 {
    public static void main(String[] args) {

        try (RandomAccessFile file = new RandomAccessFile("test10.txt", "rw");
             FileChannel channel = file.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(1);
            StringBuilder sb = new StringBuilder();
            int byteRead = channel.read(buffer);
            while (byteRead > 0){
                System.out.println("Read " + byteRead);
                buffer.flip();
                while (buffer.hasRemaining()){
                    sb.append((char) buffer.get());
                }
                buffer.clear();
                byteRead = channel.read(buffer);
            }
            System.out.println(sb);
            String text = "\nThere are only two ways to live your life." +
                    "\nOne is as though nothing is a miracle. \nThe other is as" +
                    " though everything is a miracle.";

//            ByteBuffer buffer2 = ByteBuffer.wrap(text.getBytes());
//            channel.write(buffer2);
//            ByteBuffer buffer2 = ByteBuffer.allocate(text.getBytes().length);
//            buffer2.put(text.getBytes());
//            buffer2.flip();
//            channel.write(buffer2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
