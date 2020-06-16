#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_STR_LEN 80

struct node {       //tworzenie strutury string klucz i wkaznik do nastepnego
   char *data;
   int key;
   struct node *next;
};

struct node *head = NULL;  //tworzenie head current i wskazuja na nic
struct node *current = NULL;
struct node *head2 = NULL;
struct node *current2 = NULL;
struct node *head3 = NULL;

void printList(struct node *pointer) { //tworzenie tymczasowego wskanika co wskazuje na poczatek list 
    struct node *ptr = pointer; //oraz iteracja aż ptr nie bedzie na nic wskazywal
    printf("\n");
    while(ptr != NULL) {
        printf("%d %s\n",ptr->key,ptr->data);
        ptr = ptr->next;
    }
    printf("\n");
}
void insertFirst(int key, char *data) {
    struct node *link = (struct node*) malloc(sizeof(struct node));
    link->key = key;
    link->data = data;
    link->next = head;
    head = link;
}

struct node* deleteFirst(){
    struct node *tempLink = head;
    head = head -> next;
    return tempLink;
}
bool isEmpty(struct node* head) {
    return head == NULL;
}

int length() {
    int length = 0;
    struct node *current;

    for(current = head; current != NULL; current = current->next) {
        length++;
    }

    return length;
}

struct node* delete(char *data) {
    struct node* current = head;
    struct node* previous = NULL;
    if(head == NULL) {
        return NULL;
    }
    while(current->data != data) {
        if(current->next == NULL) {
            return NULL;
        } 
        else {
            previous = current;
            previous->key--;
            current = current->next;
        }
    }
    if(current == head) {
        head = head ->next;

    }
    else {
        previous->next = current->next;
    }
    return current;
}
void deleteAll(struct node *pointer) {
    struct node *tempLink;
    while(!isEmpty(pointer)) { 
        tempLink = pointer; 
        pointer = pointer->next;       
        free(tempLink);  
    
   } 

}
int findCount(char *data) {
   struct node *ptr = head2;
   int counter = 0;
    while(ptr != NULL) {
        if(strcmp(ptr->data, data) == 0)
            counter++;
        ptr = ptr->next;
    }
    return counter;
}
// void printList2() {
//     struct node *ptr = head2; //oraz iteracja aż ptr nie bedzie na nic wskazywal
//     printf("\n");
//     while(ptr != NULL) {
//         printf("%d %s\n",ptr->key,ptr->data);
//         ptr = ptr->next;
//     }
//     printf("\n");
// }

struct node* bezPow() {
    struct node* current = head;
    while(current != NULL) {
            struct node *link = (struct node*) malloc(sizeof(struct node));
            link->key = current->key;
            link->data = current->data;
            if(findCount(link->data) == 0) {
                link->next = head2;
                head2 = link;
            }
            current = current->next;
        }
    return head2;
}

    


void reverse(struct node** head_ref) {
   struct node* prev   = NULL;
   struct node* current = *head_ref;
   struct node* next;
	
   while (current != NULL) {
      next  = current->next;
      current->next = prev;   
      prev = current;
      current = next;
   }
	
   *head_ref = prev;
}

struct node* scal(struct node *head, struct node *head2) {
    struct node *current = head;
    while(current != NULL) {
        struct node *link = (struct node*) malloc(sizeof(struct node));
            link->key = current->key;
            link->data = current->data;
            link->next = head3;
            head3 = link;
            current = current->next;
    }
    printf("Wywala 1\n");
    deleteAll(head);

    current = head2;
    while(current != NULL) {
        struct node *link = (struct node*) malloc(sizeof(struct node));
            link->key = current->key;
            link->data = current->data;
            link->next = head3;
            head3 = link;
            current = current->next;
    }
    deleteAll(head2);
        printf("Wywala 2\n");


    return head3;
}


struct node* find(char *data) {
   struct node *ptr = head;
    while(ptr != NULL) {
        if(strcmp(ptr->data, data) == 0)
            return ptr;
        ptr = ptr->next;
    }
    return NULL;
}
int main() {
    insertFirst(1,"abc");
    insertFirst(2,"afs");
    insertFirst(3,"asdddd");
    insertFirst(4,"abc");
    printList(head);

    struct node *foundLink = find("affs");
    if(foundLink != NULL) {
        printf("Element %d, %s\n",foundLink->key,foundLink->data);
    }
    else {
        printf("Element not found\n");
    }

    bezPow();
    reverse(&head2);
    printList(head2);

    char *x = "afs";
    delete(x);
    printList(head);

    printList(head2);
    scal(head,head2);
    reverse(&head3);
    printList(head3);
    // deleteAll();
    // printf("Usuwam wszystkie\n");
    // printList();
    


    return 0;
}