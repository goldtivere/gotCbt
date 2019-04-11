package got.cbtproject.gotcbt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {




        return "index";
    }

    @RequestMapping({"/dashboard","/dashboard/index","/dashboard/index.html"})
    public String getDashBoard(Model model) {




        return "dashboard/index";
    }
}