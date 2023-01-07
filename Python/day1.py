from typing import Tuple

__author__ = "William Goble"
__email__ = "will.goble@gmail.com"

def getInput(file:str) -> list:
    """
    Reads content of a file into a list

    Parameters:
        file (str): filename of the file we are working wiht
    
    Returns:
        output (list): The list of each line in the file
    """

    with open(file, 'r') as f:
        output = f.readlines()

    return output

def part1(lines:list) -> Tuple[list, int]:
    """
    Creates an ordered list of the number of calories that each elf 
    is holding.

    Parameters:
        lines (list): list of lines read in from the files
    
    Returns:
        amount (list): sorted list in descending order of what each elf is 
            holding
        ans (int): Most calories being held by an elf
    """
    total = 0
    amount = []

    for line in lines:
        if line == '\n':
            line = 'skip_me'
        try:
            line = int(line.strip())
            total += line
        except:
            amount.append(total)
            total = 0
    amount = sorted(amount, reverse=True)
    return amount, amount[0]

def part2(lines:list) -> int:
    """
    Given a sorted list of weights, find the sum of the three heaviest weights

    Parameters:
        liens (list): sorted list of weights
    
    Returns:
        ans (int): summation of the three heaviest items
    """
    return lines[0] + lines[1] + lines[2]

def main():
    """ Driver function """
    elves_input = getInput('../inputs/day1.txt')
    sorted_elves, solution1 = part1(elves_input)
    solution2 = part2(sorted_elves)

    print(f'Solution 1:\t{solution1}')
    print(f'Solution 2:\t{solution2}')

if __name__ == '__main__':
    main()