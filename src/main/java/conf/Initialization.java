package conf;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dao.BaseDataDao;
import ninja.lifecycle.Start;

@Singleton
public class Initialization {
    private static final int MAX_DATA_COUNT = 99;

    private BaseDataDao baseDataDao;

    @Inject
    public Initialization(BaseDataDao baseDataDao) {
        this.baseDataDao = baseDataDao;
    }

    @Start
    public void start() {
        createMasterRecords();
    }

    private void createMasterRecords() {
        if (baseDataDao.count() == 0) {
            baseDataDao.createData(MAX_DATA_COUNT);
        }
    }
}
