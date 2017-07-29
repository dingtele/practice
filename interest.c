#include<stdio.h>
#define num_rates ((int)(sizeof(value)/sizeof(value[0])))
#define initial_balance 100.00

int main(void)
{
	int i, low_rate, num_years, year;
    double value[5];

	printf("enter the rate: ");
    scanf("%d", &low_rate);
	printf("enter number of year: ");
	scanf("%d", &num_years);

	printf("\nyear");
	for(i=0; i<num_rates;i++){
		printf("%6d%", low_rate+i);
	value[i]=initial_balance;
    }
    printf("\n");

	for(year=1; year<=num_years; year++){
		printf("%3d    ", year);
    	for(i=0; i<num_rates;i++){
			value[i]+= (low_rate+i)/100.0 * value[i];
			printf("%7.2f", value[i]);
		}
		printf("\n");
    }

	return 0;
}
      
