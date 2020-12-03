package thread;

import javafx.application.Platform;
import model.Ringlet;
import ui.DealerGUI;

public class RingletThread extends Thread { // class taken from Juan Manuel Reyes' repository https://github.com/seyerman/java-intermediate-course-examples/blob/master/jfx-thread-ringlete/src/thread/RingleteThread.java

    // -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

    private Ringlet ringlet;
    private DealerGUI dealerGUI;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /** Name: RingletThread
	 * Constructor method of a ringlet thread. <br>
     * @param ringlet - Ringlet in question - ringlet = Ringlet object, ringlet != null
     * @param dealerGUI - GUI controller - dealerGUI = DealerGUI object, dealerGUI != null
	*/
    public RingletThread(Ringlet ringlet, DealerGUI dealerGUI) {
        setDaemon(true);
        this.ringlet = ringlet;
        this.dealerGUI = dealerGUI;
    }

    /** Name: run
	 * Method used to run the ringlet threads created. <br>
     * <b>pre: </b> Ringlet object already created. List of squares already initialized. <br>
     * <b>post: </b> Ringlet threads ran. <br>
	*/
    @Override
    public void run() {
        while (ringlet.getSpin()) {
            ringlet.rotateSquares();
            Platform.runLater(new Thread() {

                @Override
                public void run() {
                    dealerGUI.updateRinglet();
                }
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}