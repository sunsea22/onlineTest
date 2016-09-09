import mergeSort.MergeSort;
import radixSort.RadixSort;

/**
 * Created by Sunsea on 16/9/9.
 */
public class Main {
    public static void main(String[] args) {
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};

        InsertSort insert = new InsertSort();
        insert.insertSort(a);

        ShellSort shell = new ShellSort();
        shell.shellSort(a);

        MergeSort merge = new MergeSort();
        merge.mergingSort(a);

        RadixSort radix = new RadixSort();
        radix.radixSort(a);
    }
}
