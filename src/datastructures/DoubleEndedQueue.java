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
        if(this.getLeftTail() == 0){
            for (int i = this.getRightTail(); i >= 0; i--){
                deque[i+1] = deque[i];
            }
            deque[this.getLeftTail()] = key;
            this.setRightTail(this.getRightTail()+1);
        } else {
            this.setLeftTail(this.getLeftTail()+1);
            this.setRightTail(this.getRightTail()+1);
            deque[this.getLeftTail()] = key;
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
        if(deque.length == 0){
            deque[getRightTail()+1] = key;
            this.setRightTail(this.getRightTail()+1);
        } else{
            this.setLeftTail(this.getLeftTail()+1);
            this.setRightTail(this.getRightTail()+1);
            deque[this.getRightTail()] = key;
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
        if (this.getLeftTail() == -1){
            throw new Exception("Deque is empty");
        } else {
            key = deque[this.getLeftTail()];
            for(int i = 0; i < this.getRightTail(); i++){
                deque[i] = deque[i+1];
            }
            this.setRightTail(this.getRightTail()-1);
            deque[this.getRightTail()+1] = null;
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
        if(this.getLeftTail() == -1){
            throw new Exception("Deque is empty!");
        } else {
            key = deque[this.getRightTail()];
            this.setRightTail(this.getRightTail()-1);
            deque[this.getRightTail()+1] = null;
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
        for (Integer d: deque){
            if(d != null){
                cont++;
            }
        }
        return deque.length == cont;
    }

    public String printDeque(Integer[] deque) {
        String print = "";
        for (Integer d: deque){
            print = print + " "+d+",";
        }
        return print;
    }

    public int getLeftTail() {
        return leftTail;
    }

    public void setLeftTail(int leftTail) {
        this.leftTail = leftTail;
    }

    public int getRightTail() {
        return rightTail;
    }

    public void setRightTail(int rightTail) {
        this.rightTail = rightTail;
    }
}
