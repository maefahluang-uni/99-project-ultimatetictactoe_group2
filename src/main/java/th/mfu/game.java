package th.mfu;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Scanner;

public class game {
<<<<<<< HEAD
    private String name;
    Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int generateId() {
        Random random = new Random();
        return random.nextInt(5);
    }

    public static int getGameId() {
        return generateId();
    }

    public static int getPlayerXId() {
        return generateId();
    }

    public static int getPlayerOId() {
        return generateId();
    }

=======
   
>>>>>>> 2b95ca82d0ece51810e91658ac7b8f0104dcc4d8

}
