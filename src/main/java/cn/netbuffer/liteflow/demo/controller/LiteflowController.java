package cn.netbuffer.liteflow.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.script.ScriptExecutorFactory;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
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
        log.debug("exec chain[{}] return code={},getExecuteStepStrWithoutTime={},getMessage={},getRequestId={},slot={}", chainId,
                liteflowResponse.getCode(), liteflowResponse.getExecuteStepStrWithoutTime(),
                liteflowResponse.getMessage(), liteflowResponse.getRequestId(), liteflowResponse.getSlot());
        return liteflowResponse.isSuccess();
    }


    @GetMapping("execute2Future/{chainId}")
    public boolean execute2Future(@PathVariable("chainId") String chainId) throws ExecutionException, InterruptedException {
        Future<LiteflowResponse> liteflowResponseFuture = flowExecutor.execute2Future(chainId, null);
        LiteflowResponse liteflowResponse = liteflowResponseFuture.get();
        log.debug("exec chain[{}] return isSuccess={}", chainId, liteflowResponse.isSuccess());
        return liteflowResponse.isSuccess();
    }

    @GetMapping("reloadScript")
    public void reloadScript(String nodeId, String script) {
        ScriptExecutorFactory.loadInstance().getScriptExecutor().load(nodeId, script);
    }

}
