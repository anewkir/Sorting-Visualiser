package project.main;

import project.main.algos.BubbleSort;
import project.main.algos.MergeSort;
import project.main.algos.QuickSort;

import javax.swing.*;
import java.awt.*;


public class VisualSort extends JPanel {

   // private final long serialVersionUID = 1L;
private final int WIDTH = 1235, HEIGHT = (WIDTH * 9 /16);
private final int SIZE = 200;
private SwingWorker<Boolean, Boolean> shuffler, sorter;
private JFrame frame;

//classe
private ArrayData arrayData = new ArrayData(SIZE, WIDTH, HEIGHT);
private BubbleSort bubbleSort = new BubbleSort(arrayData);
private QuickSort quickSort = new QuickSort(arrayData);
private MergeSort mergeSort = new MergeSort(arrayData);



//>>menu bar and menu items
private JMenuBar menuBar;
private JMenu algoMenu;
private JButton button2;

//>> menu items for the
private JMenuItem sort1;
private JMenuItem sort2;
private JMenuItem sort3;








/*

constructor for the visualsort class

should add a bar instead of random buttons
*/

 VisualSort(){

     //invoke jFrame
     frame = new JFrame("VisualSort");
     algoMenu = new JMenu("Algorithms");
     menuBar = new JMenuBar();


    // add functionality to jbuttion
     button2 = new JButton("shuffle");
     button2.addActionListener(e -> arrayData.initShuffler());


     button2 = new JButton("shuffle");
     button2.addActionListener(e -> arrayData.initShuffler());


     //menu bar items

     sort1 = new JMenuItem("BubbleSort");
     sort2 = new JMenuItem("MergeSort");
     sort3 = new JMenuItem("QuickSort");
     button2 = new JButton("shuffle");

     button2.addActionListener(e -> arrayData.initShuffler());
     //menuBar.setPreferredSize(new Dimension(20,20));

     //add actions to the buttons in the menu
     sort1.addActionListener(e -> bubbleSort.bubbleSort());
     sort2.addActionListener(e -> mergeSort.mergeSort());
     sort3.addActionListener(e -> quickSort.quickSort());

     algoMenu.add(sort1);
     algoMenu.add(sort2);
     algoMenu.add(sort3);

     menuBar.add(button2);
     menuBar.add(algoMenu);


}


/*
method invokes the frame for the user to view

@Param none
@Return none

*/
public void openFrame (){


         //   JFrame frame = new JFrame("Algo Visualizer");


            frame.setJMenuBar(menuBar);
            frame.setContentPane(new VisualSort()); // sets the content pane of the frame




            frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));

            frame.getContentPane().setBackground(Color.BLACK);
            arrayData.setPreferredSize(new Dimension(WIDTH,HEIGHT));
            frame.add(arrayData);



            frame.add(new VisualSort());
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.validate();
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);



    }


}
