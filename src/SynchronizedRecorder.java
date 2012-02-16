
public class SynchronizedRecorder implements SimulationRecorder {

    private int sampleCount;
    private int maxValue;
    private long sumValues;

    private int overSeventyFive;
    private int overSixty;

    public SynchronizedRecorder() {
        sampleCount = 0;
        maxValue = 0;
        sumValues = 0;
        overSixty = 0;
        overSeventyFive = 0;
    }

    @Override
    public synchronized int record(long val) {
        sumValues += val;
        int max = maxValue;
        if (val > max)
            max = (int) val;
        if (val > 60)
            overSixty += 1;
        if (val > 75)
            overSeventyFive += 1;

        return ++sampleCount;
    }

}
