package com.diego.sqs.infrastructure.sqs;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class BlockingSubmissionPolicy implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            executor.getQueue().put(r); // Reinsere a task na fila de execução caso esteja cheia
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
