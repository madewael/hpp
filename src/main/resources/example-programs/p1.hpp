@App (:
    fib(n : int) : int (:
       show n.
       if ( (n<2) )
           >> n.
       else
          >> (do fib with (n-1) + do fib with (n-2)).
    :)

    run() : int (:
        show "res:".
        >> do fib with 5.
    :)

:)


do run of (new App)