package elk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {
    @GetMapping("/")
    public String index() {
        log.info("11");
        log.debug("22222");
        log.error("3333");
        return "index";
    }
}
