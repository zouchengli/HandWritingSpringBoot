package site.clzblog.handwriting.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Desc Home controller
 * @Author chengli.zou
 * @CreateDate 6/12/18
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}
