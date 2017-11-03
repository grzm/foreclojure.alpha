# 4Clojure.com problems and solutions

My workspace for [4Clojure.com](http://www.4clojure.com).

## Usage

Write a test. Write a solution.

To confirm, run

    boot test

Or, while working

    boot watch alt-test

## Note on 4Clojure.com `*clojure-version*`

4Clojure.com appears to be running Clojure 1.4.0, both from the
version declared as a dependency in its
[`project.clj`][foreclojure-project-clojure-version] and from runtime
inspection of the tests. For example, the following is a valid
solution for ["Sum It All Up"][sum-it-all-up].

```clojure
(partial reduce + (if (= {:major 1 :minor 4 :incremental 0}
                         (select-keys *clojure-version* [:major :minor :incremental]))
                      0 1))
```

[foreclojure-project-clojure-version]: https://github.com/4clojure/4clojure/blob/df100ececd47bc6d0dd03ee105c279fc21950f57/project.clj#L3
[sum-it-all-up]: http://www.4clojure.com/problem/24

As a result, some features of more recent versions (e.g., transducers)
are unfortunately unavailable.

## License

© 2017 Michael Glaesemann

Distributed under the MIT License. See LICENSE for details.
