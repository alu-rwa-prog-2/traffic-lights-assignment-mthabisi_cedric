// Authors: Cedric Murairi | Mthabisi Ndlovu
// This program declares and initialises three maps then copies them to new ones

import java.util.*;

public class question_2 {
    public static void main(String[] args){
        // declare three maps
        HashMap<String, String> capitalCities = new HashMap<>();

        capitalCities.put("DRC", "Kinshasa");
        capitalCities.put("Rwanda", "Kigali");
        capitalCities.put("Kenya", "Nairobi");
        capitalCities.put("South Africa", "Pretoria");
        capitalCities.put("Bostwana", "Gaborone");

        HashMap<String, Integer> customerOrder = new HashMap<>();

        customerOrder.put("Cédric", 1293293);
        customerOrder.put("Mthabisi", 3490204);
        customerOrder.put("Lannister", 3034048);

        HashMap<String, String> bigTechCeo = new HashMap<>();

        bigTechCeo.put("Google", "Sundar Pichai");
        bigTechCeo.put("Facebook", "Mark Zuckerberg");
        bigTechCeo.put("Apple", "Tim Cook");
        bigTechCeo.put("Tesla", "Elon Musk");

        // prepare copy
        HashMap<String, String> newMap_1 = new HashMap<>();
        HashMap<String, Integer> newMap_2 = new HashMap<>();
        HashMap<String, String> newMap_3 = new HashMap<>();

        // start copy
        // using putAll method in Java
        newMap_1.putAll(capitalCities);

        // using loop
        for(Map.Entry<String, Integer> entry : customerOrder.entrySet()){
            newMap_2.put(entry.getKey(), entry.getValue());
        }

        // using a new Map method
        newMap_3 = new HashMap<>(bigTechCeo);

        // display copy result
        for(Map.Entry<String, String> entry : newMap_1.entrySet()){
            System.out.println("Country: " + entry.getKey() + " | Capital city: " + entry.getValue() );
        }

        for(Map.Entry<String, Integer> entry : newMap_2.entrySet()){
            System.out.println("Customer: " + entry.getKey() + " | Order ID: " + entry.getValue() );
        }

        for(Map.Entry<String, String> entry : newMap_3.entrySet()){
            System.out.println("Company: " + entry.getKey() + " | CEO: " + entry.getValue() );
        }
    }
}
