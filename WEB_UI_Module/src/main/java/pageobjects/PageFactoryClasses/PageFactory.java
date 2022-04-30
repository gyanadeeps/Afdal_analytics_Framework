package pageobjects.PageFactoryClasses;

import utilities.LoggingHandler;

import java.lang.reflect.Proxy;

class PageFactory {

    @SuppressWarnings("unchecked")
    static <T> T wrap(T instance, Class<T> itf){
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(), new Class<?>[]{itf}, new LoggingHandler(instance)
        );
    }
}