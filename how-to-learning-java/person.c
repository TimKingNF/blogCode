// file: person.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Person {
    char name[12];
    int balance;
} Person;

void buy(Person *person, int cost)
{
  person->balance -= cost;
}

int main()
{
    // 初始化对象
    Person *pmst = (Person *)malloc(sizeof(Person));
    strcpy(pmst->name, "pmst");
    pmst->balance = 18;

    // 调用方法
    buy(pmst, 10);

    printf("%s balance: %d\n", pmst->name, pmst->balance);
    return 0;
}
