package controllers;

import com.google.inject.persist.Transactional;
import ninja.Result;
import ninja.jpa.UnitOfWork;
import ninja.params.PathParam;
import services.QueueService;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

@Singleton
public class DataController {
    @Inject
    private QueueService queueService;

    @Inject
    private Provider<EntityManager> entityManagerProvider;

    @Transactional
    public Result getData() {
        Object nextData = queueService.dequeue();
        return null;
    }

    @Transactional
    public Result restoreData(@PathParam("data") Integer data) {

        return null;
    }
}
