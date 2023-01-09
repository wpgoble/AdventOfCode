#include <iostream>

void printPhrase(const std::string& word) {
    std::cout << word << std::endl;
}

int main(){
    std::cout << "Hello World!\n";
    printPhrase("This is a test");

    return 0;
}