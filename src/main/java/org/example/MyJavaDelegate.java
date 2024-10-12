package org.example;

import is.galia.delegate.Delegate;
import is.galia.plugin.Plugin;
import is.galia.resource.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Many of the {@link Delegate} methods have default implementations. This
 * example (because it's only an example) overrides only a few of them.
 */
public class MyJavaDelegate implements Delegate, Plugin {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MyJavaDelegate.class);

    private RequestContext requestContext;

    //region Plugin methods

    @Override
    public Set<String> getPluginConfigKeys() {
        return Set.of();
    }

    @Override
    public String getPluginName() {
        return MyJavaDelegate.class.getSimpleName();
    }

    @Override
    public void onApplicationStart() {}

    @Override
    public void onApplicationStop() {}

    @Override
    public void initializePlugin() {
        LOGGER.info("Hello world!");
    }

    //endregion
    //region Delegate methods

    @Override
    public RequestContext getRequestContext() {
        return requestContext;
    }

    @Override
    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public Object authorizeBeforeAccess() {
        LOGGER.info("The identifier is: " + getRequestContext().getIdentifier());
        return true;
    }

    @Override
    public Object authorize() {
        return true;
    }

    /**
     * Invoked by {@link #invoke(String, Object...)}.
     */
    public String custom_plugin_method(Object... args) {
        return null;
    }

}

