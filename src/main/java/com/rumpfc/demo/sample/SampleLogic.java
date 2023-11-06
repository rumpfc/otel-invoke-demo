package com.rumpfc.demo.sample;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleLogic {

    @WithSpan
    @LogicExecutor
    public void logic1() {
        log.info("Logic #1 called");
    }

    @WithSpan
    @LogicExecutor
    public void logic2() {
        log.info("Logic #2 called");
    }
}
