package ru.geekbrains.lesson2.example;
import static ru.geekbrains.lesson2.example.Ex1.printArray;

// Задание к семинару 2. Реализация алгоритма пирамидальной сортировки (сортировка кучей).

public class Ex5 {
    public static void main(String[] args){
        int[] array = new int[] {14, 54, 45, 78, 5, 12, 57};
        heapSorting(array);
        printArray(array);

    }

        public static void heapSorting(int[] array){
            int n = array.length;
            // Делим массив пополам и перестраиваем
            for (int i = n / 2 - 1; i >= 0; i--)
                heapStep(array, n, i);  // Выводим наибольший эл-т

            for (int i = n - 1; i >= 0; i--) { // Уменьшаем длинну массива на 1 за каждую иттерацию
                    // Ф-ция перестановки эл=тов
                    int tamp = array[0];
                    array[0] = array[i];
                    array[i] = tamp;
                    heapStep(array, i, 0); //Рекурсивно вызывается метод heapStep на уменьшенном массиве
                }
            }

        public static void heapStep ( int[] array, int n, int rootIndex){
            int largest = rootIndex;  // За наибольший элемент принимается выбранный корневой индекс rootIndex
            int leftEl = 2 * rootIndex + 1;  // Индекс эл-та слева от корня
            int rightEl = 2 * rootIndex + 2;  // Индекс эл-та справа от корня

            // Если индекес эл-та слева менньше размера массива и значение эл-та слева больше значения корневого эл-та
            if (leftEl < n && array[leftEl] > array[largest])
                largest = leftEl;  // То, в переменную наибольшего значения записывается эл-т слева

            // Если индекес эл-та справа менньше размера массива и значение эл-та справа больше значения корневого эл-та
            if (rightEl < n && array[rightEl] > array[largest])
                largest = rightEl;  // То, в переменную наибольшего значения записывается эл-т справа

            // Если индекс наибольшего эл-та не совпадает с корневым индексом проводится смена значений эл-тов местами
            if (largest != rootIndex) {
                int tamp = array[rootIndex]; // В переменную tamp записыватся значение корневого эл-та
                array[rootIndex] = array[largest];
                array[largest] = tamp;  //Значению корневого эл-та присваивается максимальное значение
                heapStep(array, n, largest); //Рекурсивно вызывается метод heapStep, выход из рекурсии False в уловии
            }
        }
    }