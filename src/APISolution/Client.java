package APISolution;


import java.util.Observer;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Subject subject = new Subject(0);
        Observer binary = (Observer) new BinaryObserver(subject);
        Observer octal = new OctalObserver(subject);
        Observer hexa = new HexaObserver(subject);
        Thread thread = new Thread(subject);
        thread.start();
    }

}