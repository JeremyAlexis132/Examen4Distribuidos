public class EjThreadGroup extends Thread{
  public EjThreadGroup(ThreadGroup grupo, String nombre){
    super(grupo, nombre);
  }
  @Override
  public void run(){
    for(int i=0; i<10; i++){
      System.out.println(getName());
    }
  }
  public static void listarHilos(ThreadGroup grupoActual){
    int numHilos;
    Thread[] listaHilos;
    numHilos = grupoActual.activeCount();
    listaHilos = new Thread[numHilos];
    grupoActual.enumerate(listaHilos);
    System.out.println("Hilos activos: " + numHilos);
    for(int i=0; i<numHilos; i++){
      System.out.println("Hilo " + i + ": " + listaHilos[i].getName());
    }
  }
  public static void main(String[] args){
    ThreadGroup grupoHilos = new ThreadGroup("Grupo con prioridad normal");
    Thread hilo1 = new EjThreadGroup(grupoHilos, "Hilo 1 con max prioridad");
    Thread hilo2 = new EjThreadGroup(grupoHilos, "Hilo 2 con prioridad normal");
    Thread hilo3 = new EjThreadGroup(grupoHilos, "Hilo 3 con prioridad normal");
    Thread hilo4 = new EjThreadGroup(grupoHilos, "Hilo 4 con prioridad normal");
    Thread hilo5 = new EjThreadGroup(grupoHilos, "Hilo 5 con prioridad normal");
    hilo1.setPriority(Thread.MAX_PRIORITY);
    grupoHilos.setMaxPriority(Thread.NORM_PRIORITY);
    System.out.println("Prioridad máxima del grupo: " + grupoHilos.getMaxPriority());
    System.out.println("Prioridad del hilo 1: " + hilo1.getPriority());
    System.out.println("Prioridad del hilo 2: " + hilo2.getPriority());
    System.out.println("Prioridad del hilo 3: " + hilo3.getPriority());
    System.out.println("Prioridad del hilo 4: " + hilo4.getPriority());
    System.out.println("Prioridad del hilo 5: " + hilo5.getPriority());
    hilo1.start();
    hilo2.start();
    hilo3.start();
    hilo4.start();
    hilo5.start();
    listarHilos(grupoHilos);
  }
}
