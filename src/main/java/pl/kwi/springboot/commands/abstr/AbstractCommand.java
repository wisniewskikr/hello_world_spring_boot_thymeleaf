package pl.kwi.springboot.commands.abstr;

import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;

public abstract class AbstractCommand {

	
    private String loc;


    public Locale getLocale() {
        return LocaleUtils.toLocale(loc);
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}
