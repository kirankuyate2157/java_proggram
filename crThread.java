package mykkJava;
class mythread extends Thread {
    // @Override
    public void run() {
        int i = 0;
        while (i < 40) {
            System.out.println("i am runing  1111111111111");
            System.out.println("i am Happy");
            i++;
        }
    }
}

class mythread2 extends Thread {
    // @Override
    public void run() {
        int i = 0;
        while (i < 40) {
            System.out.println("i am runing  2222222222222");
            System.out.println("i am crazy");
            i++;
        }
    }
}

class mythread3 extends Thread {
    // @Override
    public void run() {
        int i = 0;
        while (i < 40) {
            System.out.println("i am runing  3333333333333");
            System.out.println("i am sad");
            i++;
        }
    }
}

public class crThread {

    public static void main(String[] args) {
        mythread t1 = new mythread();
        mythread2 t2 = new mythread2();
        mythread3 t3 = new mythread3();
        t1.start();
        t2.start();
        t3.start();

    }
}
