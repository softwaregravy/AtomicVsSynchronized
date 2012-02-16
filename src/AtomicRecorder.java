import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicRecorder implements SimulationRecorder {

    private final AtomicInteger sampleCount;
    private final AtomicInteger maxValue;
    private final AtomicLong sumValues;

    private final AtomicInteger overSeventyFive;
    private final AtomicInteger overSixty;

    public AtomicRecorder() {
        sampleCount = new AtomicInteger();
        maxValue = new AtomicInteger();
        sumValues = new AtomicLong();
        overSixty = new AtomicInteger();
        overSeventyFive = new AtomicInteger();
    }

    @Override
    public int record(long val) {
        sumValues.addAndGet(val);
        int max = maxValue.intValue();
        if (val > max)
            maxValue.compareAndSet(max, (int) val);
        if (val > 60)
            overSixty.incrementAndGet();
        if (val > 75)
            overSeventyFive.incrementAndGet();

        return sampleCount.incrementAndGet();
    }

}
