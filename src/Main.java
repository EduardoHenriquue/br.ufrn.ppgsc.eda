import datastructures.DoubleEndedQueue;

import javax.swing.*;

/**
 * Created by eduardohenrique on 23/05/17.
 */
public class Main {

    public static void main(String[] args){
        boolean sair = false;
        Integer[] queue = new Integer[10];
        DoubleEndedQueue deque = new DoubleEndedQueue();

        while(!sair){

            int opt = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "DOUBLE ENDED QUEUE\n" +
                    "Insert elements into both tails.\n\n" +
                            "Queue: {"+deque.printDeque(queue)+"}\n\n" +
                            "Choose an option:\n" +
                            "1. To INSERT into Left Tail\n" +
                            "2. To INSERT into Right Tail \n" +
                            "3. To DELETE of the Left Tail\n" +
                            "4. To DELETE of the Right Tail\n" +
                            "5. Sair"));

            switch (opt){
                case 1:
                    int inputL = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Type an Integer number\n" +
                            " and click in 'OK' to insert."));
                    try {
                        deque.insertIntoLeftTail(queue, inputL);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    int inputR = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Type an Integer number\n" +
                                    " and click in 'OK' to insert."));
                    try {
                        deque.insertIntoRightTail(queue, inputR);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    String keyL;
                    try {
                        keyL = Integer.toString(deque.deleteKeyLeftTail(queue));
                        keyL = "The element "+keyL+" has been removed.";
                    } catch (Exception e) {
                        keyL = e.getMessage();
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, keyL);
                    break;
                case 4:
                    String keyR;
                    try {
                        keyR = Integer.toString(deque.deleteKeyRightTail(queue));
                        keyR = "The element "+keyR+" has been removed.";
                    } catch (Exception e) {
                        keyR = e.getMessage();
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, keyR);
                    break;

                case 5:
                    sair = true;
                    break;
            }
        }

    }
}
