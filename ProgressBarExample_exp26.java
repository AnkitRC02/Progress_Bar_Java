import javax.swing.*;

public class ProgressBarExample_exp26 extends JFrame {

    public ProgressBarExample_exp26() {
        setTitle("Progress Bar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a progress bar
        JProgressBar progressBar = new JProgressBar();

        // Set minimum and maximum values for the progress bar
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        // Set initial value for the progress bar
        progressBar.setValue(0);

        // Set string representation (optional)
        progressBar.setStringPainted(true);

        // Increase the value of the progress bar over time
        Thread progressThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    progressBar.setValue(i);
                    try {
                        Thread.sleep(100); // Simulate some task
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        progressThread.start();

        // Add the progress bar to the frame
        add(progressBar);

        // Set frame size and visibility
        setSize(400, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgressBarExample_exp26::new);
    }
}
