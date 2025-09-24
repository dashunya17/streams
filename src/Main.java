public class Main {
    public static void main(String[] args) {
        OneThread [] threads = new OneThread[10]; //массив для хранения потоков
        for (int i = 0; i< 10; i++){ //запускаем потоки
            threads[i] = new OneThread(i+1);
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join(); //  ожидание завершения
            } catch (InterruptedException e) {
                System.out.println("Главный поток был прерван");
            }
        }
        System.out.println("Все потоки завершшили выполнение ");
    }
    static class OneThread extends  Thread {
    private final int ID;
     public OneThread(int ID){
         this.ID =ID;
         setName("Thread "+ ID);
     }
     @Override
        public void run(){
         System.out.println("Поток " + ID +" начал работу");
         try {
             Thread.sleep(500);
             System.out.println(getName()+" завершен");
         } catch (InterruptedException e ){
             System.out.println(getName() + " был прерван");
             Thread.currentThread().interrupt();
         }
     }
    }
}
