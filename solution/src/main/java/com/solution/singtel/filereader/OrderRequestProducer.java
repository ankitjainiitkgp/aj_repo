/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.solution.singtel.filereader;

import com.solution.singtel.common.Constants;
import com.solution.singtel.common.SolutionException;
import com.solution.singtel.model.OrderRequest;
import com.solution.singtel.utils.FileUtil;
import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;

/**
 * @author ankitkumarjain
 * @version $Id: OrderRequestProducer.java, v 0.1 2019-09-12 10:23 PM ankitkumarjain Exp $$
 */
public class OrderRequestProducer implements Runnable {

    @Autowired
    private Environment env;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        BufferedReader br = null;
        try {
            // get the filepath
            String filePath = env.getProperty(Constants.KEY_FILE_PATH_RELATIVE) + env.getProperty(Constants.KEY_FILE_NAME);

            // get bufferedReader for the filepath
            br = FileUtil.getFileBufferedReader(filePath);
            int linePointer = 0;

            while(true) {

                // check for wait
                checkAndWait();

                // get next line
                String line = FileUtil.getNextLine(br, filePath);

                if(line == null){
                    break;
                }
                linePointer++;

                // parse the line and create orderRequest object
                OrderRequest orderRequest = parseLine(line);

                // produce into queue
                if (orderRequest != null) {
                    // send message to rabbitMq queue.
                }

                // update pointer
                // store pointer in a file.
            }

        } catch (SolutionException se){

        } finally {
            if(br != null){
                try {
                    br.close();
                }catch (Exception e){

                }
            }
        }
    }

    private void checkAndWait(){

        Long maxQueueLimit = Long.getLong(env.getProperty(Constants.KEY_CERCUIT_BREAKER_QUEUE_SIZE_LIMIT));

        while(true) {
            // check queue size from msgBroker client
            Long currentQueueSize = 10L;

            if (currentQueueSize >= maxQueueLimit) {
                try {
                    wait(Long.getLong(env.getProperty(Constants.KEY_QUEUE_LIMIT_BREACH_WAIT_TIME_IN_MILIS)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }

    private OrderRequest parseLine(String line){
        if(StringUtils.isBlank(line)){
            return null;
        }

        String[] requestParams = StringUtils.split(line, ",");

        if(requestParams.length < 5){
            return null;
        }

        OrderRequest orderRequest = new OrderRequest();

        try {
            orderRequest.setOrderId(StringUtils.trim(requestParams[0]));
            orderRequest.setMerchantId(StringUtils.trim(requestParams[1]));
            orderRequest.setCreatedTime(StringUtils.trim(requestParams[2]));
            orderRequest.setAmount(Long.getLong(StringUtils.trim(requestParams[3])));
            orderRequest.setCurrency(StringUtils.trim(requestParams[4]));
            orderRequest.setCustomerId(StringUtils.trim(requestParams[5]));
            orderRequest.setExtendedInfo(StringUtils.trim(requestParams[6]));
        }catch (Exception e){
            return null;
        }

        return orderRequest;
    }
}