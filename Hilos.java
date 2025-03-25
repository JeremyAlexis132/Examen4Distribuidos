public class Hilos extends Thread{
  public Hilos(String nombre){
    super(nombre);
  }
  @Override
  public void run(){
    for(int i=0; i<10; i++){
      System.out.println("Iteración" + (i+1) + " de " + getName());
    }
    System.out.println("Termina el hilo " + getName());
  }
  public static void main(String[] args){
    new Hilos("Hilo 1").start();
    new Hilos("Hilo 2").start();
    System.out.println("Termina el hilo principal");
  }
}