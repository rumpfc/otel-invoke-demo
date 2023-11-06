package com.rumpfc.demo.service;

import com.rumpfc.demo.sample.LogicExecutor;
import com.rumpfc.demo.sample.SampleLogic;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class LogicExecutionService {

    @WithSpan
    public void callNormally() {
        log.info("Calling methods normally");

        SampleLogic sl = new SampleLogic();

        sl.logic1();
        sl.logic2();
    }

    @WithSpan
    public void callByInvocation() {
        log.info("Calling methods by invocation");

        SampleLogic sl = new SampleLogic();
        List<Method> methods = Arrays.stream(SampleLogic.class.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(LogicExecutor.class))
                .toList();

        for (Method method : methods) {
            try {
                method.invoke(sl);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error("Could not call method {}", method, e);
            }
        }
    }
}
