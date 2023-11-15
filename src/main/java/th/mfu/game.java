package th.mfu;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Scanner;

public class game {
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

    public static void main(String args[]) {

    }

}
