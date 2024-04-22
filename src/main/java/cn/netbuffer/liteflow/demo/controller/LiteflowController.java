package cn.netbuffer.liteflow.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.yomahub.liteflow.builder.LiteFlowNodeBuilder;
import com.yomahub.liteflow.builder.el.LiteFlowChainELBuilder;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.enums.ScriptTypeEnum;
import com.yomahub.liteflow.flow.FlowBus;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.flow.element.Node;
import com.yomahub.liteflow.script.ScriptExecutorFactory;
import com.yomahub.liteflow.script.validator.ScriptValidator;
import com.yomahub.liteflow.slot.DefaultContext;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("/liteflow")
public class LiteflowController {

    @Lazy
    @Resource
    private FlowExecutor flowExecutor;

    @GetMapping("execute2Resp/{chainId}")
    public boolean execute2Resp(@PathVariable("chainId") String chainId) {
        JSONObject param = new JSONObject();
        param.put("chain", chainId);
        param.put("time", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        LiteflowResponse liteflowResponse = flowExecutor.execute2Resp(chainId, param);
        DefaultContext defaultContext = liteflowResponse.getContextBean(DefaultContext.class);
        if (defaultContext != null) {
            Object result = defaultContext.getData("result");
            if (result != null) {
                log.debug("exec chain[{}] success,getData[result]={},result class={}", chainId, result, result.getClass().getName());
            }
            if (defaultContext.hasData("aviatorResult")) {
                log.debug("aviatorResult={}", defaultContext.getData("aviatorResult").toString());
            }
        }
        log.debug("exec chain[{}] return code={},getExecuteStepStrWithoutTime={},getMessage={},getRequestId={},slot={}", chainId,
                liteflowResponse.getCode(), liteflowResponse.getExecuteStepStrWithoutTime(),
                liteflowResponse.getMessage(), liteflowResponse.getRequestId(), liteflowResponse.getSlot());
        return liteflowResponse.isSuccess();
    }


    @GetMapping("execute2Future/{chainId}")
    public boolean execute2Future(@PathVariable("chainId") String chainId) throws ExecutionException, InterruptedException {
        StopWatch execStopWatch = new StopWatch("exec " + chainId);
        execStopWatch.start();
        Future<LiteflowResponse> liteflowResponseFuture = flowExecutor.execute2Future(chainId, null);
        execStopWatch.stop();
        log.debug("exec chain[{}] cost {}ms\n{}", chainId, execStopWatch.getTotalTimeMillis(), execStopWatch.prettyPrint());
        StopWatch getResultStopWatch = new StopWatch("get " + chainId + " result");
        getResultStopWatch.start();
        LiteflowResponse liteflowResponse = liteflowResponseFuture.get();
        getResultStopWatch.stop();
        log.debug("exec chain[{}] return isSuccess={} get result cost {}ms\n{}", chainId, liteflowResponse.isSuccess(),
                getResultStopWatch.getTotalTimeMillis(), getResultStopWatch.prettyPrint());
        return liteflowResponse.isSuccess();
    }

    @GetMapping("reloadScript")
    public void reloadScript(String nodeId, String script) {
        ScriptExecutorFactory
                .loadInstance()
                .getScriptExecutor(ScriptTypeEnum.JS.getEngineName())
                .load(nodeId, script);
    }

    @GetMapping("removeChain")
    public void removeChain(String chainId) {
        FlowBus.removeChain(chainId);
    }

    @GetMapping("reloadRule")
    public void reloadRule() {
        flowExecutor.reloadRule();
    }

    @PostMapping("dynamic/createCommonNode")
    public void createCommonNode(@RequestBody Map<String, String> body) {
        LiteFlowNodeBuilder
                .createCommonNode()
                .setId(body.get("id"))
                .setName(body.get("name"))
                .setClazz(body.get("class"))
                .build();
    }

    @PostMapping("dynamic/createScriptNode")
    public void createScriptNode(@RequestBody Map<String, String> body) {
        LiteFlowNodeBuilder
                .createScriptNode()
                .setId(body.get("id"))
                .setName(body.get("name"))
                .setLanguage(body.get("language"))
                .setScript(body.get("script"))
                .build();
    }

    @PostMapping("chain/validate")
    public boolean chainValidate(@RequestBody Map<String, String> body) {
        boolean isValidate = LiteFlowChainELBuilder.validate(body.get("el"));
        return isValidate;
    }

    @PostMapping("dynamic/createChain")
    public void createChain(@RequestBody Map<String, String> body) {
        String el = body.get("el");
        boolean isValidate = LiteFlowChainELBuilder.validate(el);
        if (!isValidate) {
            log.warn("el[{}] format error", el);
            return;
        }
        LiteFlowChainELBuilder
                .createChain()
                .setChainId(body.get("chainId"))
                .setEL(el).build();
    }

    @PostMapping("script/validate")
    public boolean scriptValidate(@RequestBody Map<String, String> body) {
        ScriptTypeEnum scriptTypeEnum = ScriptTypeEnum.getEnumByDisplayName(body.get("language"));
        boolean isValid = ScriptValidator.validate(body.get("script"), scriptTypeEnum);
        log.debug("script[{}] type[{}] validate result is {}", body.get("script"), scriptTypeEnum, isValid);
        return isValid;
    }

    @GetMapping("getNodesByChainId")
    public List<Node> getNodesByChainId(String chainId) {
        List<Node> nodeList = FlowBus.getNodesByChainId(chainId);
        return nodeList;
    }

}