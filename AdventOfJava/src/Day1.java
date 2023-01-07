import java.io.FileNotFoundException;
import java.io.File;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        if (args.length != 1) {
			System.out.println("usage: java Day1 path/to/file.txt");
			System.exit(0);
		}

        String filename = args[0];
        System.out.println("The file is " + filename);

        PriorityQueue<Integer> elves = sortElves(filename);
        int solution1 = part1(elves);
        int solution2 = part2(elves);

        System.out.println("Solution 1:\t" + solution1);
        System.out.println("Solution 2:\t" + solution2);
    }

    public static PriorityQueue<Integer> sortElves(String filename) {
        PriorityQueue<Integer> answer = new PriorityQueue<Integer>(Collections.reverseOrder());

        try{
            Scanner scanner = new Scanner(new File(filename));
            int amount = 0;

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line == ""){
                    answer.add(amount);
                    amount = 0;
                } else {
                    int val = Integer.parseInt(line);
                    amount += val;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return answer;
    }

    public static int part1(PriorityQueue<Integer> elves) {
        int answer = elves.peek();
        return answer;
    }

    public static int part2(PriorityQueue<Integer> calories) {
        int val1 = calories.poll();
        int val2 = calories.poll();
        int val3 = calories.poll();

        int answer = val1 + val2 + val3;
        return answer;
    }
}