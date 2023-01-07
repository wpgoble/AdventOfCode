import java.io.FileNotFoundException;
import java.io.File;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author William Goble
 */

public class Day1 {
    /**
     * The jungle must be too overgrown and difficult to navigate in vehicles 
     * or access from the air; the Elves' expedition traditionally goes on foot.
     * As your boats approach land, the Elves begin taking inventory of their 
     * supplies. One important consideration is food - in particular, the 
     * number of Calories each Elf is carrying (your puzzle input).
     * 
     * The Elves take turns writing down the number of Calories contained by 
     * the various meals, snacks, rations, etc. that they've brought with them, 
     * one item per line. Each Elf separates their own inventory from the 
     * previous Elf's inventory (if any) by a blank line.
     * @param args
     *  args will contain the filename of our inputs for the day
     */
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

    /**
     * Helper function to create a priority queue in descending order
     * 
     * @param filename
     *      String: string literal of our input source file.
     * @return
     *      Priority Queue in descending order 
     */
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

    /**
     * In case the Elves get hungry and need extra snacks, they need to know 
     * which Elf to ask: they'd like to know how many Calories are being carried
     * by the Elf carrying the most Calories. 
     * 
     * Find the Elf carrying the most Calories. How many total Calories is that 
     * Elf carrying?
     * @param elves
     *      Sorted priority queue of all the elves calories
     * @return
     *      the highest calorie count
     */
    public static int part1(PriorityQueue<Integer> elves) {
        int answer = elves.peek();
        return answer;
    }

    /**
     * Find the top three Elves carrying the most Calories.How many Calories are 
     * those Elves carrying in total?
     * @param calories
     *      Sorted priority queue of all the elves calories
     * @return
     *      the summation of the three highest calorie counts. 
     */
    public static int part2(PriorityQueue<Integer> calories) {
        int val1 = calories.poll();
        int val2 = calories.poll();
        int val3 = calories.poll();

        int answer = val1 + val2 + val3;
        return answer;
    }
}