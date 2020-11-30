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

    public RingletThread(Ringlet ringlet, DealerGUI dealerGUI) {
        setDaemon(true);
        this.ringlet = ringlet;
        this.dealerGUI = dealerGUI;
    }

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