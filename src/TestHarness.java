public class TestHarness {

    /**
     * @param args
     */
    public static void main(String[] args) {

        SimulationRecorder subject = new AtomicRecorder();
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; ++i)
            threads[i] = new SimulationThread(subject, 20000000);
        for (int i = 0; i < numThreads; ++i)
            threads[i].start();
        for (int i = 0; i < numThreads; ++i)
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Failure: " + e.getMessage());
            }
    }

}
