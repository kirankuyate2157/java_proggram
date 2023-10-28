package mykkJava;
class mythd implements Runnable {
    public void run() {
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
        System.out.println("me is 111111111");
    }
}

class mythd2 implements Runnable {
    public void run() {
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
        System.out.println("hey i am 22");
    }
}

public class runblTrhead {
    public static void main(String[] args) {
        mythd bul = new mythd();
        Thread gun = new Thread(bul);
        mythd2 bul2 = new mythd2();
        Thread gun2 = new Thread(bul2);
        gun.start();
        gun2.start();

    }
}
