package services;

import com.google.inject.Singleton;
import ninja.scheduler.Schedule;

import java.util.concurrent.TimeUnit;

@Singleton
public class DataRestorationService {
    @Schedule(delay = 1, timeUnit = TimeUnit.MINUTES)
    public void restoreData() {
// restore BaseData that their status id dequeue
    }
}
