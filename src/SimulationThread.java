

public class SimulationThread extends Thread {

    private SimulationRecorder recorder;
    private int iterations;
    
    public SimulationThread(SimulationRecorder recorder, int iterations) {
        this.recorder = recorder;
        this.iterations = iterations;
    }
    
    @Override
    public void run() {
        for (long i = 0; i < iterations; ++i) {
            recorder.record(i % 80);
        }
    }
}
