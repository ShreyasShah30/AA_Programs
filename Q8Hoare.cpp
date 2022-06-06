#include <iostream>

int partition(int arr[], int low, int high)
{
    srand(time(NULL));
    int index = rand() % (high - low + 1) + low;
    int temp = arr[index];
    arr[index] = arr[low];
    arr[low] = temp;
    int pivot = arr[low];
    int i = low - 1;
    int j = high + 1;
    while (true)
    {
        do
        {
            i++;
        } while (arr[i] < pivot);
        do
        {
            j--;
        } while (arr[j] > pivot);

        if (i >= j)
        {
            return j;
        }
        else
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

void quicksort(int arr[], int low, int high)
{
    if (low < high)
    {
        int p = partition(arr, low, high);
        quicksort(arr, low, p);
        quicksort(arr, p + 1, high);
    }
}

int main()
{
    int arr[] = {5, 7, 1, 9, 8, 10};

    quicksort(arr, 0, 5);
    printf("Soreted Array: \n");
    for (int i = 0; i < 6; i++)
    {
        printf("%d\t", arr[i]);
    }
    return 0;
}