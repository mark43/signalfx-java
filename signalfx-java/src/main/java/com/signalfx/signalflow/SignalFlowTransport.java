/*
 * Copyright (C) 2016 SignalFx, Inc. All rights reserved.
 */
package com.signalfx.signalflow;

import java.util.Map;

/**
 * Interface for transports to the SignalFlow API
 * 
 * @author dgriff
 */
public interface SignalFlowTransport {
    
    /**
     * Default host for signalflow
     */
    public static final String DEFAULT_HOST = "stream.signalfx.com";

    /**
     * Attach to an existing SignalFlow computation.
     * 
     * @param handle
     *            computation id
     * @param parameters
     *            computation parameters
     * @return
     */
    public Channel attach(String handle, Map<String, String> parameters);

    /**
     * Execute the given SignalFlow program and stream the output back.
     * 
     * @param program
     *            computation written in signalflow language
     * @param parameters
     * @return
     */
    public Channel execute(String program, Map<String, String> parameters);

    /**
     * Start executing the given SignalFlow program without being attached to the output of the
     * computation.
     * 
     * @param program
     *            computation written in signalflow language
     * @param parameters
     *            computation parameters
     */
    public void start(String program, Map<String, String> parameters);

    /**
     * Stop a SignalFlow computation.
     * 
     * @param handle
     *            computation id
     * @param parameters
     *            computation parameter
     */
    public void stop(String handle, Map<String, String> parameters);

    /**
     * Close this SignalFlow transport.
     * 
     * @param code
     *            numeric error id
     * @param reason
     *            Optional description of why closing
     */
    public void close(int code, String reason);

    /**
     * Keepalive a SignalFlow computation.
     * 
     * @param handle
     *            computation id
     */
    public void keepalive(String handle);
}
