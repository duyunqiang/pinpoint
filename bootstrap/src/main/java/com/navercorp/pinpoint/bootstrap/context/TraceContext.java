/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.bootstrap.context;

import com.navercorp.pinpoint.bootstrap.config.ProfilerConfig;
import com.navercorp.pinpoint.bootstrap.interceptor.MethodDescriptor;
import com.navercorp.pinpoint.common.ServiceType;
import com.navercorp.pinpoint.common.util.ParsingResult;

/**
 * @author emeroad
 * @author hyungil.jeong
 */
public interface TraceContext {

    Trace currentTraceObject();

    /**
     * return a trace whose sampling rate should be further verified
     * @return
     */
    Trace currentRawTraceObject();

    Trace continueTraceObject(TraceId traceID);

    Trace newTraceObject();

    void detachTraceObject();

//    ActiveThreadCounter getActiveThreadCounter();

    String getAgentId();

    String getApplicationName();

    long getAgentStartTime();

    short getServerTypeCode();

    String getServerType();

    int cacheApi(MethodDescriptor methodDescriptor);

    int cacheString(String value);

    ParsingResult parseSql(String sql);

    DatabaseInfo parseJdbcUrl(String sql);

    DatabaseInfo createDatabaseInfo(ServiceType type, ServiceType executeQueryType, String url, int port, String databaseId);

    TraceId createTraceId(String transactionId, long parentSpanID, long spanID, short flags);

    Trace disableSampling();

    ProfilerConfig getProfilerConfig();

    Metric getRpcMetric(ServiceType serviceType);

    void recordContextMetricIsError();

    void recordContextMetric(int elapsedTime);

    void recordAcceptResponseTime(String parentApplicationName, short parentApplicationType, int elapsedTime);

    void recordUserAcceptResponseTime(int elapsedTime);
    
    ServerMetaDataHolder getServerMetaDataHolder();
    
}
