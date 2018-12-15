package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dao.BaseDataDao;
import ninja.scheduler.Schedule;

@Singleton
public class DataQueuingService {
    @Inject
    private BaseDataDao baseDataDao;

    @Schedule
    public void queueDequeueData() {

    }
}
