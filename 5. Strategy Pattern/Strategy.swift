protocol Strategy {
    func compare<T: Comparable>(data1: T, data2: T) -> T
}

class Bigger: Strategy {
    init() {}

    func compare<T: Comparable>(data1: T, data2: T) -> T {
        return data1 > data2 ? data1 : data2
    }
}

class Smaller: Strategy {
    init() {}

    func compare<T: Comparable>(data1: T, data2: T) -> T {
        return data1 < data2 ? data1 : data2
    }
}

var compare: Strategy
compare = Bigger()
print(compare.compare(data1: 30, data2: 100))
compare = Smaller()
print(compare.compare(data1: 30, data2: 100))