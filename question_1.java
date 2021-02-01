// Authors: Cedric Murairi | Mthabisi Ndlovu
// This program simulates the traffic light and let cars go from a queue of cars depending
// on the active light -> uses time sleep to fake the delay

import java.util.*;
import java.util.concurrent.TimeUnit;

public class question_1{
    // declare some vars
    static Random rand = new Random();
    static Boolean red = true;
    static Boolean yellow = false;
    static Boolean green = false;
    // get our queue ready for data
    static PriorityQueue<String> cars = new PriorityQueue<>();
    public static void main(String[] args) throws InterruptedException {
        // insert 100 cars in the queue
        for(int i=0; i<100; i++){
            cars.add("Car " + get_random());
        }

        // as long as the queue has data, we call out cars from it
        while(!cars.isEmpty()){
            // No movement if it's red, move cars otherwise
            if (red){
                System.out.println("Everyone on stand by, no car allowed to move! (20 seconds)");
                TimeUnit.SECONDS.sleep(20);
            }else if (yellow){
                call_out_car("yellow");
            }else if (green){
                call_out_car("green");
            }
            // change to a different light
            change_light();
        }
    }

    // generate random int for car ids
    public static int get_random(){
        int rand_v = rand.nextInt();
        if (rand_v < 0){
            return get_random();
        }
        return rand_v;
    }

    // change light depending on the previous one
    public static void change_light(){
        if (red){
            green = true;
            red = false;
        }else if (green){
            green = false;
            yellow = true;
        }else if (yellow){
            yellow = false;
            red = true;
        }
    }

    // call out cars depending on light: green -> normal | yellow -> slow
    public static void call_out_car(String light) throws InterruptedException{
        if (light == "yellow"){
            System.out.println("\nIt is go time, but you go slowly! (10 seconds)");
            for (int i=0; i<5; i++){
                // sleep for 2 sec -> yellow -> slow
                TimeUnit.SECONDS.sleep(2);
                // remove a car from the queue to go
                String car = cars.poll();
                System.out.println(car + " going out of the queue");
            }
        }else if (light == "green"){
            System.out.println("\nIt is go time! Go crazy go wild, the road is all yours! (30 seconds)");
            for (int i=0; i<30; i++){
                // sleep for 1 sec -> green -> normal
                TimeUnit.SECONDS.sleep(1);
                // remove a car from the queue to go
                String car = cars.poll();
                System.out.println(car + " going out of the queue");
            }
        }
    }
}