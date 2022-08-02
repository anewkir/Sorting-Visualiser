package project.main;


/*
ArrayData class

the goal of this class is to keep the data the same above all the object classes
along with dealing with the paining of the jFrame
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Random;

 public class ArrayData extends JComponent {

    private float[] arr;
    private int SIZE;
    private int currDex, travDex , moveDex;
    private final int WIDTH, HEIGHT;
    private final float BAR_WIDTH;
    private boolean isWorking;
    SwingWorker<Void,Void> shuffler;


    /*
    Constructor
    @Param constant: size, width, and height
    also calculates the bar width to fit the screen and draws the bars

     */
    public ArrayData(int SIZE, int WIDTH, int HEIGHT ){

        this.SIZE = SIZE;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.arr = new float[SIZE];
        this.BAR_WIDTH = (float)WIDTH / SIZE;
        this.isWorking = false;
        initBarHeight();
        initShuffler();

    }


    /*
    @Param none
    @Return array
     */
    public float[] getArr() {

        System.out.println(Arrays.toString(arr));
        return arr;
    }


    /*
    @Param none
    @Return array.length
     */
    public int getSIZE(){
        return arr.length;
    }



    /*
    @Param index
    @Return array[index]
     */
    public float getIndexVal(int index){

        return arr[index];

    }

    /*
        @Param index, argument
        @Return none
         */
    public void setIndexVal(int index , float arg){

        arr[index] = arg;

    }

        /*
        @Param index, argument
        @Return none
         */

    public void setCurrDex(int currDex) {
        this.currDex = currDex;
    }

        /*
        @Param index, argument
        @Return none
         */

    public void setTravDex(int travDex) {
        this.travDex = travDex;
    }




    /*
                    @Param indexA, indexB
                    @Return none

                    just swaps the array values
                     */
    public void swap(int indexA, int indexB){
         float temp = arr[indexA] ;

         arr[indexA] = arr[indexB];
         arr[indexB] = temp;

    }


    /*
    @Param Graphics g
    @Return none

    paint component for painting the jFrame

     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.LIGHT_GRAY);
        Rectangle2D.Float rect;


        for (int i = 0; i < SIZE; i++){
            rect = new Rectangle2D.Float(i * BAR_WIDTH, HEIGHT - getIndexVal(i), BAR_WIDTH, getIndexVal(i));
            g2d.fill(rect);
        }


        //red is  current rectangle
        g2d.setColor(Color.RED);
        rect = new Rectangle2D.Float(currDex * BAR_WIDTH, HEIGHT -  getIndexVal(currDex) , BAR_WIDTH, getIndexVal(currDex));
        g2d.fill(rect);

        // green is swap rectangle
        g2d.setColor(Color.GREEN);
        rect = new Rectangle2D.Float(travDex * BAR_WIDTH, HEIGHT - getIndexVal(travDex) , BAR_WIDTH, getIndexVal(travDex));

        g2d.fill(rect);


        g2d.setColor(Color.PINK);
        rect = new Rectangle2D.Float(moveDex * BAR_WIDTH, HEIGHT - getIndexVal(moveDex) , BAR_WIDTH, getIndexVal(moveDex));


        g2d.fill(rect);

    }


    /*
    @Param none
    @Return none

    just makes the repaint method accessible to other classes
     */
    public void repaintFrame(){

        repaint();

    }



    /*
    @Param none
    @Return none

    method draws the initial bars
     */
    private void initBarHeight(){
        float interval = (float) ((HEIGHT / SIZE));
        for (int i = 1;  i < SIZE; i++){
            setIndexVal(i, i * interval);
        }
    }


     public void initShuffler(){

        shuffler = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException{
                int middle = 1 + (SIZE - 1)/2; /// fix later 1 + (SIZE - 1)/2
                for(int i = 0, j = middle; i < middle; i++, j++){
                    int randomDex = new Random().nextInt(SIZE);
                    swap(i, randomDex);

                    randomDex = new Random().nextInt(SIZE);
                    swap(j,randomDex);

                    Thread.sleep(10);
                    repaint();

                }
                return null;
            }

            @Override
            public void done(){
                super.done();

            }


        };
         System.out.println(Arrays.toString(arr));
        shuffler.execute();

    }






}
