package com.aiit.utils.returns;

import org.springframework.stereotype.Component;

@Component
public interface BaseErrorInfoInterface {
 
    int getResultCode();
 
    String getResultMessage();
 
}