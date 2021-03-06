package io.github.linianhui.springexample.service2;

import java.util.List;

import io.github.linianhui.springexample.service2.config.FeignH2PriorKnowledgeConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "service2",
    contextId = "blog",
    primary = false,
    url = Constants.URL,
    configuration = FeignH2PriorKnowledgeConfig.class,
    path = "/v1/blog"
)
public interface BlogClient {
    @PostMapping
    int createBlog(@RequestBody Object blog);

    @GetMapping(path = "{blogId}")
    Object getBlogById(@PathVariable(name = "blogId") int blogId);

    @GetMapping
    List<Object> getBlogList();
}
