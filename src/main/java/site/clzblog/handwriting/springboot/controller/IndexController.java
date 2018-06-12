package site.clzblog.handwriting.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.clzblog.handwriting.springboot.service.IndexService;

/**
 * @Desc Index controller
 * @Author chengli.zou
 * @CreateDate 6/12/18
 */

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/index", produces = "text/html;charset=UTF-8")
    public String index() {
        return indexService.index();
    }

}
