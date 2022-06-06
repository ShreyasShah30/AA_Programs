#include<iostream>
int partition(int arr[], int low, int high)
{
    srand(time(NULL));
    int index = rand() % (high - low + 1) + low;
    int i = low;
    int temp = arr[high];
    arr[high] = arr[index];
    arr[index] = temp;

    int pivot = arr[high];
    for(int j = low; j<high; j++)
    {
        if(arr[j]<=pivot)
        {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
        }
    }

    temp = arr[high];
    arr[high] = arr[i];
    arr[i] = temp;
    return i;
}

void quicksort(int arr[], int low, int high)
{
    if(low < high)
    {
        int p = partition(arr, low, high);
        quicksort(arr, low, p-1);
        quicksort(arr, p+1, high);
    }
}

int main()
{
    int arr[] = {5,7,2,9,1,6};
    quicksort(arr, 0, 5);
    for(int i=0; i<6; i++)
    {
        printf("%d\t", arr[i]);
    }
    return 0;
}