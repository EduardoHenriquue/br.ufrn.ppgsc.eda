package datastructures;




/**
 * Created by eduardohenrique on 23/05/17.
 */
public class DoubleEndedQueue {

    private int leftTail = -1;
    private int rightTail = -1;

    public DoubleEndedQueue(){}

    /**
     * This method Inserts the key into the left tail of the deque
     * @param deque
     * @param key
     */
    public void insertIntoLeftTail(Integer[] deque, int key) throws Exception{
        if(dequeIsFull(deque)){
            throw new Exception("Deque is full!");
        }
        if(deque.length != 0){
            for (int i = this.rightTail; i >=0; i--){
                deque[i+1] = deque[i];
            }
            deque[0] = key;
            this.rightTail+=1;
        } else {
            this.leftTail+=1;
            this.rightTail+=1;
            deque[this.leftTail] = key;
        }
    }

    /**
     * This method Inserts the key into the right tail of the deque
     * @param deque
     * @param key
     */
    public void insertIntoRightTail(Integer[] deque, int key) throws Exception{
        if(dequeIsFull(deque)){
            throw new Exception("Deque is full!");
        }
        if(deque.length != 0){
            deque[rightTail+1] = key;
            this.rightTail+=1;
        } else{
            this.leftTail+=1;
            this.rightTail+=1;
            deque[this.rightTail] = key;
        }
    }

    /**
     * This method deletes the key of the left tail of the deque
     * @param deque
     * @return
     * @throws Exception
     */
    public int deleteKeyLeftTail(Integer[] deque) throws Exception{
        int key;
        if (deque.length == 0){
            throw new Exception("Deque is empty");
        } else {
            key = deque[rightTail];
            deque[rightTail] = null;
            for(int i = 1; i < this.rightTail-1; i++){
                deque[i-1] = deque[i];
            }
            this.rightTail-=1;
        }
        return key;
    }

    /**
     * This method deletes the key of the right tail of the deque
     * @param deque
     * @return
     * @throws Exception
     */
    public int deleteKeyRightTail(Integer[] deque) throws Exception{
        int key;
        if(deque.length == 0){
            throw new Exception("Deque is empty!");
        } else {
            key = deque[this.rightTail];
            deque[this.rightTail] = null;
            this.rightTail-=1;
        }
        return key;
    }

    /**
     * This method returns a boolean value if the deque is full
     * @param deque
     * @return
     */
    public boolean dequeIsFull(Integer[] deque){
        int cont = 0;
        for (Integer i: deque){
            if(deque[i] != null){
                cont++;
            }
        }
        return deque.length == cont;
    }
}
