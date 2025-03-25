public class Hilo implements Runnable{
  public void run(){
    for(int i=0; i<5; i++){
      System.out.println("Iteración" + (i+1) + " de " + Thread.currentThread().getName());
    }
    System.out.println("Termina el hilo " + Thread.currentThread().getName());
  }
  public static void main(String[] args){
    new Thread(new Hilo(), "Hilo 1").start();
    new Thread(new Hilo(), "Hilo 2").start();
    System.out.println("Termina el hilo principal");
  }
}
