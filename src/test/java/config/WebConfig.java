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
    @DefaultValue("126.0")
    String browserVersion();

    @Key("remote")
    boolean isRemote();

    @Key("remote.url")
    String remoteUrl();

    @Key("enableVNC")
    @DefaultValue("true")
    boolean enableVNC();

    @Key("enableVideo")
    @DefaultValue("true")
    boolean enableVideo();
}
