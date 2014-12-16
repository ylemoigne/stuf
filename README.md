STUF
====
Streams. Tuples. Utils. Functions.
----------------------------------

STUF is library which add some utils class and interface in Java mainly (but not only) usefull in the context of Streams and Lambda.

Streams.
--------
Streams provide utilities such as construct of finite Stream from Supplier, Iterable, Iterator.
It also provide basic utilities around Tuples such as Zipping and Unzipping.

Tuples.
-------
Simple classes to represent Tuples up to 26 component.

NOTE : Tuples are usefull as temporary structure in stream processing.
Since they have no proper meaning, properly named object explaining your intent are better suitable for API.
I provide Tuples up to 26 component for convenience but such high tuple put high risk on understandability and maintainability of your code.

Utils.
------
The Optionals class help to combine Optional into Tuples.
The Try class provide a monadic way to represent processing error.

Functions.
----------
Simple interface representing function up to 26 parameters.
Interface are conceived to works well also with tuples.
