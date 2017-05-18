package pl.kwi.springboot.controllers.abstr;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping(value="/{loc}")
public abstract class AbstractController {

    @ModelAttribute("locale")
    public Locale createLocale(@PathVariable(name = "loc") String loc) {
        return LocaleUtils.toLocale(loc);
    }

}
