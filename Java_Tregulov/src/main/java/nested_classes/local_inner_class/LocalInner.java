package nested_classes.local_inner_class;

public class LocalInner {
    public static void main(String[] args) {
        Math math  = new Math();
        math.getResult(21, 4);
    }

}
class Math{



    public void getResult(int delimoe, int delitel){

        class divided{

            public int getChastnoe(){
                return delimoe / delitel;
            }
            public int getOstatok(){

                return delimoe % delitel;
            }
        }
        divided divided = new divided();

        System.out.println("Delimoe = " + delimoe);
        System.out.println("Delitel = " + delitel);
        System.out.println("Chastnoe = " + divided.getChastnoe());
        System.out.println("Ostatok = " + divided.getOstatok());
    }
}