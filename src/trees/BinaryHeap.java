package trees;

/**
 * Created by eduardohenrique on 28/04/17.
 */
public class BinaryHeap {

//    int[] arrayA = {4,16,7,10,8,14,9,3,1,2};
//    Integer[] arrayA = new Integer[10];
    int heapSize = 0;

    public Integer[] maxHeapify(Integer[]A, int index){
        int largest;
        int l = left(index);
        int r = right(index);
        updateHeapSize(A);
        if(l <= getHeapSize() && A[l] > A[index]){
            largest = l;
        } else{
            largest = index;
        }
        if(r <= getHeapSize() && A[r] > A[largest]){
            largest = r;
        }
        if(largest != index){
            int aux = A[index];
            A[index] = A[largest];
            A[largest] = aux;
            maxHeapify(A,largest);
        }
        return A;
    }

    public Integer[] buildMaxHeap(Integer[]A){
        setHeapSize(A.length);
        int root = (int) Math.floor(A.length/2);
        for(int i = root; i > 0; i++){
            maxHeapify(A,i);
        }
        return A;
    }


    public int left(int index){
        return 2*index;
    }

    public int right(int index){
        return (2*index)+1;
    }

    public void updateHeapSize(Integer[] A){
        int cont = 0;
        for (int i = 0; i < A.length; i++){
            if(A[i] != null){
                cont++;
            }
        }
        setHeapSize(cont);
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public int getHeapSize(){
        return heapSize;
    }


}
