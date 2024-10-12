# Sample Galia Java Delegate

This is a sample Java delegate implementation for the Galia image server
(version 1.0).

# Development

For development, a Galia JAR must be present in the classpath. One way to
get it there is to run `mvn install` from the Galia source root, which will
install it into your local repository. (This is the method used by this
example.)

# How it works

The idea is to use Maven to build a JAR file that declares an implementation
of both `is.galia.delegate.Delegate` and the `is.galia.plugin.Plugin`
[service](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/class-use/ServiceLoader.html).
So you must have Maven installed, but that is the only dependency. You could
also use Gradle, or some other build tool--this is just an example.

`mvn package` will build a JAR file in the `target` directory. Copy it into
the `plugins` directory.

Once installed, it will be auto-detected and used automatically.

# Using dependencies

This example does not use any third-party dependencies, which keeps things
simple. But if you wanted to bring in other dependencies, the way other plugins
do it is by including them in a `lib` folder within the plugin's folder, where
the plugin class loader will find them.

When choosing a dependency, first check whether Galia includes it, and use
that, if possible. Bundling a different version of a dependency than the one
used by Galia could cause problems.

# Implementing methods for other plugins

In development, any plugins for which you'd like to implement delegate
methods must exist on the classpath (see above) alongside this one.

The JavaDelegate interface includes all delegate methods recognized by the
core Galia application. Plugins may define their own delegate methods and
invoke them via `invoke(String method, Object... args)`.

# API Compatibility

The Java delegate is more closely coupled to Galia API than the Ruby delegate,
so it is more susceptible to breakage across Galia updates. Because of that,
and because the performance benefit of Java is probably minuscule for most
delegate implementations (because they spend most of their time waiting on
I/O), it is recommended to use the Ruby delegate instead.
