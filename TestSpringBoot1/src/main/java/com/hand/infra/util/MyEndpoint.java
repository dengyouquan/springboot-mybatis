package com.hand.infra.util;

import org.springframework.boot.actuate.endpoint.Endpoint;
public class MyEndpoint implements Endpoint<MemoInfo> {
    public String getId() {
        return "myendpoint";
    }
    public MemoInfo invoke() {
        MemoInfo memInfo = new MemoInfo();  
        Runtime runtime = Runtime.getRuntime();  
        memInfo.setMaxMemo(runtime.maxMemory());
        return memInfo;
    }
    public boolean isEnabled() {
        return true;
    }
    public boolean isSensitive() {
        return false;
    }
}