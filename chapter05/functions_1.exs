list_concat = fn(xs, ys) -> xs ++ ys end
list_concat.([:a, :b], [:c, :d])

sum = fn(x, y, z) -> x + y + z end
sum.(1, 2, 3)

pair_tuple_to_list = fn({x, y}) -> [x, y] end
pair_tuple_to_list.({1234, 5678})
