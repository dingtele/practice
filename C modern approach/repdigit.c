repdigit.c

#include <stdio.h>

int main(void)
{
  int digit, digit_count[10]={0};
  long n;
  
  printf("enter a number："）;
  scanf("%ld",&n);
  
  while(n>0){
    digit=n%10;
    digit_count[digit]++;
    n/=10;
  }
  
  printf("digit: ");
  for(digit=0;digit<=9;digit++)
   printf("%3d",digit);
  printf("\nOccurrences:");
  for(digit=0;digit<=9;digit++)
   printf(""%3d",digit_count[digit]
  
  printf("\n");
  
  return 0;
}
