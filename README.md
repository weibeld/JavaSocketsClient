# Programming With Sockets: Client

Simple client application:

- Creates a socket for communication with a server on a specified destination host and destination port (class `Socket`)
- Reads lines from standard input and sends them to the server
- Prints the response from the server to standard output

Source: [Oracle Tutorials](https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html)

## Compile

### Compile only

~~~bash
mvn compile
~~~

### Compile and create executable JAR

~~~bash
mvn package
~~~

## Usage

~~~bash
java -jar my-client-1.0-SNAPSHOT.jar localhost 4000
~~~

The first argument (localhost) is the destination host name. It can be replaced with any accessible host name.

The second argument (4000) is the port number on which the server is listening for connections. It must be the same as the one configured for the server.

To terminate the connection, type an end-of-input character (Ctrl-D).
