package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebConfig extends Config {

    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("browser.version")
    String browserVersion();

    @Key("remote.enabled")
    @DefaultValue("false")
    boolean remoteEnabled();

    @Key("remote.url")
    String remoteUrl();

    @Key("remote.enable.vnc")
    @DefaultValue("true")
    boolean remoteEnableVnc();

    @Key("remote.enable.video")
    @DefaultValue("true")
    boolean remoteEnableVideo();
}
