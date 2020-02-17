package com.zmeev.springforprofessionals;

import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties prop;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        prop = new Properties();

        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("msf.properties"));
            String renderClass = prop.getProperty("renderer.class");
            String providerClass = prop.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(renderClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRender() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
