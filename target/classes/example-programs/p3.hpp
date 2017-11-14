@Persoon (:
    name : string.
    age : int.

    getAge() : int (:  >> my age. :)

    setAge(age : int) : int (:
        my age << age.
        >> age.
    :)

:)

@App (:

    onChange(old:int , newAge : int) : int (:
        show old, "becomes", newAge.
        >> old.
    :)

    run() : int (:
        p : Persoon.
        p << new Persoon.
        onChange ~> age of p.
        do setAge of p with 123.
        >> age of p.
    :)

:)

do run of new App.