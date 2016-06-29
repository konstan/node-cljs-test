# node-cljs-test

http://www.mase.io/code/clojure/node/2015/01/24/getting-started-with-clojurecript-and-node/

## Building

In addition to the usual clojure and clojurescript dependencies (java,
leiningen, etc.), you must also have `node` and `npm` (the node
package manager) installed.  On Mac OS X, you can install this via
`homebrew`:

```
$ brew install node
$ brew install npm
```

Once you've got the prerequisites installed, you should be able to
compile the code with:

```
$ lein cljsbuild once
```

If this is successful, you'll see a message like:

```
Successfully compiled "out/nct.js" in 9.059 seconds.
```

You are then ready to run the application via `node`. 

## Running

To run the application you'll need to install some dependencies for
`node`.  Use the `npm` command to install these.  They will be
installed into the root of the repository.

```
$ npm install websocket
$ npm install eventsource
$ npm install xhr2
```

When this is complete, you can run the application with:

```
$ node entrypoint.js
```

This should write out "Hello World main!", "STATUS: 200", and logging
for the actual HTTP requests.

To change the URL, edit the file `src/nct/core.cljs`, updating the
value for the local 'url' variable.

## Problems

You **cannot** set the variable `TIMBRE_NS_BLACKLIST` in your login
profile or your environment.  If you do, then the message to standard
output will end up in the code!

This will be the message when you try to run the code:

```
$ node entrypoint.js 
/Users/loomis/Documents/code/loomis/node-cljs-test/out/nct/core.js:2
Compile-time (elision) Timbre ns blacklist: ["kvlt.*"]
                       ^^^^^^
SyntaxError: Unexpected identifier
```

or

```
/Users/loomis/Documents/code/loomis/node-cljs-test/out/taoensso/timbre.js:2
Compile-time (elision) Timbre ns blacklist: ["kvlt.*"]
                       ^^^^^^
SyntaxError: Unexpected identifier                       
```

If you make this mistake, you'll need to do a `lein clean` to get a
complete rebuild of the javascript files.

## Legal

Copyright © 2016 Charles Loomis

Distributed under the Apache 2 license.

