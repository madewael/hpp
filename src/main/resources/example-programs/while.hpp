@App (:
    run() : int (:
        n : int.
        n << 5.

        while ( (n > 0) ) (:
            show n.
            n << (n - 1).
        :)

        >> 0.
    :)
:)

do run of new App.